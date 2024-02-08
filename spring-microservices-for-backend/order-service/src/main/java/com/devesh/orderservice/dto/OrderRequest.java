package com.devesh.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    private List<FoodItemDTO> foodItemsList;
    private int userId;
    private Restaurant restaurant;
}
