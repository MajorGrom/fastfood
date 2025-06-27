package com.park.test.fastfood.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.park.test.fastfood.model.User;

public interface UserRepository extends JpaRepository<User, UUID>{

}
