package com.mihir.blog.blogAppApis.utils;

import com.mihir.blog.blogAppApis.dto.request.UserDto;
import com.mihir.blog.blogAppApis.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserServiceUtil {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static User dtoToUser(UserDto userDto){
//        return User.builder()
//                   .id(userDto.getId())
//                   .name(userDto.getName())
//                   .email(userDto.getEmail())
//                   .password(userDto.getPassword())
//                   .about(userDto.getAbout())
//                   .build();
        return modelMapper.map(userDto,User.class);
    }

    public static UserDto userToDto(User user){
//        return UserDto.builder()
//                      .id(user.getId())
//                      .name(user.getName())
//                      .email(user.getEmail())
//                      .password(user.getPassword())
//                      .about(user.getAbout())
//                      .build();
        return modelMapper.map(user, UserDto.class);
    }
}
