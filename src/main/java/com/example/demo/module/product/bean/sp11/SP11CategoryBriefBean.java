package com.example.demo.module.product.bean.sp11;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SP11CategoryBriefBean {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("tax")
    private String tax;

    @JsonProperty("unit")
    private String unit;
}
