package com.example.demo.client_ui.dto.sale_promotion;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PromotionDetailDTO {
    
    private PromotionDTO sale;

    private List<VoucherCodeDTO> codes;


}
