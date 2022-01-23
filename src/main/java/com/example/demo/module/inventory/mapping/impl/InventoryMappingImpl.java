package com.example.demo.module.inventory.mapping.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.client_ui.dto.inventory.InventoryDetailProductDTO;
import com.example.demo.client_ui.dto.inventory.InventoryProductDTO;
import com.example.demo.module.inventory.bean.sp20.SP20InventoryBean;
import com.example.demo.module.inventory.bean.sp20.SP20ResponseDetailBean;
import com.example.demo.module.inventory.mapping.InventoryMapping;

import org.springframework.stereotype.Component;

@Component
public class InventoryMappingImpl implements InventoryMapping {

    @Override
    public InventoryProductDTO mapSp20BeanToDto(SP20InventoryBean bean) {

        return InventoryProductDTO.builder()
                .productId(bean.getId())
                .quantity(bean.getQuantity())
                .warehouseId(bean.getWarehouseId())
                .build();
    }

    @Override
    public InventoryDetailProductDTO mapSp20BeanDetailToDto(SP20ResponseDetailBean bean) {
        
        List<InventoryProductDTO> inventoryProductDTOs=new ArrayList<>();
        for (SP20InventoryBean sp20InventoryBean : bean.getDetails()) {
            inventoryProductDTOs.add(mapSp20BeanToDto(sp20InventoryBean));
        }

        return InventoryDetailProductDTO.builder().details(inventoryProductDTOs).total(bean.getTotal())
                                        .build();
    }

}
