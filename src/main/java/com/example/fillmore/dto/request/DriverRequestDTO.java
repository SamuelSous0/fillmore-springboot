package com.example.fillmore.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class DriverRequestDTO {

    @NotNull(message = "O ID do usuário é obrigatório")
    private Long userId;

    @NotBlank(message = "A CNH é obrigatória")
    private String cnh;

    @NotBlank(message = "A placa do veículo é obrigatória")
    private String licensePlate;

    @NotNull(message = "A capacidade da van é obrigatória")
    @Positive(message = "A capacidade da van deve ser maior que zero")
    private Integer vanCapacity;
}