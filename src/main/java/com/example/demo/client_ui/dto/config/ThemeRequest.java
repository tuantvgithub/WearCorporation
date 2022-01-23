package com.example.demo.client_ui.dto.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ThemeRequest {

    @JsonProperty("id")
    private Integer userId;
}
