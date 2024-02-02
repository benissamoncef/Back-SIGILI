package com.example.backend.controller;

import com.example.backend.dto.request.UserRequest;
import com.example.backend.dto.response.UserResponse;
import com.example.backend.entity.User;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/User")
public class UserController {


    @Autowired
    private final UserService UserService;


    public UserController(UserService UserService) {
        this.UserService = UserService;
    }


    @GetMapping
    public List<User> findAllUser() {
        return UserService.findAllUser();
    }

    @GetMapping("/{id}")
    public Optional<User> findUserById(@PathVariable("id") Long id) {
        return UserService.findById(id);
    }

    @PostMapping
    public User saveUser(@RequestBody User User) {
        return UserService.saveUser(User);
    }

    @PutMapping
    public User updateUser(@RequestBody User User) {
        return UserService.updateUser(User);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        UserService.deleteUser(id);
    }

//    Using Request and Response with save and update User

    @PostMapping("/res")
    public UserResponse saveEmpResponse(@RequestBody UserRequest UserRequest) {
        return UserService.saveUser(UserRequest);
    }

    @PutMapping("/res/{id}")
    public UserResponse updateEmpResponse(@RequestBody UserRequest UserRequest, @PathVariable("id") Long id) {
        return UserService.updateUser(UserRequest, id);
    }

}