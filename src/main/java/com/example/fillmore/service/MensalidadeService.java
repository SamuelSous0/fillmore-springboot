package com.example.fillmore.service;

import com.example.fillmore.dto.request.MensalidadeRequestDTO;
import com.example.fillmore.dto.response.MensalidadeResponseDTO;
import com.example.fillmore.model.Mensalidade;
import com.example.fillmore.repository.MensalidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MensalidadeService {

    private final MensalidadeRepository mensalidadeRepository;

    public MensalidadeResponseDTO create(MensalidadeRequestDTO dto) {
        Mensalidade mensalidade = Mensalidade.builder()
                .alunoId(dto.getAlunoId())
                .mesReferencia(dto.getMesReferencia())
                .anoReferencia(dto.getAnoReferencia())
                .valor(dto.getValor())
                .status(dto.getStatus())
                .dataPagamento(dto.getDataPagamento())
                .build();
        
        Mensalidade saved = mensalidadeRepository.save(mensalidade);
        return toResponseDTO(saved);
    }

    public List<MensalidadeResponseDTO> findAll() {
        return mensalidadeRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public List<MensalidadeResponseDTO> findByAlunoId(Long alunoId) {
        return mensalidadeRepository.findByAlunoId(alunoId).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public MensalidadeResponseDTO findById(Long id) {
        Mensalidade mensalidade = mensalidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mensalidade não encontrada"));
        return toResponseDTO(mensalidade);
    }

    public MensalidadeResponseDTO update(Long id, MensalidadeRequestDTO dto) {
        Mensalidade mensalidade = mensalidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mensalidade não encontrada"));

        mensalidade.setAlunoId(dto.getAlunoId());
        mensalidade.setMesReferencia(dto.getMesReferencia());
        mensalidade.setAnoReferencia(dto.getAnoReferencia());
        mensalidade.setValor(dto.getValor());
        mensalidade.setStatus(dto.getStatus());
        mensalidade.setDataPagamento(dto.getDataPagamento());

        Mensalidade updated = mensalidadeRepository.save(mensalidade);
        return toResponseDTO(updated);
    }

    public void delete(Long id) {
        mensalidadeRepository.deleteById(id);
    }

    private MensalidadeResponseDTO toResponseDTO(Mensalidade mensalidade) {
        MensalidadeResponseDTO dto = new MensalidadeResponseDTO();
        dto.setId(mensalidade.getId());
        dto.setAlunoId(mensalidade.getAlunoId());
        dto.setMesReferencia(mensalidade.getMesReferencia());
        dto.setAnoReferencia(mensalidade.getAnoReferencia());
        dto.setValor(mensalidade.getValor());
        dto.setStatus(mensalidade.getStatus());
        dto.setDataPagamento(mensalidade.getDataPagamento());
        return dto;
    }
}
