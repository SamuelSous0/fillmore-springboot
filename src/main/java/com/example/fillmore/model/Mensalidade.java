package com.example.fillmore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table(name = "mensalidades")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mensalidade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO: Refatorar para @ManyToOne(targetEntity = Aluno.class) quando a entidade Aluno for criada.
    @Column(name = "aluno_id", nullable = false)
    private Long alunoId;

    @Column(nullable = false)
    private Integer mesReferencia; // 1-12

    @Column(nullable = false)
    private Integer anoReferencia;

    @Column(nullable = false)
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusMensalidade status;

    private LocalDate dataPagamento;
}
