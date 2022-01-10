package com.example.demo.module.system_management.service.impl;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.module.system_management.service.SystemManagementService;
import org.springframework.stereotype.Service;

@Service("sp03-system-management")
public class SystemManagementServiceSP03Impl implements SystemManagementService {

    @Override
    public AccountRoleDTO getRole(String username) {
        return null;
    }
}
