package com.example.hometask46.dto;

import com.example.hometask46.domain.AuthorityEntity;
import com.example.hometask46.enums.ERoles;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonDto {
    UUID id;
    String name;
    String email;
    String password;
    List<ERoles> authorities;
}
