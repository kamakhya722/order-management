package com.order.management.model;

public class CommunicationMessages {
	
	private CommunicationMessages() {
		
	}

	public static final String MESSAGE_SOURCE = "benefits-communication-service";
	public static final String SUCCESS = "Request processed successfully";
	public static final String INVALID_HEADER = "Invalid CorrelationId";
	public static final String FAILED_MESSAGE = "Failed to process the request";
	public static final String MERGE_FIELD_MESSAGE = "Failed to get required resource";
	public static final String NOT_FOUND = "Resource not found";

	public static final String EMAIL_SENT = "Mail Sent successfully ";

}
