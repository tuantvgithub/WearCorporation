package com.example.demo.module.account.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRole {
    
    @JsonProperty("id")
    private Integer userId;

    @JsonProperty("role")
    private Integer role;
}
