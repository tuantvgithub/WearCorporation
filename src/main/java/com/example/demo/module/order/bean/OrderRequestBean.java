package com.example.demo.module.order.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderRequestBean {

    @JsonProperty("order_id")
    private Integer orderId;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("orderDate")
    private String orderDate;

    @JsonProperty("total")
    private Integer totalPrice;

    @JsonProperty("from_address")
    private String fromAddress;

    @JsonProperty("subtotal")
    private Integer subTotal;


    @JsonProperty("payment_method")
    private String paymentMethod;

    @JsonProperty("to_address")
    private String address;

    @JsonProperty("phone_number")
    private String phone;

    @JsonProperty("voucherCode")
    private String voucherCode;

    @JsonProperty("status")
    private String status;

    @JsonProperty("product_list")
    private List<OrderProductRequestBean> products;
}
