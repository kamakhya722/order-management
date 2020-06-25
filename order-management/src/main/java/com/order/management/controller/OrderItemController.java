package com.order.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.management.entity.OrderItem;
import com.order.management.service.OrderItemService;

@RestController
@RequestMapping("/api/orderItems")
public class OrderItemController {
	
	@Autowired
	OrderItemService orderItemService;
	
	@GetMapping("/{Id}")
    public ResponseEntity<List<OrderItem>> getOrderItems() {
        return new ResponseEntity<List<OrderItem>> (orderItemService.getAllOrderItems(),HttpStatus.OK);
    }

}
