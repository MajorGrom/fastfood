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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.park.test.fastfood.dto.User.UserCreateDto;
import com.park.test.fastfood.dto.User.UserDetailDto;
import com.park.test.fastfood.dto.dish.DishCreateDto;
import com.park.test.fastfood.model.Dish;
import com.park.test.fastfood.model.User;
import com.park.test.fastfood.service.DishService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/dish")

public class DishController {
    @Autowired
    DishService dishService;

        @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable UUID id){
        DishCreateDto response = dishService.get(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid DishCreateDto dto){
        Dish response = dishService.create(dto);
        return ResponseEntity.ok(response);
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<?> update(@PathVariable UUID id,
    //                                 @RequestBody @Valid DishCreateDto dto){
    //     String response = .update(id, dto);
    //     return ResponseEntity.ok(response);
    // }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> delete(@PathVariable UUID id){
        String response = dishService.delete(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        List<Dish> response = dishService.getAll();
        return ResponseEntity.ok(response);
    }

}
