package com.example.hometask46.repository;

import com.example.hometask46.domain.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {
   Optional<PersonEntity> findByEmail(String email);
}
