package com.devesh.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Integer id;
    private List<FoodItemDTO> foodItemsList;
    private Restaurant restaurant;
    private UserDTO user;
}
