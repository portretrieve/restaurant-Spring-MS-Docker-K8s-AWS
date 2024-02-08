package com.devesh.orderservice.entity;

import com.devesh.orderservice.dto.FoodItemDTO;
import com.devesh.orderservice.dto.Restaurant;
import com.devesh.orderservice.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("orders")
public class Order {
    private Integer id;
    private List<FoodItemDTO> foodItemsList;
    private Restaurant restaurant;
    private UserDTO user;
}
