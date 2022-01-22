package com.example.demo.client_ui.dto.checkout;

import java.util.List;

import com.example.demo.client_ui.dto.order.ProductOrderDTO;

import lombok.Data;

@Data
public class CheckoutDTO {
    
    private String fullname;

    private String address;

    private String zip;

    private String city;

    private String country;

    private String cardHolder;

    private String cardNumber;

    private String expiredDate;

    private String cvv;

    private Integer subTotal;

    private Integer shipFee;

    private Integer total;

    private Integer voucher;

    private String voucherCode;

    private String paymentMethod;

    private String phone;

    private String password;
}
