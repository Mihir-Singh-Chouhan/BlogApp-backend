package com.mihir.blog.blogAppApis.services.impl;

import com.mihir.blog.blogAppApis.entities.User;
import com.mihir.blog.blogAppApis.dto.UserDto;
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
    public UserDto createUser(UserDto userDto) {
        User user = dtoToUser(userDto);
        User savedUser = userRepository.save(user);
        return userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User","Id",userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(user.getPassword());
        user.setAbout(user.getAbout());

        User updatedUser = this.userRepository.save(user);
        return userToDto(updatedUser);

    }

    @Override
    public UserDto getUserById(Integer userId) {

        User user = userRepository.findById(userId).orElseThrow(()->
                    new ResourceNotFoundException("User","Id",userId));
        return userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User> users = this.userRepository.findAll();
       List<UserDto> userDtos = users.stream().map(UserServiceUtil::userToDto).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        userRepository.delete(user);
    }


}
