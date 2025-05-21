package com.mihir.blog.blogAppApis.utils;

import com.mihir.blog.blogAppApis.dto.UserDto;
import com.mihir.blog.blogAppApis.entities.User;


public class UserServiceUtil {

    public static User dtoToUser(UserDto userDto){
        return User.builder()
//                .id(userDto.getId())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .about(userDto.getAbout())
                .build();
    }

    public static UserDto userToDto(User user){
//        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setEmail(user.getEmail());
//        userDto.setPassword(user.getPassword());
//        userDto.setAbout(user.getAbout());
//        return userDto;

        return UserDto.builder()
//                      .id(user.getId())
                      .name(user.getName())
                      .email(user.getEmail())
                      .password(user.getPassword())
                      .about(user.getAbout())
                      .build();
    }
}
