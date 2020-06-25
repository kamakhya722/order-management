package com.order.management.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "order")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class OrderAndOrderItemPk {
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "orderItem_id")
	private OrderItem orderItem;
}
