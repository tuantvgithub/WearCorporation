package com.example.demo.client_ui.dto.sale_promotion;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VoucherCodeDTO {
    
    private String codeId;

    private String saleId;

    private String name;

    private String description;

    private Integer count;

    private Integer percentDiscount;

    private Integer cashDiscount;

    private Integer priceMin;

    private String discountCode;


}
