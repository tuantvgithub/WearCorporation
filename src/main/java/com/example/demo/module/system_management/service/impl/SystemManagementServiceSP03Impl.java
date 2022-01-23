package com.example.demo.module.system_management.service.impl;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.config.module.ModuleConfig;
import com.example.demo.module.account.bean.UserRole;
import com.example.demo.module.system_management.proxies.SystemManagementSP03WebServiceProxy;
import com.example.demo.module.system_management.service.SystemManagementService;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Service("sp03-sys-management")
@Slf4j
public class SystemManagementServiceSP03Impl implements SystemManagementService {

    @Autowired
    private ModuleConfig moduleConfig;

    @Autowired
    private SystemManagementSP03WebServiceProxy webServiceProxy;

    @Override
    public AccountRoleDTO getRoleByEmail(String email) {
        return null;
    }

    @Override
    public AccountRoleDTO getRole(UserRole userRole) {
        return AccountRoleDTO.BUYER;
//        try {
//            ResponseEntity<Map<String, Object>> res = this.webServiceProxy.getRole(userRole);
//            if (res == null || !res.getStatusCode().is2xxSuccessful())
//                return AccountRoleDTO.GUEST_ROLE;
//
//            Map<String, Object> data = res.getBody();
//            if (data == null)
//                return AccountRoleDTO.GUEST_ROLE;
//
//            if ((int) data.get("role") == 0) return AccountRoleDTO.BUYER;
//            if ((int) data.get("role") == 1) return AccountRoleDTO.SALESMAN;
//            if ((int) data.get("role") == 2) return AccountRoleDTO.IT_TECHNICIAN;
//            if ((int) data.get("role") == 3) return AccountRoleDTO.SHIPPING_MANAGER;
//        } catch (Exception ignore) {
//            log.error(ignore.getMessage(), ignore.getCause());
//            return AccountRoleDTO.GUEST_ROLE;
//        }
//        return AccountRoleDTO.GUEST_ROLE;
    }

    @Override
    public boolean setRole(UserRole userRole) {
        if (userRole == null) return false;

        try {
            Map<String, Object> res = this.webServiceProxy.setRole(userRole);
        } catch (Exception ignore) {
            return false;
        }

        return true;
    }
}
