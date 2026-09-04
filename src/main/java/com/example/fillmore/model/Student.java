package com.example.fillmore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private Double latitude;

    private Double longitude;

    private String school;

    @ManyToOne
    @JoinColumn(name = "guardian_id", referencedColumnName = "id", nullable = false)
    private Guardian guardian;

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private Route route;

    private Integer routeOrder;
}