package com.order.management.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReturnDetails {

	private int code;
	private String messageDescription;
	private String messageSource;
	private String errorDetails;
}
