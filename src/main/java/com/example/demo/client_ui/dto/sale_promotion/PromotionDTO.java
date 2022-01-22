package com.example.demo.client_ui.dto.sale_promotion;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PromotionDTO {
    
    private String id;

    private String name;

    private String description;

    private String timeStart;

    private String timeEnd;

    private List<String> images;

   
}
