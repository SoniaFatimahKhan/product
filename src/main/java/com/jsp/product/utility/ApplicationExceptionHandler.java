package com.jsp.product.utility;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest request) {
		Map<String,String> messages=new HashMap<String,String>();

		ex.getAllErrors().forEach(error->{
			messages.put(((FieldError)error).getField(),error.getDefaultMessage());
		});
		
		ErrorStructure structure = new ErrorStructure();
		return ResponseEntity.badRequest()
				.body(structure.setErrorcode(HttpStatus.BAD_REQUEST.value())
						.setMessage("Not Found/ Invalid")
						.setRootcause(messages));
		
	}	
}
