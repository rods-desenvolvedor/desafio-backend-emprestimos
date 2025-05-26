package com.desafio.emprestimo.controller.dtos;

import com.desafio.emprestimo.entity.Cliente;

public record ClienteResponseDto(String nome, int idade, String estado) {

    public ClienteResponseDto(Cliente cliente)
    {
        this(cliente.getNome(), cliente.getIdade(), cliente.getEstado());
    }
    
}
