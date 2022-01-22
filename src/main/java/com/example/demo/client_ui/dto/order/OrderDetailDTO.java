package com.example.demo.client_ui.dto.order;

import lombok.Data;

import java.util.List;

import com.example.demo.client_ui.dto.checkout.CheckoutDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDetailDTO {

    @JsonProperty("order_id")
    private Integer orderId;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("order_timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String orderDate;

    @JsonProperty("price")
    private Integer totalPrice;

    private Integer subTotal;

    @JsonProperty("payment_method")
    private String paymentMethod;

    @JsonProperty("address")
    private String address;

    @JsonProperty("shipping_fee")
    private Integer shipFee;

    private Integer voucher;

    @JsonProperty("phone_number")
    private String phone;

    private String voucherCode;

    @JsonProperty("status")
    private String status;

    @JsonProperty("product_list")
    private List<ProductOrderDTO> productList;

    public OrderDetailDTO(){}

    public OrderDetailDTO(CheckoutDTO checkoutDTO)
    {
        this.address=checkoutDTO.getAddress()+" - "+checkoutDTO.getCity();
         this.paymentMethod=checkoutDTO.getPaymentMethod();
        this.subTotal=checkoutDTO.getSubTotal();
        this.voucherCode=checkoutDTO.getVoucherCode();
    }
}
