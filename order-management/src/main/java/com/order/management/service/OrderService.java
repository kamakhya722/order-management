package com.order.management.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.order.management.entity.Order;

public interface OrderService {

	
	@NotNull List<Order> getAllOrders();

    Order create(@NotNull(message = "The order cannot be null.") @Valid Order order);

    void update(@NotNull(message = "The order cannot be null.") @Valid Order order);
}
