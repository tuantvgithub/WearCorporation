package com.example.demo.module.sale_promotion.bean.sp19;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
public class CodeSP19Bean {
    
    @JsonProperty("_id")
    private String id;

    @JsonProperty("saleId")
    private String saleId;

    @JsonProperty("usedQty")
    private Integer usedQty;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("count")
    private Integer count;

    @JsonProperty("condition")
    private SP19ConditionBean condition;

    @JsonProperty("discount")
    private SP19DiscountBean discount;

    @JsonProperty("discountCode")
    private String discountCode;

    @JsonProperty("deleted")
    private boolean deleted;

    @JsonProperty("isActived")
    private boolean isActived;

    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("updatedAt")
    private String updatedAt;
    

    

}
