package com.park.test.fastfood.controller;

import java.util.UUID;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.park.test.fastfood.dto.User.UserCreateDto;
import com.park.test.fastfood.dto.User.UserDetailDto;
import com.park.test.fastfood.model.User;
import com.park.test.fastfood.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable UUID id){
        UserDetailDto response = userService.get(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid UserCreateDto user){
        User response = userService.create(user);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id,
                                    @RequestBody @Valid UserCreateDto user){
        String response = userService.update(id, user);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> delete(@PathVariable UUID id){
        String response = userService.delete(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        List<User> response = userService.getAll();
        return ResponseEntity.ok(response);
    }

    
}
