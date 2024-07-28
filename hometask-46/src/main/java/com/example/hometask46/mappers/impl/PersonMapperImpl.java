package com.example.hometask46.mappers.impl;

import com.example.hometask46.domain.AuthorityEntity;
import com.example.hometask46.domain.PersonEntity;
import com.example.hometask46.dto.PersonDto;
import com.example.hometask46.enums.ERoles;
import com.example.hometask46.mappers.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonMapperImpl implements PersonMapper {

    private final PasswordEncoder passwordEncoder;

    @Override
    public PersonDto toDto(PersonEntity personEntity) {
        if (personEntity == null) {
            return null;
        }
        return PersonDto.builder()
                .id(personEntity.getId())
                .name(personEntity.getName())
                .email(personEntity.getEmail())
                .authorities(personEntity.getPerms().stream()
                        .map(perm -> ERoles.valueOf(perm.getName()))
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public PersonEntity toEntity(PersonDto personDto) {
        if (personDto == null) {
            return null;
        }
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(personDto.getId());
        personEntity.setName(personDto.getName());
        personEntity.setEmail(personDto.getEmail());
        personEntity.setPassword(passwordEncoder.encode(personDto.getPassword()));
        personEntity.setPerms(personDto.getAuthorities().stream().map(role -> {
            var authorityEntity = new AuthorityEntity();
            authorityEntity.setName(role.toRoleString());
            authorityEntity.setPerson(personEntity);
            return authorityEntity;
        }).collect(Collectors.toList()));
        return personEntity;
    }

    @Override
    public List<PersonDto> toDtoList(List<PersonEntity> personEntities) {
        if (personEntities == null) {
            return null;
        }
        return personEntities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonEntity> toEntityList(List<PersonDto> personDtos) {
        if (personDtos == null) {
            return null;
        }
        return personDtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
