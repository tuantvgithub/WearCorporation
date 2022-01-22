package com.example.demo.module.inventory.mapping.impl;

import com.example.demo.client_ui.dto.inventory.InventoryProductDTO;
import com.example.demo.module.inventory.bean.sp20.SP20InventoryBean;
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

}
