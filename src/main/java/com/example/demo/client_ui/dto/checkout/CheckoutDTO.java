package com.example.demo.client_ui.dto.checkout;

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

    private Float total;
}
