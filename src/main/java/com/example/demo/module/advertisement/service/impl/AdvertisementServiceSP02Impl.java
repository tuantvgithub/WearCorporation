package com.example.demo.module.advertisement.service.impl;

import com.example.demo.module.advertisement.service.AdvertisementService;
import com.example.demo.client_ui.dto.advertisement.AdvertisementBriefDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("sp02-advertisement")
public class AdvertisementServiceSP02Impl implements AdvertisementService {

    private final List<AdvertisementBriefDTO> advertisementList = Arrays.asList(
            new AdvertisementBriefDTO(1L, "PRODUCTS", "The beauty of nature is hidden in details.",
                    "/shop", "/images/slider/slider-1.jpg"),
            new AdvertisementBriefDTO(2L, "PRODUCTS", "The beauty of nature is hidden in details.",
                    "/shop", "/images/slider/slider-2.jpg"),
            new AdvertisementBriefDTO(3L, "PRODUCTS", "The beauty of nature is hidden in details.",
                    "/shop", "/images/slider/slider-3.jpg"));

    @Override
    public List<AdvertisementBriefDTO> getAllAdvertisementBriefDTOs() {
        return this.advertisementList;
    }
}
