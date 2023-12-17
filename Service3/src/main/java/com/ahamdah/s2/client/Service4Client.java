package com.ahamdah.s2.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("Service4")
public interface Service4Client {
    @GetMapping("/transaction/min")
    public ResponseEntity<String> getMin();
}
