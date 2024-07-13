package com.example.hometask42rest1.dto;

import com.example.hometask42rest1.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private UUID studentId;
    private String lastName;
    private String firstName;
    private String fullName;
    private Sex sex;
    private Integer classNum;
    private Date birthday;
    private String homeAddress;
}
