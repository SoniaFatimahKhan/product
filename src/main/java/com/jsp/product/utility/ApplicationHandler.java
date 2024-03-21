package com.jsp.product.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.product.exception.ProductNotFoundException;

@RestControllerAdvice
public class ApplicationHandler {
  @ExceptionHandler
  public ResponseEntity<ErrorStructure> productNotFound(ProductNotFoundException ex){
	  ErrorStructure er= new ErrorStructure();
	  er.setErrorcode(HttpStatus.NOT_FOUND.value());
	  er.setMessage("NotFound");
	  er.setRootcause("Product not found by this Id");
	  return new ResponseEntity<ErrorStructure>(er, HttpStatus.NOT_FOUND);
	  
  }
}
