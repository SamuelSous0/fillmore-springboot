package com.example.fillmore.dto.request;

import com.example.fillmore.model.StatusMensalidade;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class MensalidadeRequestDTO {

    @NotNull(message = "O ID do aluno é obrigatório")
    private Long alunoId;

    @NotNull(message = "O mês de referência é obrigatório")
    private Integer mesReferencia;

    @NotNull(message = "O ano de referência é obrigatório")
    private Integer anoReferencia;

    @NotNull(message = "O valor da mensalidade é obrigatório")
    @Positive(message = "O valor deve ser maior que zero")
    private BigDecimal valor;

    @NotNull(message = "O status da mensalidade é obrigatório")
    private StatusMensalidade status;

    private LocalDate dataPagamento;
}
