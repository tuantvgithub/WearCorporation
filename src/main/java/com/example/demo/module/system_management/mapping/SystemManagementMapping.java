package com.example.demo.module.system_management.mapping;

import com.example.demo.module.system_management.bean.sp03.ModuleCode;
import com.example.demo.module.system_management.bean.sp03.TeamCode;

public interface SystemManagementMapping {

    String teamCodeToTeamName(TeamCode teamCode);
    TeamCode teamNameToTeamCode(String teamName);
    String moduleCodeToModuleName(ModuleCode moduleCode);
}
