package com.example.demo.module.account.bean;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SP14ErrorMessageBean {

    @JsonProperty("message")
    private String message;

    @JsonProperty("error")
    private Map<String,Object> errors;
}
