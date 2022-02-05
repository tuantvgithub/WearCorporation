package com.example.demo.module.system_management.bean.sp03;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SP03ModuleBean {
    @JsonProperty("module")
    private Integer module;

    @JsonProperty("name")
    private String name;
}
