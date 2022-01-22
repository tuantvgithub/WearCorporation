package com.example.demo.module.system_management.service;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.module.account.bean.UserRole;

public interface SystemManagementService {

    AccountRoleDTO getRoleByEmail(String email);
    AccountRoleDTO getRoleByAccountId(UserRole userRole);

    AccountRoleDTO setRole(UserRole userRole);


}
