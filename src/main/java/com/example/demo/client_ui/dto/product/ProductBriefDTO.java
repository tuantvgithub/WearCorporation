package com.example.demo.client_ui.dto.product;

import lombok.Data;

@Data
public class ProductBriefDTO {

    private Integer id;

    private String name;

    private String imageUrl;

    private Integer price;
}
