package com.example.demo.module.system_management.mapping.impl;

import com.example.demo.config.module.ModuleConfig;
import com.example.demo.module.system_management.bean.sp03.ModuleCode;
import com.example.demo.module.system_management.bean.sp03.TeamCode;
import com.example.demo.module.system_management.mapping.SystemManagementMapping;
import org.springframework.stereotype.Component;

@Component
public class SystemManagementMappingImpl implements SystemManagementMapping {

    @Override
    public String teamCodeToTeamName(TeamCode teamCode) {
        if (teamCode == null) return null;
        if (teamCode == TeamCode.SP01)
            return "sp01-order";
        if (teamCode == TeamCode.SP06)
            return "sp06-order";
        if (teamCode == TeamCode.SP07)
            return "sp07-delivery";
        if (teamCode == TeamCode.SP08)
            return "sp08-account";
        if (teamCode == TeamCode.SP11)
            return "sp11-product";
        if (teamCode == TeamCode.SP14)
            return "sp14-account";
        if (teamCode == TeamCode.SP15)
            return "sp15-delivery";
        if (teamCode == TeamCode.SP16)
            return "sp16-order";
        if (teamCode == TeamCode.SP17)
            return "sp17-product";
        if (teamCode == TeamCode.SP21)
            return "sp21-customer-care";

        return null;
    }

    @Override
    public TeamCode teamNameToTeamCode(String teamName) {
        if (teamName == null) return null;

        if (teamName.contains("sp01"))
            return TeamCode.SP01;
        if (teamName.contains("sp06"))
            return TeamCode.SP06;
        if (teamName.contains("sp07"))
            return TeamCode.SP07;
        if (teamName.contains("sp08"))
            return TeamCode.SP08;
        if (teamName.contains("sp11"))
            return TeamCode.SP11;
        if (teamName.contains("sp14"))
            return TeamCode.SP14;
        if (teamName.contains("sp15"))
            return TeamCode.SP15;
        if (teamName.contains("sp17"))
            return TeamCode.SP17;
        if (teamName.contains("sp16"))
            return TeamCode.SP16;
        if (teamName.contains("sp21"))
            return TeamCode.SP21;

        return null;
    }

    @Override
    public String moduleCodeToModuleName(ModuleCode moduleCode) {
        if (moduleCode == null) return null;
        if (moduleCode == ModuleCode.ACCOUNT_MODULE)
            return ModuleConfig.ACCOUNT_MODULE_NAME;
        if (moduleCode == ModuleCode.ORDER_MODULE)
            return ModuleConfig.ORDER_MODULE_NAME;
        if (moduleCode == ModuleCode.CUSTOMER_CARE_MODULE)
            return ModuleConfig.CUSTOMER_CARE_MODULE_NAME;
        if (moduleCode == ModuleCode.PRODUCT_MODULE)
            return ModuleConfig.PRODUCT_MODULE_NAME;
        if (moduleCode == ModuleCode.DELIVERY_MODULE)
            return ModuleConfig.DELIVERY_MODULE_NAME;

        return null;
    }
}
