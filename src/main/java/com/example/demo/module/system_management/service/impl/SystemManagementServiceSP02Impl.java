package com.example.demo.module.system_management.service.impl;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.module.system_management.service.SystemManagementService;
import org.springframework.stereotype.Service;

@Service("sp02-system-management")
public class SystemManagementServiceSP02Impl implements SystemManagementService {

    @Override
    public AccountRoleDTO getRole(String username) {
        if (username.equals("admin@gmail.com")) return AccountRoleDTO.ADMIN_ROLE;

        return AccountRoleDTO.USER_ROLE;
    }
}
