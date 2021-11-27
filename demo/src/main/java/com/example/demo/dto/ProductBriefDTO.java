package com.example.demo.dto;

import lombok.Data;

@Data
public class ProductBriefDTO {

    private Long id;

    private String name;

    private String imageUrl;

    private Double price;
}
