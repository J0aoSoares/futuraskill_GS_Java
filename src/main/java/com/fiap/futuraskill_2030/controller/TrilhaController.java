package com.fiap.futuraskill_2030.controller;

import com.fiap.futuraskill_2030.dto.TrilhaDTO;
import com.fiap.futuraskill_2030.service.TrilhaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/trilhas")
public class TrilhaController {

    private final TrilhaService trilhaService;

    public TrilhaController(TrilhaService trilhaService) {
        this.trilhaService = trilhaService;
    }

    @GetMapping
    public ResponseEntity<List<TrilhaDTO>> listar() {
        return ResponseEntity.ok(trilhaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrilhaDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(trilhaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<TrilhaDTO> criar(@Valid @RequestBody TrilhaDTO dto) {
        TrilhaDTO criado = trilhaService.criar(dto);
        return ResponseEntity
                .created(URI.create("/api/trilhas/" + criado.getId()))
                .body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrilhaDTO> atualizar(@PathVariable Long id,
                                               @Valid @RequestBody TrilhaDTO dto) {
        return ResponseEntity.ok(trilhaService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        trilhaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
