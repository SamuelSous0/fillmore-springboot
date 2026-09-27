package com.example.fillmore.dto.response;

import com.example.fillmore.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponseDTO {

    private Long id;
    private String name;
    private String address;
    private Double latitude;
    private Double longitude;
    private String school;
    private Long guardianId;
    private Long routeId;
    private Integer routeOrder;

    public static StudentResponseDTO fromEntity(Student student) {
        if (student == null) return null;

        return StudentResponseDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .address(student.getAddress())
                .latitude(student.getLatitude())
                .longitude(student.getLongitude())
                .school(student.getSchool())
                .guardianId(
                        student.getGuardian() != null
                                ? student.getGuardian().getId()
                                : null
                )
                .routeId(
                        student.getRoute() != null
                                ? student.getRoute().getId()
                                : null
                )
                .routeOrder(student.getRouteOrder())
                .build();
    }
}