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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getSimilarImageUrlList() {
        return this.similarImageUrlList;
    }

    public void setSimilarImageUrlList(List<String> similarImageUrlList) {
        this.similarImageUrlList = similarImageUrlList;
    }

    public boolean isAvailability() {
        return this.isAvailability;
    }
    public void setAvailability(Boolean isAvailability)
    {
        this.isAvailability=isAvailability;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStars() {
        return this.stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
