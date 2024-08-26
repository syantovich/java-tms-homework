package org.syantovich.hometask47.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.syantovich.hometask47.domain.PersonEntity;

import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {
   Optional<PersonEntity> findByEmail(String email);
}
