package com.fiap.futuraskill_2030.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TrilhaDTO {

    private Long id;

    @NotBlank(message = "Nome da trilha é obrigatório")
    private String nome;

    private String descricao;

    @NotBlank(message = "Nível é obrigatório")
    private String nivel;

    @NotNull
    @Min(value = 1, message = "Carga horária deve ser positiva")
    private Integer cargaHoraria;

    private String focoPrincipal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getFocoPrincipal() {
        return focoPrincipal;
    }

    public void setFocoPrincipal(String focoPrincipal) {
        this.focoPrincipal = focoPrincipal;
    }
}