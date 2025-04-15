package com.example.casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.casestudy.model.User;

public interface AuthRepository extends JpaRepository<User, Integer> {

	UserDetails findByUsername(String username);

}
