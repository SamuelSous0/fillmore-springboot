package com.example.fillmore.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequestDTO {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @NotNull(message = "Latitude is mandatory")
    private Double latitude;

    @NotNull(message = "Longitude is mandatory")
    private Double longitude;

    @NotBlank(message = "School is mandatory")
    private String school;

    @NotNull(message = "Guardian is mandatory")
    private Long guardianId;

    private Long routeId;

    private Integer routeOrder;
}