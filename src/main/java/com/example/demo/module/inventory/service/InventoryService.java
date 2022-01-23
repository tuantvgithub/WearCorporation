package com.example.demo.module.inventory.service;

import com.example.demo.client_ui.dto.inventory.InventoryDetailProductDTO;


public interface InventoryService {

    InventoryDetailProductDTO getProductInInventoryById(Integer id);
}
