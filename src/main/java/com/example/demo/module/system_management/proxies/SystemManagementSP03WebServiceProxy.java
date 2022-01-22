package com.example.demo.module.system_management.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "sp03-api", url = "https://ltct-sp03-api.herokuapp.com/api")
public interface SystemManagementSP03WebServiceProxy {

    @GetMapping("/user/get-role/from-id")
    ResponseEntity<Map<String, Object>> getRole(@RequestParam Map<String, Object> params);
}
