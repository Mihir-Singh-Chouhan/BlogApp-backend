package com.mihir.blog.blogAppApis.utils;

import com.mihir.blog.blogAppApis.dto.request.UserRequest;
import com.mihir.blog.blogAppApis.entities.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserServiceUtil {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static UserEntity dtoToUser(UserRequest userRequest){
//        return User.builder()
//                   .id(userDto.getId())
//                   .name(userDto.getName())
//                   .email(userDto.getEmail())
//                   .password(userDto.getPassword())
//                   .about(userDto.getAbout())
//                   .build();
        return modelMapper.map(userRequest, UserEntity.class);
    }

    public static UserRequest userToDto(UserEntity userEntity){
//        return UserDto.builder()
//                      .id(user.getId())
//                      .name(user.getName())
//                      .email(user.getEmail())
//                      .password(user.getPassword())
//                      .about(user.getAbout())
//                      .build();
        return modelMapper.map(userEntity, UserRequest.class);
    }
}
