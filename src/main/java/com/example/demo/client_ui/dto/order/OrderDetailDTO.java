package com.example.demo.client_ui.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
@Builder
public class OrderDetailDTO implements Serializable {

    private Integer orderId;

    private Integer userId;

    private String orderDate;

    private Integer totalPrice;

    private Integer subTotal;

    private String paymentMethod;

    private String address;

    private Integer shipFee;

    private Integer voucher;

    private String phone;

    private String voucherCode;

    @JsonProperty("status")
    private String status;

    private List<ProductOrderDTO> productList;

}
