package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductDetailDTO {

    private Long id;

    private String name;

    private String imageUrl;

    private List<String> similarImageUrlList;

    private boolean isAvailability;

    private String brand;

    private double price;

    private int stars;
}
