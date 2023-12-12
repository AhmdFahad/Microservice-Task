package com.ahamdah.s2.client;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

@Configuration
public class ElasticClientConfig extends ElasticsearchConfiguration  {
    private final String userName="elastic";
    private final String password="CGzGWfG1+2m5l5SSIAGk";

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder().
                connectedTo("localhost:9200").
                withBasicAuth(userName,password).
                build();
    }
}
