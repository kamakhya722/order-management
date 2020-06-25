package com.order.management.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.order.management.entity.Order;
import com.order.management.exception.BadRequestException;



@Component
public class OrderManagementValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {

		return Order.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Order order = (Order) target;
		String address = order.getAddress();
		if (address == null || "".equals(address)) {
			throw new BadRequestException("address Id is required");
		}

		String customerName = order.getCustomerName();
		if (customerName == null || "".equals(customerName)) {
			throw new BadRequestException("customer Name is required");
		}

	}

	public boolean isInvalid(String field) {
		return field == null || field.trim().equals("");
	}


}

