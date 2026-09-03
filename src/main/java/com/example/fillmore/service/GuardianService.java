package com.example.fillmore.service;

import com.example.fillmore.dto.request.GuardianRequestDTO;
import com.example.fillmore.dto.response.GuardianResponseDTO;
import com.example.fillmore.exception.BusinessException;
import com.example.fillmore.exception.ResourceNotFoundException;
import com.example.fillmore.model.Guardian;
import com.example.fillmore.model.User;
import com.example.fillmore.model.UserType;
import com.example.fillmore.repository.GuardianRepository;
import com.example.fillmore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuardianService {

    private final GuardianRepository guardianRepository;
    private final UserRepository userRepository;

    @Transactional
    public GuardianResponseDTO createGuardian(GuardianRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + dto.getUserId()));

        if (user.getType() != UserType.RESPONSAVEL && user.getType() != UserType.GUARDIAN) {
            // Suporta ambas as nomeações do Enum de tipo
        }

        Guardian guardian = Guardian.builder()
                .user(user)
                .build();

        Guardian savedGuardian = guardianRepository.save(guardian);
        return GuardianResponseDTO.fromEntity(savedGuardian);
    }

    @Transactional(readOnly = true)
    public GuardianResponseDTO getGuardianById(Long id) {
        Guardian guardian = guardianRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Guardian not found with id: " + id));
        return GuardianResponseDTO.fromEntity(guardian);
    }

    @Transactional(readOnly = true)
    public List<GuardianResponseDTO> getAllGuardians() {
        return guardianRepository.findAll().stream()
                .map(GuardianResponseDTO::fromEntity)
                .toList();
    }

    @Transactional
    public void deleteGuardian(Long id) {
        Guardian guardian = guardianRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Guardian not found with id: " + id));
        guardianRepository.delete(guardian);
    }
}