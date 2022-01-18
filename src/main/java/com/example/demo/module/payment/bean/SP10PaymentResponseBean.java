package com.example.demo.module.payment.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SP10PaymentResponseBean {

    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;
}
