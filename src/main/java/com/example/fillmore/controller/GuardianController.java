package com.example.fillmore.controller;

import com.example.fillmore.dto.request.GuardianRequestDTO;
import com.example.fillmore.dto.response.GuardianResponseDTO;
import com.example.fillmore.service.GuardianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guardians")
@RequiredArgsConstructor
public class GuardianController {

    private final GuardianService guardianService;

    @GetMapping
    public ResponseEntity<List<GuardianResponseDTO>> findAll() {
        return ResponseEntity.ok(guardianService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuardianResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(guardianService.findById(id));
    }

    @PostMapping
    public ResponseEntity<GuardianResponseDTO> create(@Valid @RequestBody GuardianRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(guardianService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuardianResponseDTO> update(@PathVariable Long id, @Valid @RequestBody GuardianRequestDTO dto) {
        return ResponseEntity.ok(guardianService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        guardianService.delete(id);
        return ResponseEntity.noContent().build();
    }
}