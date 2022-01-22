package com.example.demo.module.delivery.bean.sp07;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SP07ResponseDeliveryBean {
   
    @JsonProperty("from_address")
    private String from_address;

    @JsonProperty("to_address")
    private String to_address;

    @JsonProperty("fee")
    private Integer fee;
}
