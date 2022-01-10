package com.example.demo.module.order.bean.sp01;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SP01ProductOrderBean {

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("quantity")
    private Integer quantity;
}
