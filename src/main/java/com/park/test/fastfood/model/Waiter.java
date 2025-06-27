package com.park.test.fastfood.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.park.test.fastfood.dto.enums.UserStatus;
import com.park.test.fastfood.dto.enums.UserTitle;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "waiter")
public class Waiter{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String password;
    private UserStatus status;

    @Column(name = "user_title")
    private UserTitle userTitle;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
        
}
