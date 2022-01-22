package com.example.demo.module.product.bean.sp11;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SP11ProductBriefBean {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("detail")
    private String detail;

    @JsonProperty("price")
    private Integer price;

    @JsonProperty("category_id")
    private Long categoryId;

    @JsonProperty("image")
    private String mainImageUrl;

    @JsonProperty("brand")
    private String brand;

}
