package com.order.management.service;

import java.util.List;

import javax.validation.constraints.Min;

import com.order.management.entity.OrderItem;

public interface OrderItemService {
	
	public List<OrderItem> getAllOrderItems();

	public OrderItem getOrderItem(@Min(value = 1L, message = "Invalid OrderItem ID.") long id);

	public OrderItem save(OrderItem orderItem);

}
