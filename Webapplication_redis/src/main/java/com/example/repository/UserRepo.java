package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {
	
Users findByUsername(String username);
}
