package com.jsp.product.serviceimpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.product.Model.User;
import com.jsp.product.repository.UserRepository;
import com.jsp.product.service.UserService;
import com.jsp.product.utility.ResponseStructure;
@Service
public class UserImpl implements UserService{

	private UserRepository userRepository; 
	
	private ResponseStructure<User> structure;
	
	@Override
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		User uniqueUser=userRepository.save(user);
		return ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value()).setMessage("saved").setData(uniqueUser));
	}

}
