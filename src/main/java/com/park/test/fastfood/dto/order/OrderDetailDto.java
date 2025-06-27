package com.park.test.fastfood.dto.order;

import java.time.LocalDateTime;
import java.util.UUID;

import com.park.test.fastfood.dto.enums.OrderStatus;
import com.park.test.fastfood.model.DishOrder;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailDto {

    private String description;
    private OrderStatus status;
    private UUID waiterID;
    private DishOrder dishOrder;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
