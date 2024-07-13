package com.example.hometask42rest1.controllers;

import com.example.hometask42rest1.dto.StudentDto;
import com.example.hometask42rest1.entities.Student;
import com.example.hometask42rest1.mappers.StudentsMapper;
import com.example.hometask42rest1.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentsMapper studentsMapper;

    @GetMapping
    public List<StudentDto> getStudents(@RequestParam(name = "classNum", required = false) Integer classNum) {
        if (classNum != null) {
            return studentsMapper.toStudentDtos(studentService.getStudentsByClassNum(classNum));
        }
        return studentsMapper.toStudentDtos(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public StudentDto getStudent(@PathVariable UUID id) {
        return studentsMapper.toStudentDto(studentService.getStudentById(id));
    }

    @PostMapping
    public StudentDto addStudent(@RequestBody StudentDto studentDto) {
        Student student = studentService.addStudent(studentsMapper.toStudent(studentDto));
        return studentsMapper.toStudentDto(student);
    }

    @PutMapping("/{id}")
    public StudentDto updateStudent(@PathVariable UUID id, @RequestBody StudentDto studentDto) {
        Student student = studentService.updateStudent(studentsMapper.toStudent(studentDto));
        return studentsMapper.toStudentDto(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable UUID id) {
        studentService.deleteStudent(id);
    }
}
