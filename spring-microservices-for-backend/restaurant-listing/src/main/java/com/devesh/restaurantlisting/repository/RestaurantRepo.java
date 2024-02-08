package com.devesh.restaurantlisting.repository;

import com.devesh.restaurantlisting.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {
    Restaurant findRestaurantById(int id);
}
