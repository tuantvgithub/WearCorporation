package com.example.demo.module.system_management.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import com.example.demo.client_ui.dto.config.ThemeDTO;
import com.example.demo.client_ui.dto.config.ThemeRequest;
import com.example.demo.module.account.bean.UserRole;
import com.example.demo.module.system_management.bean.sp03.SP03RoleConfigBean;
import com.example.demo.module.system_management.bean.sp03.SP03ThemeConfigBean;

@FeignClient(name = "sp03-api", url = "https://ltct-sp03-api.herokuapp.com/api")
public interface SystemManagementSP03WebServiceProxy {

    @PostMapping("/user/get-role/for-post")
    SP03RoleConfigBean getRole(@RequestBody UserRole userRole);
    
    @PostMapping("/user/set-role/for-id")
    SP03RoleConfigBean setRole(@RequestBody UserRole userRole);

    @PostMapping("/user/get-screen-config/from-id")
    SP03ThemeConfigBean getConfig(@RequestBody ThemeRequest data);
    
}

