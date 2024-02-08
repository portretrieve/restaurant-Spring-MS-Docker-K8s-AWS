package com.devesh.foodcatalouge.mapper;

import com.devesh.foodcatalouge.dto.FoodItemDTO;
import com.devesh.foodcatalouge.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);
    FoodItem mapDTOtoFoodItem(FoodItemDTO foodItemDTO);
    FoodItemDTO mapFoodItemToDTO(FoodItem foodItem);

}
