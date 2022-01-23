package com.example.demo.module.order.bean.sp01;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SP01OrderBean {

    @JsonProperty("order_id")
    private Integer orderId;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("price")
    private Integer price;

    @JsonProperty("voucherCode")
    private String voucherCode;

    @JsonProperty("voucher")
    private Integer voucher;

    @JsonProperty("address")
    private String address;

    @JsonProperty("shipFee")
    private Integer shipFee;

    @JsonProperty("paymentMethod")
    private String paymentMethod;

    @JsonProperty("delivery_note")
    private String deliveryNote;

    @JsonProperty("status")
    private String status;

    @JsonProperty("order_timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String orderTime;

    @JsonProperty("delivery_timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String deliveryTime;

    @JsonProperty("product_list")
    private List<SP01ProductOrderBean> productOrderList;
}
