package org.syantovich.hometask47.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.syantovich.hometask47.enums.ERoles;

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
