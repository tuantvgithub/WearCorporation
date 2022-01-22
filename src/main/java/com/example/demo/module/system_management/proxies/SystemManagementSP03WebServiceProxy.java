package com.example.demo.module.system_management.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


import com.example.demo.module.account.bean.UserRole;

@FeignClient(name = "sp03-api", url = "https://ltct-sp03-api.herokuapp.com/api")
public interface SystemManagementSP03WebServiceProxy {

    @PostMapping("/user/get-role/from-id")
    ResponseEntity<Map<String, Object>> getRole(@RequestParam UserRole userRole);
    
    @PostMapping("/user/set-role/for-id")
    ResponseEntity<Map<String, Object>> setRole(@RequestBody UserRole userRole);
}

