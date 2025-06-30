package com.park.test.fastfood.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.park.test.fastfood.dto.order.OrderCreateDto;
import com.park.test.fastfood.model.Dish;
import com.park.test.fastfood.model.DishOrder;
import com.park.test.fastfood.model.Order;
import com.park.test.fastfood.model.User;
import com.park.test.fastfood.repository.OrderRepository;
import com.park.test.fastfood.repository.UserRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    private UserRepository userRepository;

    public Order create(OrderCreateDto dto){

        User user = new User();
        UserService userService = new UserService();
        user = userService.getEntity(dto.getUserID());
        

        Order entity = new Order();
        entity.setUser(user);
        convertDtoToEntity(dto, entity);
        entity.setCreatedAt(LocalDateTime.now());

        orderRepository.save(entity);

        return entity;
    }

    

    public void convertDtoToEntity (OrderCreateDto dto, Order entity) {

        
        
        HashMap<UUID, Integer> dishQuantities = dto.getDishQuantities;
        List<DishOrder> dishOrders = new ArrayList<>();

        for ( UUID dishId : dishQuantities.keySet()) {

            int quantity = dishQuantities.get(dishId);

            Dish dish = new Dish();
            DishService dishService = new DishService();
            dish = dishService.getEntity(dishId);

            DishOrder dishOrder = new DishOrder();
            dishOrder.setDish(dish);
            dishOrder.setQuantity(quantity);
            dishOrder.setOrder(entity);


            dishOrders.add(dishOrder);
        }

        entity.setDishes(dishOrders);
        entity.setUserID(dto.getUserID());
        entity.setUpdatedAt(LocalDateTime.now());
    }







    public String delete (UUID id) {
        Order entity = getEntity(id);
        orderRepository.delete(entity);

        return "Deleted successfully!";
    }

    public Order getEntity (UUID id) {
        Optional<Order> optional = orderRepository.findById(id);

        if (optional.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return optional.get();
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
