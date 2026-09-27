package com.example.fillmore.service;

import com.example.fillmore.dto.request.StudentRequestDTO;
import com.example.fillmore.dto.response.StudentResponseDTO;
import com.example.fillmore.model.Guardian;
import com.example.fillmore.model.Route;
import com.example.fillmore.model.Student;
import com.example.fillmore.repository.GuardianRepository;
import com.example.fillmore.repository.RouteRepository;
import com.example.fillmore.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final GuardianRepository guardianRepository;
    private final RouteRepository routeRepository;

    public StudentResponseDTO create(StudentRequestDTO request) {

        Guardian guardian = guardianRepository.findById(request.getGuardianId())
                .orElseThrow(() -> new RuntimeException("Guardian not found"));

        Route route = null;

        if (request.getRouteId() != null) {
            route = routeRepository.findById(request.getRouteId())
                    .orElseThrow(() -> new RuntimeException("Route not found"));
        }

        Student student = Student.builder()
                .name(request.getName())
                .address(request.getAddress())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .school(request.getSchool())
                .guardian(guardian)
                .route(route)
                .routeOrder(request.getRouteOrder())
                .build();

        Student savedStudent = studentRepository.save(student);

        return StudentResponseDTO.fromEntity(savedStudent);
    }

    public List<StudentResponseDTO> findAll() {

        return studentRepository.findAll()
                .stream()
                .map(StudentResponseDTO::fromEntity)
                .toList();
    }

    public StudentResponseDTO findById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return StudentResponseDTO.fromEntity(student);
    }

    public StudentResponseDTO update(Long id, StudentRequestDTO request) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Guardian guardian = guardianRepository.findById(request.getGuardianId())
                .orElseThrow(() -> new RuntimeException("Guardian not found"));

        Route route = null;

        if (request.getRouteId() != null) {
            route = routeRepository.findById(request.getRouteId())
                    .orElseThrow(() -> new RuntimeException("Route not found"));
        }

        student.setName(request.getName());
        student.setAddress(request.getAddress());
        student.setLatitude(request.getLatitude());
        student.setLongitude(request.getLongitude());
        student.setSchool(request.getSchool());
        student.setGuardian(guardian);
        student.setRoute(route);
        student.setRouteOrder(request.getRouteOrder());

        Student updatedStudent = studentRepository.save(student);

        return StudentResponseDTO.fromEntity(updatedStudent);
    }

    public void delete(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        studentRepository.delete(student);
    }
}