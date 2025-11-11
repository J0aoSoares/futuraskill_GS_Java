package com.fiap.futuraskill_2030.service;

import com.fiap.futuraskill_2030.dto.UsuarioDTO;
import com.fiap.futuraskill_2030.entities.Usuario;
import com.fiap.futuraskill_2030.exception.ResourceNotFoundException;
import com.fiap.futuraskill_2030.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDTO> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        return toDTO(usuario);
    }

    public UsuarioDTO criar(UsuarioDTO dto) {
        usuarioRepository.findByEmail(dto.getEmail()).ifPresent(u -> {
            throw new RuntimeException("Email já cadastrado");
        });

        Usuario u = new Usuario();
        u.setNome(dto.getNome());
        u.setEmail(dto.getEmail());
        u.setAreaAtuacao(dto.getAreaAtuacao());
        u.setNivelCarreira(dto.getNivelCarreira());
        u.setDataCadastro(LocalDate.now());

        Usuario salvo = usuarioRepository.save(u);
        return toDTO(salvo);
    }

    public UsuarioDTO atualizar(Long id, UsuarioDTO dto) {
        Usuario u = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        u.setNome(dto.getNome());
        u.setEmail(dto.getEmail());
        u.setAreaAtuacao(dto.getAreaAtuacao());
        u.setNivelCarreira(dto.getNivelCarreira());

        Usuario salvo = usuarioRepository.save(u);
        return toDTO(salvo);
    }

    public void deletar(Long id) {
        Usuario u = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        usuarioRepository.delete(u);
    }

    private UsuarioDTO toDTO(Usuario u) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(u.getId());
        dto.setNome(u.getNome());
        dto.setEmail(u.getEmail());
        dto.setAreaAtuacao(u.getAreaAtuacao());
        dto.setNivelCarreira(u.getNivelCarreira());
        return dto;
    }
}
