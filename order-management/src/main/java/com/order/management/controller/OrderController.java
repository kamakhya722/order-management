package com.order.management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.management.entity.Order;
import com.order.management.service.OrderService;
import com.order.management.validator.OrderManagementValidator;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@Autowired
	OrderManagementValidator OrderManagementValidator;

	@PostMapping("/createOrder")
	public ResponseEntity<Order> createOrder(
			@RequestHeader(name = "correaltionId", required = false) String correaltionId,
			@Valid @RequestBody Order orderInput) {

		return new ResponseEntity<>(orderService.create(orderInput), HttpStatus.CREATED);
	}

}
