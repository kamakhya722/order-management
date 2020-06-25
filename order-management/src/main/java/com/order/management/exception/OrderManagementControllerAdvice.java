package com.order.management.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.order.management.model.CommunicationMessages;
import com.order.management.model.Response;
import com.order.management.util.ResponseUtil;

import lombok.extern.slf4j.Slf4j;


@RestControllerAdvice
@Slf4j
public class OrderManagementControllerAdvice {
	
	
	@Autowired
	ResponseUtil responseUtil;

	@ExceptionHandler(BadRequestException.class)
	public final ResponseEntity<Object> handleException(BadRequestException ex) {
		Response response = responseUtil.prepareFailedResponse(HttpStatus.BAD_REQUEST, null, ex.getMessage(),
				CommunicationMessages.FAILED_MESSAGE);
		log.error("BadRequestException", ex);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<Object> handleException(ResourceNotFoundException ex) {
		Response response = responseUtil.prepareFailedResponse(HttpStatus.NOT_FOUND, null, ex.getMessage(),
				CommunicationMessages.FAILED_MESSAGE);
		log.error("ResourceNotFoundException", ex);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public final ResponseEntity<Object> handleException(OrderNotFoundException ex) {
		Response response = responseUtil.prepareFailedResponse(HttpStatus.ACCEPTED, ex.getMessage(),
				ex.getMessage(), CommunicationMessages.FAILED_MESSAGE);
		log.error("CommunicationException", ex);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	protected ResponseEntity<Object> httpRequestMethodNotSupportedException(Exception ex) {
		Response response = responseUtil.prepareFailedResponse(HttpStatus.METHOD_NOT_ALLOWED, null, ex.getMessage(),
				CommunicationMessages.FAILED_MESSAGE);
		return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	protected ResponseEntity<Object> unsupportedMediaTypeException(Exception ex) {
		Response response = responseUtil.prepareFailedResponse(HttpStatus.UNSUPPORTED_MEDIA_TYPE, null, ex.getMessage(),
				CommunicationMessages.FAILED_MESSAGE);
		return new ResponseEntity<>(response, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleException(Exception ex) {
		Response response = responseUtil.prepareFailedResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, ex.getMessage(),
				"Request processed with some error");
		log.error("Exception", ex);
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
