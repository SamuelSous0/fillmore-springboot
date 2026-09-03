package com.example.fillmore.controller;

import com.example.fillmore.dto.request.GuardianRequestDTO;
import com.example.fillmore.dto.response.GuardianResponseDTO;
import com.example.fillmore.service.GuardianService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guardians")
@RequiredArgsConstructor
@Tag(name = "Guardians", description = "Guardian management APIs")
public class GuardianController {

    private final GuardianService guardianService;

    @PostMapping
    @Operation(summary = "Create a new guardian associated with a user")
    public ResponseEntity<GuardianResponseDTO> createGuardian(@Valid @RequestBody GuardianRequestDTO dto) {
        GuardianResponseDTO response = guardianService.createGuardian(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get guardian by ID")
    public ResponseEntity<GuardianResponseDTO> getGuardianById(@PathVariable Long id) {
        return ResponseEntity.ok(guardianService.getGuardianById(id));
    }

    @GetMapping
    @Operation(summary = "List all guardians")
    public ResponseEntity<List<GuardianResponseDTO>> getAllGuardians() {
        return ResponseEntity.ok(guardianService.getAllGuardians());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a guardian")
    public ResponseEntity<Void> deleteGuardian(@PathVariable Long id) {
        guardianService.deleteGuardian(id);
        return ResponseEntity.noContent().build();
    }
}