package com.devesh.restaurantlisting.service;

import com.devesh.restaurantlisting.dto.RestaurantDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RestaurantService {
    List<RestaurantDTO> getAllRestaurants();
    ResponseEntity<RestaurantDTO> getRestaurantById(int id);
    RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO);
}
