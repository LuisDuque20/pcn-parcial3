package com.example.parcial.parcial2.controllers;

import com.example.parcial.parcial2.domain.dtos.LectorRequestDto;
import com.example.parcial.parcial2.domain.entities.Lector;
import com.example.parcial.parcial2.services.LectorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/lectors")
public class LectorController {

    private final LectorService lectorService;

    public LectorController(LectorService lectorService) {
        this.lectorService = lectorService;
    }

    @PostMapping("/register")
    public ResponseEntity<Lector> registerLector(@Valid @RequestBody LectorRequestDto dto) {
        return ResponseEntity.ok(lectorService.registerLector(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lector> getLectorById(@PathVariable UUID id) {
        return ResponseEntity.ok(lectorService.getLectorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lector> updateLector(@PathVariable UUID id, @Valid @RequestBody LectorRequestDto dto) {
        return ResponseEntity.ok(lectorService.updateLector(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLector(@PathVariable UUID id) {
        lectorService.deleteLector(id);
        return ResponseEntity.ok().build();
    }
}
