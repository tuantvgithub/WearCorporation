package com.example.demo.client_ui.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderBriefDTO {

    private Long id;

    private String orderDate;

    private Integer numberOfItems;

    private Float totalPrice;

    private String status;
}
