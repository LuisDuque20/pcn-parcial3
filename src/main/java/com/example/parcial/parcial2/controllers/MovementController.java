package com.example.parcial.parcial2.controllers;

import com.example.parcial.parcial2.domain.dtos.MovementRequestDto;
import com.example.parcial.parcial2.domain.entities.Movement;
import com.example.parcial.parcial2.services.MovementService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movements")
public class MovementController {

    private final MovementService movementService;

    public MovementController(MovementService movementService) {
        this.movementService = movementService;
    }

    @PostMapping("/borrow")
    public ResponseEntity<Movement> borrowBook(@Valid @RequestBody MovementRequestDto dto) {
        return ResponseEntity.ok(movementService.borrowBook(dto));
    }

    @PostMapping("/return")
    public ResponseEntity<Movement> returnBook(@Valid @RequestBody MovementRequestDto dto) {
        return ResponseEntity.ok(movementService.returnBook(dto));
    }
}
