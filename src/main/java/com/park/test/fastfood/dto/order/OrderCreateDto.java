package com.park.test.fastfood.dto.order;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

import com.park.test.fastfood.dto.enums.OrderStatus;
import com.park.test.fastfood.model.DishOrder;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderCreateDto {

    @NotNull(message = "userID is null")
    @NotEmpty(message = "userID is empty")
    private UUID userID;
    
    public HashMap<UUID, Integer> getDishQuantities;

    private String description;
}
