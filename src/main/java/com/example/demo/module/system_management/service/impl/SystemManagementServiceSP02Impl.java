package com.example.demo.module.system_management.service.impl;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.client_ui.dto.account.UserRoleDTO;
import com.example.demo.client_ui.dto.config.ThemeDTO;
import com.example.demo.client_ui.dto.config.ThemeRequest;
import com.example.demo.module.account.bean.UserRole;
import com.example.demo.module.system_management.bean.sp03.ModuleCode;
import com.example.demo.module.system_management.bean.sp03.TeamCode;
import com.example.demo.module.system_management.service.SystemManagementService;

import org.springframework.stereotype.Service;

@Service("sp02-sys-management")
public class SystemManagementServiceSP02Impl implements SystemManagementService {

    @Override
    public AccountRoleDTO getRoleByEmail(String email) {
        return AccountRoleDTO.SALESMAN;
    }

    @Override
    public AccountRoleDTO getRole(UserRole userRole) {
        return AccountRoleDTO.SALESMAN;
    }

   

    @Override
    public ThemeDTO getTheme(ThemeRequest themeRequest) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserRoleDTO setRole(UserRole userRole) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getTeamName(ModuleCode moduleCode) {
        return null;
    }

    @Override
    public void loadModules(ModuleCode... moduleCodes) {

    }

    @Override
    public String setModule(ModuleCode moduleCode, String teamName) {
        return null;
    }
}
