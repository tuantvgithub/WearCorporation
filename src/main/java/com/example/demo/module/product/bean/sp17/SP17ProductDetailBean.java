package com.example.demo.module.product.bean.sp17;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SP17ProductDetailBean {

    private Integer id;

    private String name;

    private String type;

    private Integer price;

    private String description;

    private String size;

    private String image;

    private String video;

    private String color;

    private Integer quantity;

    @JsonProperty("category_id")
    private Integer categoryId;
}
