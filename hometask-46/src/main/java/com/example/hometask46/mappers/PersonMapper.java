package com.example.hometask46.mappers;

import com.example.hometask46.domain.PersonEntity;
import com.example.hometask46.dto.PersonDto;

import java.util.List;

public interface PersonMapper {
    PersonDto toDto(PersonEntity personEntity);
    PersonEntity toEntity(PersonDto personDto);
    List<PersonDto> toDtoList(List<PersonEntity> personEntities);
    List<PersonEntity> toEntityList(List<PersonDto> personDtos);
}
