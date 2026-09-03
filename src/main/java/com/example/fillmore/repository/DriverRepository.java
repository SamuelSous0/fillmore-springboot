package com.example.fillmore.repository;

import com.example.fillmore.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByCnh(String cnh);

    Optional<Driver> findByUserId(Long userId);
}
