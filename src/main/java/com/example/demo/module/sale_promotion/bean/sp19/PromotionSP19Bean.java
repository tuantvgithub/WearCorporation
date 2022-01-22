package com.example.demo.module.sale_promotion.bean.sp19;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
public class PromotionSP19Bean {
   
    @JsonProperty("_id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("timeStart")
    private String timeStart;

    @JsonProperty("timeEnd")
    private String timeEnd;

    @JsonProperty("images")
    private List<String> images;

    @JsonProperty("deleted")
    private boolean deleted;

    @JsonProperty("isActived")
    private boolean isActived;

    @JsonProperty("deletedAt")
    private String deletedAt;

    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("updatedAt")
    private String updatedAt;
}
