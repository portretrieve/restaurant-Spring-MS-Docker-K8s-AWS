package com.devesh.restaurantlisting.controller;

import com.devesh.restaurantlisting.dto.RestaurantDTO;
import com.devesh.restaurantlisting.service.RestaurantServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

public class RestaurantControllerTest {

    @InjectMocks
    RestaurantController restaurantController;

    @Mock
    RestaurantServiceImpl restaurantServiceImpl;

    @BeforeEach
    public void setUp() {
        // In order for @Mock & @InjectMocks annotations to take effect,
        // You need to call MockitoAnnotations.openMocks(this).
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllRestaurants(){

        // Mock the service behavior
        List<RestaurantDTO> mockRestaurants = Arrays.asList(
                new RestaurantDTO(1, "Restaurant 1", "Address 1", "city 1", "Desc 1"),
                new RestaurantDTO(2, "Restaurant 2", "Address 2", "city 2", "Desc 2")
        );

        when(restaurantServiceImpl.getAllRestaurants()).thenReturn(mockRestaurants);

        //Controller Method is called.
        ResponseEntity<List<RestaurantDTO>> response = restaurantController.getAllRestaurants();

        //Response is verified.
        Assertions.assertEquals(mockRestaurants, response.getBody());
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

        //Verify that the service method was called.
        verify(restaurantServiceImpl, times(1)).getAllRestaurants();
    }

    @Test
    public void testSaveRestaurant() {
        // Create a mock restaurant to be saved
        RestaurantDTO mockRestaurant =  new RestaurantDTO(1, "Restaurant 1", "Address 1", "city 1", "Desc 1");

        // Mock the service behavior
        when(restaurantServiceImpl.createRestaurant(mockRestaurant)).thenReturn(mockRestaurant);

        // Call the controller method
        ResponseEntity<RestaurantDTO> response = restaurantController.createRestaurant(mockRestaurant);

        // Verify the response
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals(mockRestaurant, response.getBody());

        // Verify that the service method was called
        verify(restaurantServiceImpl, times(1)).createRestaurant(mockRestaurant);
    }

    @Test
    public void testFindRestaurantById() {
        // Create a mock restaurant ID
        Integer mockRestaurantId = 1;

        // Create a mock restaurant to be returned by the service
        RestaurantDTO mockRestaurant = new RestaurantDTO(1, "Restaurant 1", "Address 1", "city 1", "Desc 1");

        // Mock the service behavior
        when(restaurantServiceImpl.getRestaurantById(mockRestaurantId)).thenReturn(new ResponseEntity<>(mockRestaurant, HttpStatus.OK));

        // Call the controller method
        ResponseEntity<RestaurantDTO> response = restaurantController.getRestaurant(mockRestaurantId);

        // Verify the response
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(mockRestaurant, response.getBody());

        // Verify that the service method was called
        verify(restaurantServiceImpl, times(1)).getRestaurantById(mockRestaurantId);
    }



}
