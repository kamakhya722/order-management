package com.order.management.adaptor;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.order.management.entity.OrderItem;

@FeignClient(name = "order-item-service", url = "http://localhost:8081/api/orderItems")
public interface OrderItemServiceProxy {
	
	@GetMapping("/{Id}")
    public ResponseEntity<List<OrderItem>> getOrderItems();

}
