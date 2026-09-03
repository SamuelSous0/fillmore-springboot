package com.example.fillmore.dto.response;

import com.example.fillmore.model.StatusMensalidade;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class MensalidadeResponseDTO {
    private Long id;
    private Long alunoId;
    private Integer mesReferencia;
    private Integer anoReferencia;
    private BigDecimal valor;
    private StatusMensalidade status;
    private LocalDate dataPagamento;
}
