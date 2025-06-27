package com.park.test.fastfood.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.park.test.fastfood.model.DishOrder;
import com.park.test.fastfood.repository.DishOrderRepository;
import com.park.test.fastfood.model.Dish;

@Service
public class DishOrderService {
    @Autowired
    private DishOrderRepository dishOrderRepository;

    public DishOrder create (List<UUID> list){
        DishOrder entity = new DishOrder();
        



        return null;

    }


    //public convertDtoToEntity (List<Dish> dishes, UUID userID, 

    

    //Returns the 
    public List<Dish> getTheDishes (List<UUID> list) {

        List<Dish> dishes = new ArrayList<Dish>();
        Dish dish = new Dish();
        for (UUID uuid : list) {
            dish = getDish(uuid);
            dishes.add(dish);
        }
        return dishes;

    }


    //finds the dish with the given ID
    public Dish getDish (UUID id) {
        DishService dish = new DishService();
        
        return dish.getEntity(id);

    }


    public DishOrder getEntity (UUID id) {
        Optional<DishOrder> optional = dishOrderRepository.findById(id);

        if (optional.isEmpty()){
            throw new IllegalArgumentException();
        }

        return optional.get();
    }

}
