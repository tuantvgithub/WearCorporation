package com.example.demo.module.system_management.bean.sp03;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SP03RoleConfigBean {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("role")
    private Integer role;
}
