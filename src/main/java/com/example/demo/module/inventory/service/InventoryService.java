package com.example.demo.module.inventory.service;

import com.example.demo.client_ui.dto.inventory.InventoryProductDTO;

public interface InventoryService {

    InventoryProductDTO getProductInInventoryById(Integer id);
}
