package com.example.fillmore.controller;

import com.example.fillmore.dto.request.MensalidadeRequestDTO;
import com.example.fillmore.dto.response.MensalidadeResponseDTO;
import com.example.fillmore.service.MensalidadeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mensalidades")
@RequiredArgsConstructor
public class MensalidadeController {

    private final MensalidadeService mensalidadeService;

    @PostMapping
    public ResponseEntity<MensalidadeResponseDTO> create(@Valid @RequestBody MensalidadeRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mensalidadeService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<MensalidadeResponseDTO>> findAll() {
        return ResponseEntity.ok(mensalidadeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MensalidadeResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(mensalidadeService.findById(id));
    }

    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<MensalidadeResponseDTO>> findByAlunoId(@PathVariable Long alunoId) {
        return ResponseEntity.ok(mensalidadeService.findByAlunoId(alunoId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MensalidadeResponseDTO> update(@PathVariable Long id, @Valid @RequestBody MensalidadeRequestDTO dto) {
        return ResponseEntity.ok(mensalidadeService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        mensalidadeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
