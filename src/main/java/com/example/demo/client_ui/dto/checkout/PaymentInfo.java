package com.example.demo.client_ui.dto.checkout;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PaymentInfo {
   
    @JsonProperty("type")
    private String type;

    @JsonProperty("name")
    private String name;

    @JsonProperty("cvv")
    private String cvv;

    @JsonProperty("card")
    private String cardNumber;

    @JsonProperty("money")
    private Integer money;

    @JsonProperty("expired")
    private String expired;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("password")
    private String password;
}
