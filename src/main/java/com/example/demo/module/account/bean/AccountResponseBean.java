package com.example.demo.module.account.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AccountResponseBean<T> {
    
    @JsonProperty("token")
    private String token;

    @JsonProperty("data")
    private T data;

    @JsonProperty("message")
    private String message;

    @JsonProperty("status")
    private Integer status;

}
