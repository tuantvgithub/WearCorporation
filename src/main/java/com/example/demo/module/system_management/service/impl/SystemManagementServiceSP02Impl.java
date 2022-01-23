package com.example.demo.module.system_management.service.impl;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.module.account.bean.UserRole;
import com.example.demo.module.system_management.service.SystemManagementService;

import org.springframework.stereotype.Service;

@Service("sp02-sys-management")
public class SystemManagementServiceSP02Impl implements SystemManagementService {

    @Override
    public AccountRoleDTO getRoleByEmail(String email) {
        return AccountRoleDTO.BUYER;
    }

    @Override
    public AccountRoleDTO getRole(UserRole userRole) {
        return AccountRoleDTO.BUYER;
    }

    @Override
    public boolean setRole(UserRole userRole) {
        return true;
    }
}
