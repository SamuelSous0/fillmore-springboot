package com.example.fillmore.repository;

import com.example.fillmore.model.Mensalidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MensalidadeRepository extends JpaRepository<Mensalidade, Long> {
    List<Mensalidade> findByAlunoId(Long alunoId);
}
