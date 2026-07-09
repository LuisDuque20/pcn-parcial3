package com.example.parcial.parcial2.repositories;

import com.example.parcial.parcial2.domain.entities.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LectorRepository extends JpaRepository<Lector, UUID> {

    Optional<Lector> findByEmail(String email);
}
