package com.jsp.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.product.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
