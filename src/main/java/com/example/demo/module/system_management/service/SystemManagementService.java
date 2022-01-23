package com.example.demo.module.system_management.service;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.client_ui.dto.account.UserRoleDTO;
import com.example.demo.client_ui.dto.config.ThemeDTO;
import com.example.demo.client_ui.dto.config.ThemeRequest;
import com.example.demo.module.account.bean.UserRole;

public interface SystemManagementService {

    AccountRoleDTO getRoleByEmail(String email);
    AccountRoleDTO getRole(UserRole userRole);
    UserRoleDTO setRole(UserRole userRole);
    ThemeDTO getTheme(ThemeRequest themeRequest);
}
