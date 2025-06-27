package com.park.test.fastfood.dto.User;

import com.park.test.fastfood.dto.enums.UserStatus;
import com.park.test.fastfood.dto.enums.UserTitle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailDto {
    private String name;
    private String surname;
    private String email;
    private String address;
    private UserStatus status;
    private UserTitle title;
}
