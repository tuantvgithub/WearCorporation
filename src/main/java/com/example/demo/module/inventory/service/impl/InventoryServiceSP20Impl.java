package com.example.demo.module.inventory.service.impl;

import java.util.List;

import com.example.demo.client_ui.dto.inventory.InventoryDetailProductDTO;
import com.example.demo.module.inventory.bean.sp20.SP20InventoryBean;
import com.example.demo.module.inventory.bean.sp20.SP20ResponseDetailBean;
import com.example.demo.module.inventory.mapping.InventoryMapping;
import com.example.demo.module.inventory.proxies.InventorySP20WebServiceProxy;
import com.example.demo.module.inventory.service.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service("sp20-inventory")
@Slf4j
public class InventoryServiceSP20Impl implements InventoryService {

    @Autowired
    private InventorySP20WebServiceProxy inventorySP20WebServiceProxy;

    @Autowired
    private InventoryMapping inventoryMapping;

    @Override
    public InventoryDetailProductDTO getProductInInventoryById(Integer id) {
        try {
            SP20ResponseDetailBean inventoryBean = inventorySP20WebServiceProxy.getProductInWarehouseById(id);
           
            return inventoryMapping.mapSp20BeanDetailToDto(inventoryBean);

        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
            return null;
        }
    }

    @Override
    public Integer getProductQuantityInInventory(Integer productId, Integer inventoryId) {
        if (productId == null) return null;

        try {
            SP20ResponseDetailBean responseDetailBean =
                    this.inventorySP20WebServiceProxy.getProductInWarehouseById(productId);
            if (responseDetailBean == null)
                return null;
            if (inventoryId == null)
                return responseDetailBean.getTotal();

            for (SP20InventoryBean inventoryBean : responseDetailBean.getDetails())
                if (inventoryBean.getId().equals(inventoryId))
                    return inventoryBean.getQuantity();
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
        }

        return null;
    }
}
