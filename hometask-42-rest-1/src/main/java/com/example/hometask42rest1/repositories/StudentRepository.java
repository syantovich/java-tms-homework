package com.example.hometask42rest1.repositories;

import com.example.hometask42rest1.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
    List<Student> findByClassNum (Integer classNum);

    @Override
    List<Student> findAll();
}
