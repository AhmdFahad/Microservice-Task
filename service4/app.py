from flask import Flask, jsonify
from elasticsearch import Elasticsearch

app = Flask(__name__)

username = "elastic"
password = "CGzGWfG1+2m5l5SSIAGk"
id="M21qR1Nvd0IxcjRPR1VlMWJNLU86djk2Y0pWWjZSRXVJU2IwTXlKUnlXUQ=="
host="http://localhost:9200"
es = Elasticsearch(hosts=host,basic_auth=(username, password))
@app.route('/' , methods=['GET'])
def c():
    return es.info()


@app.route('/transaction/max', methods=['GET'])
def get_max_amount():
    query = {
        "aggs": {
            "amount_stats": {
                "stats": {
                    "field": "amount"
                }
            }
        }
    }

    try:
        result = es.search(index='transaction', body=query)
        amount_stats = result['aggregations']['amount_stats']
        max_amount = amount_stats['max']

        response = {
            "amount": max_amount,
        }

        return jsonify(response), 200
    except Exception as e:
        return jsonify({"error": str(e)}), 500


@app.route('/transaction/min', methods=['GET'])
def get_min_amount():
    query = {
        "aggs": {
            "amount_stats": {
                "stats": {
                    "field": "amount"
                }
            }
        }
    }

    try:
        result = es.search(index='transaction', body=query)
        amount_stats = result['aggregations']['amount_stats']
        min_amount = amount_stats['min']

        response = {
            "amount": min_amount
        }
        return jsonify(response), 200
    except Exception as e:
        return jsonify({"error": str(e)}), 500



if __name__ == '__main__':
    app.run(debug=True)

