package com.fiap.futuraskill_2030.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "area_atuacao")
    private String areaAtuacao;

    @Column(name = "nivel_carreira")
    private String nivelCarreira;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    public Usuario() {
    }

    public Usuario(String nome, String email, String areaAtuacao, String nivelCarreira) {
        this.nome = nome;
        this.email = email;
        this.areaAtuacao = areaAtuacao;
        this.nivelCarreira = nivelCarreira;
        this.dataCadastro = LocalDate.now();
    }


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getNivelCarreira() {
        return nivelCarreira;
    }

    public void setNivelCarreira(String nivelCarreira) {
        this.nivelCarreira = nivelCarreira;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
