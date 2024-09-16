package com.artlanguage.checkIn.mapper;

import com.artlanguage.checkIn.DTO.CheckInDto;
import com.artlanguage.checkIn.entity.CheckIn;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface CheckInMapper {
    CheckIn toEntity(CheckInDto dto);
    CheckInDto toDto(CheckIn entity);

}
