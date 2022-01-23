package com.example.demo.module.order.mapping.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.client_ui.dto.cart.CartDTO;
import com.example.demo.client_ui.dto.cart.ProductCartDTO;
import com.example.demo.client_ui.dto.checkout.CheckoutDTO;
import com.example.demo.client_ui.dto.order.OrderBriefDTO;
import com.example.demo.client_ui.dto.order.OrderDetailDTO;
import com.example.demo.client_ui.dto.order.ProductOrderDTO;
import com.example.demo.module.order.bean.OrderProductRequestBean;
import com.example.demo.module.order.bean.OrderRequestBean;
import com.example.demo.module.order.bean.sp01.SP01OrderBean;
import com.example.demo.module.order.bean.sp16.SP16OrderBean;
import com.example.demo.module.order.bean.sp16.SP16ProductOrderBean;
import com.example.demo.module.order.mapping.OrderMapping;

import org.springframework.stereotype.Component;

@Component
public class OrderMappingImpl implements OrderMapping {

    @Override
    public OrderDetailDTO beanToDetailDTO(SP01OrderBean bean) {
        if (bean == null)
            return null;

        return OrderDetailDTO.builder()
                .orderId(bean.getOrderId())
                .orderDate(bean.getOrderTime())
                .voucher(bean.getVoucher())
                .shipFee(bean.getShipFee())
                .totalPrice(bean.getPrice())
                .paymentMethod(bean.getPaymentMethod())
                .totalPrice(bean.getPrice())
                .status(bean.getStatus())
                .build();
    }

    @Override
    public OrderBriefDTO beanToBriefDTO(SP01OrderBean bean) {
        if (bean == null)
            return null;
        OrderBriefDTO briefDTO = new OrderBriefDTO();

        briefDTO.setId(bean.getOrderId());
        briefDTO.setOrderDate(bean.getOrderTime());
        if (bean.getProductOrderList() != null)
            briefDTO.setNumberOfItems(bean.getProductOrderList().size());
        briefDTO.setTotalPrice(bean.getPrice());
        briefDTO.setStatus(bean.getStatus());

        return briefDTO;
    }

    @Override
    public List<ProductOrderDTO> mapCartProductToOrderProduct(List<ProductCartDTO> cartDTOs) {

        List<ProductOrderDTO> orderProducts = new ArrayList<>();

        for (ProductCartDTO productCartDTO : cartDTOs) {

            ProductOrderDTO productOrderDTO = new ProductOrderDTO();

            productOrderDTO.setProductId(productCartDTO.getProductId());
            productOrderDTO.setProductName(productCartDTO.getProductName());
            productOrderDTO.setProductPrice(productCartDTO.getItemPrice());
            productOrderDTO.setQuantity(productCartDTO.getQuantity());
            productOrderDTO.setColor(productCartDTO.getColor());
            productOrderDTO.setSize(productCartDTO.getSize());

            orderProducts.add(productOrderDTO);
        }
        return orderProducts;
    }

    @Override
    public OrderDetailDTO beanTDetailDTO(SP16OrderBean bean) {

        List<ProductOrderDTO> productOrderDTOs = new ArrayList<>();

        for (SP16ProductOrderBean productOrderBean : bean.getProducts()) {

            productOrderDTOs.add(beanToDto(productOrderBean));

        }

        return OrderDetailDTO.builder()
                .address(bean.getAddress())
                .orderDate(bean.getCreatedDate())
                .orderId(bean.getOrderId())
                .paymentMethod(bean.getPaymentMethod())
                .phone(bean.getPhone())
                .voucherCode(bean.getVoucherCode())
                .userId(bean.getUserId())
                .productList(productOrderDTOs)
                .status(bean.getStatus())
                .build();

    }

    @Override
    public ProductOrderDTO beanToDto(SP16ProductOrderBean bean) {

        ProductOrderDTO productOrderDTO = new ProductOrderDTO();
        productOrderDTO.setProductId(bean.getProductId());
        productOrderDTO.setQuantity(bean.getQuantity());
        return productOrderDTO;
    }

    @Override
    public OrderRequestBean dtoToOrderRequest(CheckoutDTO checkoutDTO, CartDTO cartDTO) {

        return OrderRequestBean.builder()
                .address(checkoutDTO.getAddress() + " - " + checkoutDTO.getCity())
                .paymentMethod(checkoutDTO.getPaymentMethod())
                .voucherCode(checkoutDTO.getVoucherCode())
                .products(dtoToOrderProductRequest(cartDTO))
                .subTotal(checkoutDTO.getSubTotal())
                .status("Unpaid")
                .build();
    }

    @Override
    public List<OrderProductRequestBean> dtoToOrderProductRequest(CartDTO cartDTO) {

        List<OrderProductRequestBean> orderProductRequests = new ArrayList<>();
        for (ProductCartDTO productCartDTO : cartDTO.getProductCartList()) {
            orderProductRequests.add(
                    OrderProductRequestBean.builder().color(productCartDTO.getColor())
                            .price(productCartDTO.getItemPrice())
                            .size(productCartDTO.getSize())
                            .quantity(productCartDTO.getProductId())
                            .productId(productCartDTO.getProductId())
                            .build());
        }
        return orderProductRequests;
    }

}
