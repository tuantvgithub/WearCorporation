package com.example.demo.client_ui.dto.inventory;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryProductDTO {
   
    private String productId;

    private Integer quantity;

    private Integer warehouseId;
}
