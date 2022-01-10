package com.example.demo.module.system_management.service.impl;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.module.system_management.service.SystemManagementService;
import org.springframework.stereotype.Service;

@Service("sp05-system-management")
public class SystemManagementServiceSP05Impl implements SystemManagementService {

    @Override
    public AccountRoleDTO getRole(String username) {
        return null;
    }
}
