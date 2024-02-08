package com.devesh.orderservice.controller;

import com.devesh.orderservice.dto.OrderDTO;
import com.devesh.orderservice.dto.OrderRequest;
import com.devesh.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderRequest orderRequest){
        OrderDTO orderDTO = orderService.createAndSaveOrder(orderRequest);
        return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }

}
