package com.example.fillmore.repository;

import com.example.fillmore.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    // TODO: descomentar quando Driver for adicionado ao projeto
    // List<Route> findByDriverId(Long driverId);
}
