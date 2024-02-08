package com.devesh.foodcatalouge.service;

import com.devesh.foodcatalouge.dto.FoodCatalougePage;
import com.devesh.foodcatalouge.dto.FoodItemDTO;
import com.devesh.foodcatalouge.dto.Restaurant;
import com.devesh.foodcatalouge.entity.FoodItem;
import com.devesh.foodcatalouge.mapper.FoodItemMapper;
import com.devesh.foodcatalouge.repo.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalougeService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    private RestTemplate restTemplate;

    FoodItemMapper foodItemMapper = FoodItemMapper.INSTANCE;


    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        return foodItemMapper.mapFoodItemToDTO
                (foodItemRepository.save(foodItemMapper.mapDTOtoFoodItem(foodItemDTO)));
    }

    public FoodCatalougePage fetchFoodCataloguePageDetails(Integer restaurantId) {
        List<FoodItem> foodItemList = featchFoodItemsList(restaurantId);
        Restaurant restaurant = fetchRestaurantfromRestaurantMS(restaurantId);
        return createFoodCatalougePage(foodItemList, restaurant);
    }

    private FoodCatalougePage createFoodCatalougePage(List<FoodItem> foodItemList, Restaurant restaurant) {
        return new FoodCatalougePage(foodItemList, restaurant);
    }

    private Restaurant fetchRestaurantfromRestaurantMS(Integer restaurantId) {
        return restTemplate.getForObject
                ("http://restaurant-service/restaurant/fetchById/" + restaurantId, Restaurant.class);
    }

    private List<FoodItem> featchFoodItemsList(Integer restaurantId) {
        return foodItemRepository.findByRestaurantId(restaurantId);
    }
}
