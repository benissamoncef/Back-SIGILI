package com.example.backend.dto.mapper;
import com.example.backend.dto.request.UserRequest;
import com.example.backend.dto.response.UserResponse;
import com.example.backend.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
    User fromRequestToEntity(UserRequest userRequest);
    UserResponse fromEntityToResponse(User User);
}