package com.example.fillmore.dto.response;

import lombok.Data;

@Data
public class DriverResponseDTO {
    private Long id;
    private Long userId;
    private String userName; // útil para o frontend não precisar fazer duas requisições
    private String cnh;
    private String licensePlate;
    private Integer vanCapacity;
}
