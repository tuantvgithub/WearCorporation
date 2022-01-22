package com.example.demo.module.sale_promotion.service.sp19;

import java.util.List;

import com.example.demo.client_ui.dto.sale_promotion.PromotionDTO;
import com.example.demo.client_ui.dto.sale_promotion.PromotionDetailDTO;
import com.example.demo.client_ui.dto.sale_promotion.VoucherCodeDTO;

public interface PromotionService {
    
    List<PromotionDTO> getAllSales();

    PromotionDetailDTO getPromotionById(String id);

    List<VoucherCodeDTO> getAllVoucherCode();

    
}
