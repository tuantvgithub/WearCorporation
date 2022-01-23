package com.example.demo.module.inventory.bean.sp20;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SP20InventoryBean {
   
    @JsonProperty("id")
    private String id;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("warehouse_id")
    private Integer warehouseId;

    @JsonProperty("warehouse_name")
    private String warehouseName;

    @JsonProperty("last_update")
    private String lastuUpdate;


}
