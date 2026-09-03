package com.example.fillmore.service;

import com.example.fillmore.dto.request.DriverRequestDTO;
import com.example.fillmore.dto.response.DriverResponseDTO;
import com.example.fillmore.exception.ResourceNotFoundException;
import com.example.fillmore.model.Driver;
import com.example.fillmore.model.User;
import com.example.fillmore.repository.DriverRepository;
import com.example.fillmore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;
    private final UserRepository userRepository;

    public DriverResponseDTO createDriver(DriverRequestDTO requestDTO) {
        // Busca o usuário existente
        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Usuário não encontrado com o ID: " + requestDTO.getUserId()));

        // Monta o Motorista
        Driver driver = new Driver();
        driver.setUser(user);
        driver.setCnh(requestDTO.getCnh());
        driver.setLicensePlate(requestDTO.getLicensePlate());
        driver.setVanCapacity(requestDTO.getVanCapacity());

        driver = driverRepository.save(driver);
        return convertToResponse(driver);
    }

    private DriverResponseDTO convertToResponse(Driver driver) {
        DriverResponseDTO responseDTO = new DriverResponseDTO();
        responseDTO.setId(driver.getId());
        responseDTO.setUserId(driver.getUser().getId());
        responseDTO.setUserName(driver.getUser().getName());
        responseDTO.setCnh(driver.getCnh());
        responseDTO.setLicensePlate(driver.getLicensePlate());
        responseDTO.setVanCapacity(driver.getVanCapacity());
        return responseDTO;
    }

}