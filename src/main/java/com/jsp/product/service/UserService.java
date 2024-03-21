package com.jsp.product.service;

import org.springframework.http.ResponseEntity;

import com.jsp.product.Model.User;
import com.jsp.product.utility.ResponseStructure;

public interface UserService {

	public ResponseEntity<ResponseStructure<User>> saveUser(User user);
}
