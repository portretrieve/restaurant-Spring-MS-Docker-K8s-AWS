package com.devesh.restaurantlisting.service;

import com.devesh.restaurantlisting.dto.RestaurantDTO;
import com.devesh.restaurantlisting.entity.Restaurant;
import com.devesh.restaurantlisting.entity_DTO_mapper.RestaurantMapper;
import com.devesh.restaurantlisting.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;

    private final RestaurantMapper mapperInstance = RestaurantMapper.INSTANCE;

    public List<RestaurantDTO> getAllRestaurants(){
        var restaurantList =  restaurantRepo.findAll();
        return restaurantList.stream()
                .map(mapperInstance::mapRestaurantToRestaurantDTO)
                .toList();
    }

    public ResponseEntity<RestaurantDTO> getRestaurantById(int id){
        var optionalRestaurant = restaurantRepo.findById(id);
        return optionalRestaurant.map(restaurant -> new ResponseEntity<>(mapperInstance
                .mapRestaurantToRestaurantDTO(restaurant), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    public RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO){
        Restaurant savedRestaurant = restaurantRepo
                .save(mapperInstance.mapRestaurantDTOToRestaurant(restaurantDTO));
        return mapperInstance.mapRestaurantToRestaurantDTO(savedRestaurant);
    }

}
