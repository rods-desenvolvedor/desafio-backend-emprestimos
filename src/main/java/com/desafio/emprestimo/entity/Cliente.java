package com.desafio.emprestimo.entity;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

    public Cliente() {}

    public Cliente(UUID id, String nome, int idade, String cpf, BigDecimal renda, String estado) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.renda = renda;
        this.estado = estado;
    }

    public Cliente(String nome, int idade, String cpf, BigDecimal renda, String estado) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.renda = renda;
        this.estado = estado;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;
    private int idade;
    private String cpf;
    private BigDecimal renda;
    private String estado;


    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public BigDecimal getRenda() {
        return renda;
    }
    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
}
