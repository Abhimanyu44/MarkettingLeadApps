package com.markettingLeadApp.exception;

import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.markettingLeadApp.Dto.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
			
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleBlogAPIException(Exception exception, 
			WebRequest webRequest){
		ErrorDetails errorDetails = new  ErrorDetails(new Date(), exception.getMessage(),
				webRequest.getDescription(true));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
