package com.fiap.futuraskill_2030.service;

import com.fiap.futuraskill_2030.dto.TrilhaDTO;
import com.fiap.futuraskill_2030.entities.Trilha;
import com.fiap.futuraskill_2030.exception.ResourceNotFoundException;
import com.fiap.futuraskill_2030.repository.TrilhaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrilhaService {

    private final TrilhaRepository trilhaRepository;

    public TrilhaService(TrilhaRepository trilhaRepository) {
        this.trilhaRepository = trilhaRepository;
    }

    public List<TrilhaDTO> listarTodos() {
        return trilhaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public TrilhaDTO buscarPorId(Long id) {
        Trilha trilha = trilhaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trilha não encontrada"));
        return toDTO(trilha);
    }

    public TrilhaDTO criar(TrilhaDTO dto) {
        Trilha t = new Trilha();
        t.setNome(dto.getNome());
        t.setDescricao(dto.getDescricao());
        t.setNivel(dto.getNivel());
        t.setCargaHoraria(dto.getCargaHoraria());
        t.setFocoPrincipal(dto.getFocoPrincipal());

        Trilha salvo = trilhaRepository.save(t);
        return toDTO(salvo);
    }

    public TrilhaDTO atualizar(Long id, TrilhaDTO dto) {
        Trilha t = trilhaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trilha não encontrada"));

        t.setNome(dto.getNome());
        t.setDescricao(dto.getDescricao());
        t.setNivel(dto.getNivel());
        t.setCargaHoraria(dto.getCargaHoraria());
        t.setFocoPrincipal(dto.getFocoPrincipal());

        Trilha salvo = trilhaRepository.save(t);
        return toDTO(salvo);
    }

    public void deletar(Long id) {
        Trilha t = trilhaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trilha não encontrada"));
        trilhaRepository.delete(t);
    }

    private TrilhaDTO toDTO(Trilha t) {
        TrilhaDTO dto = new TrilhaDTO();
        dto.setId(t.getId());
        dto.setNome(t.getNome());
        dto.setDescricao(t.getDescricao());
        dto.setNivel(t.getNivel());
        dto.setCargaHoraria(t.getCargaHoraria());
        dto.setFocoPrincipal(t.getFocoPrincipal());
        return dto;
    }
}
