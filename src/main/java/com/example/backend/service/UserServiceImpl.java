package com.example.backend.service;

import com.example.backend.dto.mapper.UserMapper;
import com.example.backend.dto.request.UserRequest;
import com.example.backend.dto.response.UserResponse;
import com.example.backend.entity.User;
import com.example.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository UserRepository;

    public UserServiceImpl(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    @Override
    public List<User> findAllUser() {
        return UserRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return UserRepository.findById(id);
    }

    @Override
    public User saveUser(User User) {
        return UserRepository.save(User);
    }

    @Override
    public User updateUser(User User) {
        return UserRepository.save(User);
    }

    @Override
    public void deleteUser(Long id) {
        UserRepository.deleteById(id);
    }

//    Using Request and Response with save and update User

    @Override
    public UserResponse saveUser(UserRequest UserRequest) {
        User User = UserMapper.MAPPER.fromRequestToEntity(UserRequest);
        UserRepository.save(User);
        return UserMapper.MAPPER.fromEntityToResponse(User);
    }

    @Override
    public UserResponse updateUser(UserRequest UserRequest, Long id) {

        Optional<User> checkExistingUser = findById(id);
        if (! checkExistingUser.isPresent())
            throw new RuntimeException("User Id "+ id + " Not Found!");

        User User = UserMapper.MAPPER.fromRequestToEntity(UserRequest);
        User.setId(id);
        UserRepository.save(User);
        return UserMapper.MAPPER.fromEntityToResponse(User);
    }

}