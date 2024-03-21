package com.jsp.product.utility;

import org.springframework.stereotype.Component;

@Component
public class ErrorStructure {
	private int errorcode;
	private String message;
	private Object rootcause;	

	public int getErrorcode() {
		return errorcode;
	}
	public ErrorStructure setErrorcode(int errorcode) {
		this.errorcode = errorcode;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public ErrorStructure setMessage(String message) {
		this.message = message;
		return this;
		
	}
	public Object getRootcause() {
		return rootcause;
	}
	public ErrorStructure setRootcause(Object rootcause) {
		this.rootcause = rootcause;
		return this;
	}
	
	@Override
	public String toString() {
		return "ErrorStructure [errorcode=" + errorcode + ", message=" + message + ", rootcause=" + rootcause + "]";
	}
	
	
	
}
