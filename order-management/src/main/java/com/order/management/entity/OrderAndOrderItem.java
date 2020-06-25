package com.order.management.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class OrderAndOrderItem {
	
	@EmbeddedId
    @JsonIgnore
	private OrderAndOrderItemPk orderAndOrderItemPk;

}
