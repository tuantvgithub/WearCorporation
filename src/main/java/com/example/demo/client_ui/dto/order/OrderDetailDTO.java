package com.example.demo.client_ui.dto.order;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class OrderDetailDTO {

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

    private String status;

    private List<ProductOrderDTO> productList;

}
