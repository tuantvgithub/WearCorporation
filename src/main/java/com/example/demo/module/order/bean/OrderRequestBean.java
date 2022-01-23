package com.example.demo.module.order.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderRequestBean {

    @JsonProperty("orderId")
    private Integer orderId;

    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("orderDate")
    private String orderDate;

    @JsonProperty("totalPrice")
    private Integer totalPrice;

    @JsonProperty("subTotal")
    private Integer subTotal;

    @JsonProperty("paymentMethod")
    private String paymentMethod;

    @JsonProperty("address")
    private String address;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("voucherCode")
    private String voucherCode;

    @JsonProperty("status")
    private String status;

    @JsonProperty("products")
    private List<OrderProductRequestBean> products;
}
