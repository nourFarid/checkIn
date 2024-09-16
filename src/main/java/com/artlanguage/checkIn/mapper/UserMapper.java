package com.artlanguage.checkIn.mapper;

import com.artlanguage.checkIn.DTO.UsersDTO;
import com.artlanguage.checkIn.DTO.UsersResponseDTO;
import com.artlanguage.checkIn.entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Users toEntity(UsersDTO dto);
    UsersDTO toDto(Users entity);
    UsersResponseDTO toResponseDto(Users user);
}
