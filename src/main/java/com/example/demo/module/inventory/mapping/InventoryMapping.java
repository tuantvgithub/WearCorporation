package com.example.demo.module.inventory.mapping;

import com.example.demo.client_ui.dto.inventory.InventoryDetailProductDTO;
import com.example.demo.client_ui.dto.inventory.InventoryProductDTO;
import com.example.demo.module.inventory.bean.sp20.SP20InventoryBean;
import com.example.demo.module.inventory.bean.sp20.SP20ResponseDetailBean;

public interface InventoryMapping {

    InventoryProductDTO mapSp20BeanToDto(SP20InventoryBean bean);
    InventoryDetailProductDTO mapSp20BeanDetailToDto(SP20ResponseDetailBean bean);
}
