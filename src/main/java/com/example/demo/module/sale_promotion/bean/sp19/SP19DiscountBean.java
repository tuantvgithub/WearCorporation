package com.example.demo.module.sale_promotion.bean.sp19;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SP19DiscountBean {
   
    @JsonProperty("discountType")
    private Integer type;

    @JsonProperty("discountValue")
    private Integer value;

    @JsonProperty("subConditions")
    private Integer subConditions;
}
