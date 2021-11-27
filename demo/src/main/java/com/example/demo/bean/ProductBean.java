package com.example.demo.bean;

import lombok.Data;

import java.util.List;

@Data
public class ProductBean {

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


    public String getName() {
        return this.name;
    }


    public String getImageUrl() {
        return this.imageUrl;
    }


    public List<String> getSimilarImageUrlList() {
        return this.similarImageUrlList;
    }


    public boolean isAvailability() {
        return this.isAvailability;
    }


    public String getBrand() {
        return this.brand;
    }


    public double getPrice() {
        return this.price;
    }


    public int getStars() {
        return this.stars;
    }


    public void setId(Long id)
    {
        this.id=id;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setImageUrl(String url)
    {
        this.imageUrl=url;
    }
    public void setSimilarImageUrlList(List<String> similarUrls)
    {
        this.similarImageUrlList=similarUrls;
    }
    public void setAvailability(Boolean isAvailability)
    {
        this.isAvailability=isAvailability;
    }
    public void setBrand(String branch)
    {
        this.brand=branch;
    }
    public void setPrice(double price)
    {
        this.price=price;
    }
    public void setStars(int stars)
    {
        this.stars=stars;
    }
    
}
