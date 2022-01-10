package com.example.demo.module.order.bean.sp01;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SP01OrderBean {

    @JsonProperty("order_id")
    private Long orderId;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("price")
    private Double price;

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
