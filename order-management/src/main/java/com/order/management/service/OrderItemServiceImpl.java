package com.order.management.service;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.order.management.entity.OrderItem;
import com.order.management.exception.ResourceNotFoundException;
import com.order.management.repository.OrderItemRepository;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	

	@Override
	public @NotNull List<OrderItem> getAllOrderItems() {

		return orderItemRepository.findAll();
	}

	@Override
	public OrderItem getOrderItem(@Min(value = 1, message = "Invalid OrderItem ID.") long id) {
		return orderItemRepository
		          .findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
	}

	@Override
	public OrderItem save(OrderItem orderItem) {
		return orderItemRepository.save(orderItem);
	}

}
