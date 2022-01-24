package com.example.demo.module.system_management.bean.sp03;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SP03ThemeConfigBean {
    
    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("theme")
    private String theme;

    @JsonProperty("language")
    private String language;

    @JsonProperty("font-size")
    private Integer fontSize;
}
