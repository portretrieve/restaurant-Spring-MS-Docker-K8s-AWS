package com.devesh.orderservice.service;

import com.devesh.orderservice.dto.OrderDTO;
import com.devesh.orderservice.dto.OrderRequest;
import com.devesh.orderservice.dto.UserDTO;
import com.devesh.orderservice.entity.Order;
import com.devesh.orderservice.mapper.OrderMapper;
import com.devesh.orderservice.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private SequenceGenerator sequenceGenerator;

    @Autowired
    private RestTemplate restTemplate;

    public OrderDTO createAndSaveOrder(OrderRequest request) {


        //Fetch UserDetails
        UserDTO userDTO = fetchUser(request.getUserId());

        //Generate Order Id
        int newOrderId = sequenceGenerator.generateNextOrderId();
//        int newOrderId = 1;

        //Create a new order
        Order order = orderRepo.save
                (new Order(newOrderId, request.getFoodItemsList(), request.getRestaurant(), userDTO));

        return mapOrderToOrderDTO(order);
    }

    private OrderDTO mapOrderToOrderDTO(Order order) {
        return new OrderDTO(order.getId(), order.getFoodItemsList(), order.getRestaurant(), order.getUser());
    }


    private UserDTO fetchUser(int userId) {
        return restTemplate.getForObject
                ("http://user-service/user/fetchUserById/" + userId, UserDTO.class);
    }
}
