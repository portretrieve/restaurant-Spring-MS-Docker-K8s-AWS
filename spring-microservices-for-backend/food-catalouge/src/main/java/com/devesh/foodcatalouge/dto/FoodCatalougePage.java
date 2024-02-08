package com.devesh.foodcatalouge.dto;

import com.devesh.foodcatalouge.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCatalougePage {
    private List<FoodItem> foodItemsList;
    private Restaurant restaurant;
}
