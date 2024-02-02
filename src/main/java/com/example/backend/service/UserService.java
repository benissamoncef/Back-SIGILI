package com.example.backend.service;

import com.example.backend.dto.request.UserRequest;
import com.example.backend.dto.response.UserResponse;
import com.example.backend.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    List<User> findAllUser();
    Optional<User> findById(Long id);
    User saveUser(User User);
    User updateUser(User User);
    void deleteUser(Long id);

    //    Using Request for Save and Update User
    UserResponse saveUser(UserRequest UserRequest);
    UserResponse updateUser(UserRequest UserRequest, Long id);

}