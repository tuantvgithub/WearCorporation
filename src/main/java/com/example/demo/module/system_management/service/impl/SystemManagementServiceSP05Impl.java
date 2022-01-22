package com.example.demo.module.system_management.service.impl;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.module.system_management.service.SystemManagementService;
import org.springframework.stereotype.Service;

@Service("sp05-sys-management")
public class SystemManagementServiceSP05Impl implements SystemManagementService {

    @Override
    public AccountRoleDTO getRoleByEmail(String email) {
        return null;
    }

    @Override
    public AccountRoleDTO getRoleByAccountId(String id) {
        return null;
    }
}
