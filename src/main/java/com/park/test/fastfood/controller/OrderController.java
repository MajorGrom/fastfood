package com.park.test.fastfood.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.park.test.fastfood.dto.User.UserCreateDto;
import com.park.test.fastfood.dto.User.UserDetailDto;
import com.park.test.fastfood.dto.order.OrderCreateDto;
import com.park.test.fastfood.model.Order;
import com.park.test.fastfood.model.User;
import com.park.test.fastfood.service.OrderService;
import com.park.test.fastfood.service.UserService;

import jakarta.validation.Valid;

public class OrderController {
    @Autowired
    OrderService orderService;

    
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable UUID id){
        Order response = orderService.getEntity(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid OrderCreateDto dto){
        Order response = orderService.create(dto);
        return ResponseEntity.ok(response);
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<?> update(@PathVariable UUID id,
    //                                 @RequestBody @Valid UserCreateDto user){
    //     String response = orderService.update(id, user);
    //     return ResponseEntity.ok(response);
    // }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> delete(@PathVariable UUID id){
        String response = orderService.delete(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        List<Order> response = orderService.getAll();
        return ResponseEntity.ok(response);
    }
}
