package org.syantovich.hometask47.mappers;


import org.syantovich.hometask47.domain.PersonEntity;
import org.syantovich.hometask47.dto.PersonDto;

import java.util.List;

public interface PersonMapper {
    PersonDto toDto(PersonEntity personEntity);
    PersonEntity toEntity(PersonDto personDto);
    List<PersonDto> toDtoList(List<PersonEntity> personEntities);
    List<PersonEntity> toEntityList(List<PersonDto> personDtos);
}
