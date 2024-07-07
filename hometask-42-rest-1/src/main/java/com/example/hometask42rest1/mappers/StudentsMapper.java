package com.example.hometask42rest1.mappers;

import com.example.hometask42rest1.dto.StudentDto;
import com.example.hometask42rest1.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentsMapper {
    public Student toStudent(StudentDto studentDto);

    @Mapping(target = "fullName", source = ".", qualifiedByName = "toFullName")
    @Mapping(target = "studentId", source = "id")
    public StudentDto toStudentDto(Student student);

    public List<Student> toStudents(List<StudentDto> studentDtos);

    public List<StudentDto> toStudentDtos(List<Student> students);

    @Named("toFullName")
    default String translateToFullName(Student student) {
        return student.getFirstName() + student.getLastName();
    }
}
