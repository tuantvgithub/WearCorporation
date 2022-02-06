package com.example.demo.module.order.bean.sp01;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class    SP01OrderBean {

    @JsonProperty("order_id")
    private Integer orderId;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("total")
    private Integer total;

    @JsonProperty("subtotal")
    private Integer subtotal;

    @JsonProperty("voucher")
    private Integer voucher;
    
    @JsonProperty("to_address")
    private String address;
    
    @JsonProperty("from_address")
    private String fromAddress;
    
    @JsonProperty("shipping_fee")
    private Integer shipFee;
    
    @JsonProperty("shipping_voucher")
    private String voucherCode;
    
    @JsonProperty("payment_method")
    private String paymentMethod;

    @JsonProperty("delivery_note")
    private String deliveryNote;

    @JsonProperty("status")
    private String status;

    @JsonProperty("phone_number")
    private String phone;

    @JsonProperty("order_timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String orderTime;

    @JsonProperty("delivery_timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String deliveryTime;

    @JsonProperty("product_list")
    private List<SP01ProductOrderBean> productOrderList;
}
