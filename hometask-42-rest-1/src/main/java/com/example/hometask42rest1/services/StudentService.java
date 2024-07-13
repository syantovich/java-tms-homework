package com.example.hometask42rest1.services;

import com.example.hometask42rest1.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(UUID id);
    Student addStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudent(UUID id);
    List<Student> getStudentsByClassNum(Integer classNum);
}
