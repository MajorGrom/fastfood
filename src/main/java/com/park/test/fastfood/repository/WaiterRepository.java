package com.park.test.fastfood.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.park.test.fastfood.model.Waiter;

public interface WaiterRepository extends JpaRepository <Waiter, UUID> {

}
