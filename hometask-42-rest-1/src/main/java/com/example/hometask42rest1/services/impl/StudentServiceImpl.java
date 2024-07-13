package com.example.hometask42rest1.services.impl;

import com.example.hometask42rest1.entities.Student;
import com.example.hometask42rest1.repositories.StudentRepository;
import com.example.hometask42rest1.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(UUID id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(UUID id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudentsByClassNum(Integer classNum) {
        return studentRepository.findByClassNum(classNum);
    }
}
