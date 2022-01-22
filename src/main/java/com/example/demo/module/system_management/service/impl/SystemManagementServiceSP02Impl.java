package com.example.demo.module.system_management.service.impl;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.module.account.bean.UserRole;
import com.example.demo.module.system_management.service.SystemManagementService;

import org.springframework.stereotype.Service;

@Service("sp02-sys-management")
public class SystemManagementServiceSP02Impl implements SystemManagementService {

    @Override
    public AccountRoleDTO getRoleByEmail(String email) {
        if (email.equals("admin@gmail.com"))
            return AccountRoleDTO.ADMIN_ROLE;

        return AccountRoleDTO.USER_ROLE;
    }

    @Override
    public AccountRoleDTO getRoleByAccountId(UserRole uRole) {
        if (uRole.getRole() != null) {

            if (uRole.getRole().equals(2))
                return AccountRoleDTO.ADMIN_ROLE;
        }

        return AccountRoleDTO.USER_ROLE;
    }

    @Override
    public AccountRoleDTO setRole(UserRole userRole) {
        // TODO Auto-generated method stub
        return null;
    }
}
