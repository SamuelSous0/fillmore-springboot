package com.example.fillmore.repository;

import com.example.fillmore.model.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuardianRepository extends JpaRepository<Guardian, Long> {
}