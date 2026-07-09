package com.example.parcial.parcial2.services;

import com.example.parcial.parcial2.domain.dtos.LectorRequestDto;
import com.example.parcial.parcial2.domain.entities.Lector;
import com.example.parcial.parcial2.repositories.LectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LectorService {

    private final LectorRepository lectorRepository;

    public LectorService(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    public Lector registerLector(LectorRequestDto dto) {
        Lector lector = new Lector();
        lector.setName(dto.getName().toLowerCase());
        lector.setLastname(dto.getLastname().toLowerCase());
        lector.setDui(dto.getDui());
        lector.setEmail(dto.getName().toLowerCase() + "." + dto.getLastname().toLowerCase() + "@library.com");
        lector.setActive(true);
        return lectorRepository.save(lector);
    }

    public Lector getLectorById(UUID id) {
        return lectorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lector not found"));
    }

    public Lector updateLector(UUID id, LectorRequestDto dto) {
        Lector lector = lectorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lector not found"));
        lector.setName(dto.getName());
        lector.setLastname(dto.getLastname());
        lector.setDui(dto.getDui());
        return lectorRepository.save(lector);
    }

    public void deleteLector(UUID id) {
        Lector lector = lectorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lector not found"));
        lector.setActive(false);
        lectorRepository.save(lector);
    }
}
