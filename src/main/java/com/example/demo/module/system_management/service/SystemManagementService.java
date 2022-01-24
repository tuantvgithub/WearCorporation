package com.example.demo.module.system_management.service;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.client_ui.dto.account.UserRoleDTO;
import com.example.demo.client_ui.dto.config.ThemeDTO;
import com.example.demo.client_ui.dto.config.ThemeRequest;
import com.example.demo.module.account.bean.UserRole;
import com.example.demo.module.system_management.bean.sp03.ModuleCode;
import com.example.demo.module.system_management.bean.sp03.TeamCode;

import java.util.Map;

public interface SystemManagementService {

    AccountRoleDTO getRoleByEmail(String email);
    AccountRoleDTO getRole(UserRole userRole);
    UserRoleDTO setRole(UserRole userRole);
    ThemeDTO getTheme(ThemeRequest themeRequest);

    String getTeamName(ModuleCode moduleCode);
    void loadModules(ModuleCode... moduleCodes);
    String setModule(ModuleCode moduleCode, String teamName);
}
