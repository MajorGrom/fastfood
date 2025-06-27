package com.park.test.fastfood.dto.dish;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter

public class DishCreateDto {
        
        private UUID dishID;
        @NotEmpty(message = "Dish name is empty")
        @NotNull(message = "Dish name is null")
        private String name;

        @NotEmpty(message = "Descpription is empty")
        @NotNull(message = "Descpription is null")
        private String description;
}
