package com.topal.application.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class RestaurantReplyNotFoundExceptionAdvice {

	  @ResponseBody
	  @ExceptionHandler(RestaurantReplyNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String replyrNotFoundHandler(RestaurantReplyNotFoundException ex) {
	    return ex.getMessage();
	  }
}
