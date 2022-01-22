package com.example.demo.module.inventory.mapping;

import com.example.demo.client_ui.dto.inventory.InventoryProductDTO;
import com.example.demo.module.inventory.bean.sp20.SP20InventoryBean;

public interface InventoryMapping {

    InventoryProductDTO mapSp20BeanToDto(SP20InventoryBean bean);
}
