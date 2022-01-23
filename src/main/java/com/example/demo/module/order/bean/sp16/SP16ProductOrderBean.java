package com.example.demo.module.order.bean.sp16;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SP16ProductOrderBean {

    @JsonProperty("productId")
    private Integer productId;

    @JsonProperty("quantity")
    private Integer quantity;
}
