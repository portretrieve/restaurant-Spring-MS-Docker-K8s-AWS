package com.devesh.foodcatalouge.controller;

import com.devesh.foodcatalouge.dto.FoodCatalougePage;
import com.devesh.foodcatalouge.dto.FoodItemDTO;
import com.devesh.foodcatalouge.service.FoodCatalougeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodCatalogue")
@CrossOrigin
public class FoodCatalougeController {

    @Autowired
    private FoodCatalougeService foodCatalougeService;

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO){
        FoodItemDTO foodItemSaved = foodCatalougeService.addFoodItem(foodItemDTO);
        return new ResponseEntity<>(foodItemSaved, HttpStatus.CREATED);
    }

    @GetMapping("/fetchRestaurantAndFoodItemsById/{restaurantId}")
    public ResponseEntity<FoodCatalougePage> fetchRestDetailsWithFoodMenu(@PathVariable Integer restaurantId){
        FoodCatalougePage foodCataloguePage = foodCatalougeService.fetchFoodCataloguePageDetails(restaurantId);
        return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);
    }

}
