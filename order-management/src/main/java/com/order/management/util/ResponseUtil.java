package com.order.management.util;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.order.management.model.CommunicationMessages;
import com.order.management.model.Response;
import com.order.management.model.ReturnDetails;





@Component
public class ResponseUtil {

	public Response prepareOkResponse(Object commDetail) {

		Response response = new Response();
		ReturnDetails returnDetails = getReturnDetails();
		returnDetails.setCode(HttpStatus.OK.value());
		returnDetails.setMessageDescription(CommunicationMessages.SUCCESS);
		returnDetails.setMessageSource(CommunicationMessages.MESSAGE_SOURCE);
		response.setReturnDetails(returnDetails);
		response.setCommDetail(commDetail);
		return response;
	}
	
	private ReturnDetails getReturnDetails() {
		return ReturnDetails.builder().code(HttpStatus.OK.value()).messageSource(CommunicationMessages.MESSAGE_SOURCE)
				.messageDescription(CommunicationMessages.SUCCESS).build();
	}
	
	public Response prepareFailedResponse(HttpStatus status, Object commDetail, String message,
			String messageDescription) {
		Response response = new Response();
		ReturnDetails returnDetails = ReturnDetails.builder().build();
		returnDetails.setCode(status.value());
		returnDetails.setErrorDetails(message);
		returnDetails.setMessageDescription(messageDescription);
		returnDetails.setMessageSource(CommunicationMessages.MESSAGE_SOURCE);
		response.setReturnDetails(returnDetails);
		response.setCommDetail(commDetail);
		return response;
	}
}
