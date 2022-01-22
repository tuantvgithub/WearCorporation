package com.example.demo.client_ui.dto.inventory;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryDetailProductDTO {
    
    private List<InventoryProductDTO> details;

    private Integer total;
}
