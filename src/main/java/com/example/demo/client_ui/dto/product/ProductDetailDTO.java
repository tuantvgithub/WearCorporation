package com.example.demo.client_ui.dto.product;

import com.example.demo.client_ui.dto.category.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailDTO {

    private Long id;

    private String name;

    private String description;

    private String imageUrl;

    private List<String> similarImageUrlList;

    private boolean isAvailability;

    private String brand;

    private double price;

    private int stars;

    private CategoryDTO categoryDTO;

    public ProductDetailDTO(Long id, String name, String description,
                            String imageUrl, List<String> similarImageUrlList,
                            boolean isAvailability, String brand,
                            double price, int stars) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.similarImageUrlList = similarImageUrlList;
        this.isAvailability = isAvailability;
        this.brand = brand;
        this.price = price;
        this.stars = stars;
    }
}
