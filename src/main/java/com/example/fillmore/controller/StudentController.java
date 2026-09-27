package com.example.fillmore.controller;

import com.example.fillmore.dto.request.StudentRequestDTO;
import com.example.fillmore.dto.response.StudentResponseDTO;
import com.example.fillmore.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponseDTO> create(
            @Valid @RequestBody StudentRequestDTO request) {

        StudentResponseDTO response = studentService.create(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> findAll() {

        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(studentService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody StudentRequestDTO request) {

        return ResponseEntity.ok(studentService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        studentService.delete(id);

        return ResponseEntity.noContent().build();
    }
}