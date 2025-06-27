package com.park.test.fastfood.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.park.test.fastfood.dto.dish.DishCreateDto;
import com.park.test.fastfood.model.Dish;
import com.park.test.fastfood.model.User;
import com.park.test.fastfood.repository.DishRepository;
import com.park.test.fastfood.repository.UserRepository;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;


    public Dish create (DishCreateDto dto){
        Dish entity = new Dish();
        convertDtoToEntity(dto, entity);
        dishRepository.save(entity);
        
        return entity;
    }

    public DishCreateDto get (UUID id) {
        DishCreateDto dto = new DishCreateDto();
        Dish entity = getEntity(id);
        convertEntityToDto(entity, dto);

        return dto;
    }

    public String update (DishCreateDto dto) {
        Dish entity = new Dish();
        convertDtoToEntity(dto, entity);
        dishRepository.save(entity);

        return "Updated successfully";
    }

    public String delete (UUID id) {
        Dish entity = getEntity(id);
        dishRepository.delete(entity);

        return "Deleted successfully";
    }



    public void convertDtoToEntity (DishCreateDto dto, Dish entity) {
        entity.setName(dto.getName());
        entity.setDescrption(dto.getDescription());
    }

    public void convertEntityToDto (Dish entity, DishCreateDto dto) {
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescrption());
    }

    public Dish getEntity (UUID id) {

        Optional<Dish> optional = dishRepository.findById(id);

        if (optional.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return optional.get();

    }

    public List<Dish> getAll(){
        return dishRepository.findAll();
    }


}
