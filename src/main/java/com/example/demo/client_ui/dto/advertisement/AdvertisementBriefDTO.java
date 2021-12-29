package com.example.demo.client_ui.dto.advertisement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementBriefDTO {

    private Long id;

    private String title;

    private String content;

    private String advUrl;

    private String imageUrl;
}
