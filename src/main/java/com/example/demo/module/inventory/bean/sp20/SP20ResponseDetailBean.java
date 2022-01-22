package com.example.demo.module.inventory.bean.sp20;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SP20ResponseDetailBean {
   
    @JsonProperty("details")
    private List<SP20InventoryBean> details;

    @JsonProperty("total")
    private Integer total;
}
