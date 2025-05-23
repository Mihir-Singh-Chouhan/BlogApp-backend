package com.mihir.blog.blogAppApis.services.impl;

import com.mihir.blog.blogAppApis.entities.UserEntity;
import com.mihir.blog.blogAppApis.dto.request.UserRequest;
import com.mihir.blog.blogAppApis.services.UserService;
import com.mihir.blog.blogAppApis.repositories.UserRepository;
import com.mihir.blog.blogAppApis.utils.UserServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mihir.blog.blogAppApis.exceptions.ResourceNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static com.mihir.blog.blogAppApis.utils.UserServiceUtil.dtoToUser;
import static com.mihir.blog.blogAppApis.utils.UserServiceUtil.userToDto;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserRequest createUser(UserRequest userRequest) {
        UserEntity userEntity = dtoToUser(userRequest);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return userToDto(savedUserEntity);
    }

    @Override
    public UserRequest updateUser(UserRequest userRequest, Integer userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User","Id",userId));

        userEntity.setName(userRequest.getName());
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setPassword(userEntity.getPassword());
        userEntity.setAbout(userEntity.getAbout());

        UserEntity updatedUserEntity = this.userRepository.save(userEntity);
        return userToDto(updatedUserEntity);

    }

    @Override
    public UserRequest getUserById(Integer userId) {

        UserEntity userEntity = userRepository.findById(userId).orElseThrow(()->
                    new ResourceNotFoundException("User","Id",userId));
        return userToDto(userEntity);
    }

    @Override
    public List<UserRequest> getAllUsers() {

        List<UserEntity> userEntities = this.userRepository.findAll();
//       List<UserDto> userDtos = users.stream().map(UserServiceUtil::userToDto).collect(Collectors.toList());
        return userEntities.stream().map(UserServiceUtil::userToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        userRepository.delete(userEntity);
    }


}
