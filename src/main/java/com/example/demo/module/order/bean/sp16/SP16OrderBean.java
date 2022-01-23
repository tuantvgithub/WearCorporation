package com.example.demo.module.order.bean.sp16;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SP16OrderBean {
    
    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("orderId")
    private Integer orderId;

    @JsonProperty("address")
    private String address;

    @JsonProperty("phoneNumber")
    private String phone;
    
    @JsonProperty("voucherCode")
    private String voucherCode;

    @JsonProperty("status")
    private String status;

    @JsonProperty("note")
    private String note;

    @JsonProperty("paymentStatus")
    private boolean paymentStatus;

    @JsonProperty("paymentMethod")
    private String paymentMethod;

    @JsonProperty("createdDate")
    private String createdDate;

    @JsonProperty("deliveryDate")
    private String deliveryDate;

    @JsonProperty("products")
    private List<SP16ProductOrderBean> products;
}
