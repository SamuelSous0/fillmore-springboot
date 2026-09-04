package com.example.fillmore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * Esqueleto inicial da entidade Aluno criado apenas para estabelecer
 * o relacionamento com a entidade Mensalidade.
 * O responsável pela gestão de Alunos adicionará os demais campos aqui.
 */
@Entity
@Table(name = "alunos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Os demais campos (nome, endereco, escola, etc.) devem ser implementados aqui.
}
