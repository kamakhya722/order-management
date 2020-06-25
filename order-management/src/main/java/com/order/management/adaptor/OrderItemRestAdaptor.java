package com.order.management.adaptor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.order.management.entity.OrderItem;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderItemRestAdaptor {
	
	@Autowired
	OrderItemServiceProxy orderItemServiceProxy;
	
	public List<OrderItem> getAllOderItems(){
		
		ResponseEntity<List<OrderItem>> response = orderItemServiceProxy.getOrderItems();
		
		return response.getBody();
		
	}

}
