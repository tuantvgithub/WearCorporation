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

    @JsonProperty("images")
    private List<String> images;

    @JsonProperty("percentDiscount")
    private Integer percentDiscount;

    @JsonProperty("cashDiscount")
    private Integer cashDiscount;

    @JsonProperty("bundledProduct")
    private String bundledProduct;

    @JsonProperty("level")
    private String level;

    @JsonProperty("priceMin")
    private Integer priceMin;

    @JsonProperty("totalProduct")
    private Integer totalProduct;

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
