package com.company.demo.utils;

import com.company.demo.dto.request.UserRequest;
import com.company.demo.dto.response.UserResponse;
import com.company.demo.entities.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserServiceUtil {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static UserEntity dtoToUser(UserRequest userRequest){

        return new UserEntity(null,userRequest.getName(),userRequest.getEmail(),userRequest.getPassword(),userRequest.getAbout(),null);
//        return modelMapper.map(userRequest, UserEntity.class);
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
