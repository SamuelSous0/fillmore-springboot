package com.example.fillmore.service;

import com.example.fillmore.dto.request.GuardianRequestDTO;
import com.example.fillmore.dto.response.GuardianResponseDTO;
import com.example.fillmore.model.Guardian;
import com.example.fillmore.model.User;
import com.example.fillmore.repository.GuardianRepository;
import com.example.fillmore.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuardianService {

    private final GuardianRepository guardianRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<GuardianResponseDTO> findAll() {
        return guardianRepository.findAll()
                .stream()
                .map(GuardianResponseDTO::fromEntity)
                .toList();
    }

    @Transactional(readOnly = true)
    public GuardianResponseDTO findById(Long id) {
        Guardian guardian = guardianRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Guardian not found with id: " + id));
        return GuardianResponseDTO.fromEntity(guardian);
    }

    @Transactional
    public GuardianResponseDTO create(GuardianRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + dto.getUserId()));

        Guardian guardian = Guardian.builder()
                .user(user)
                .build();

        return GuardianResponseDTO.fromEntity(guardianRepository.save(guardian));
    }

    @Transactional
    public GuardianResponseDTO update(Long id, GuardianRequestDTO dto) {
        Guardian guardian = guardianRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Guardian not found with id: " + id));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + dto.getUserId()));

        guardian.setUser(user);

        return GuardianResponseDTO.fromEntity(guardianRepository.save(guardian));
    }

    @Transactional
    public void delete(Long id) {
        if (!guardianRepository.existsById(id)) {
            throw new EntityNotFoundException("Guardian not found with id: " + id);
        }
        guardianRepository.deleteById(id);
    }
}