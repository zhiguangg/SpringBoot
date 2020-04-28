package com.myproject.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.jpa.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public List<User> findAll();

}
