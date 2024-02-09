package com.devesh.restaurantlisting.controller;

import com.devesh.restaurantlisting.dto.RestaurantDTO;
import com.devesh.restaurantlisting.service.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {

    @Autowired
    private RestaurantServiceImpl restaurantServiceImpl;

    @GetMapping
    public String test(){
        return "Restaurant is running!";
    }

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurants(){
      return new ResponseEntity<>(restaurantServiceImpl.getAllRestaurants(), HttpStatus.OK);
    }

    @GetMapping("fetchById/{id}")
    public ResponseEntity<RestaurantDTO> getRestaurant(@PathVariable int id){
        return restaurantServiceImpl.getRestaurantById(id);
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDTO> createRestaurant(@RequestBody RestaurantDTO restaurantDTO){
        return new ResponseEntity<>(restaurantServiceImpl.createRestaurant(restaurantDTO), HttpStatus.CREATED);
    }

}
