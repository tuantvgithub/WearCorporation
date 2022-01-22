package com.example.demo.module.sale_promotion.bean.sp19;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PromoDetailSP19Bean {
   
    @JsonProperty("sale")
    private PromotionSP19Bean sale;

    @JsonProperty("code")
    private List<CodeSP19Bean> codes;
}
