package com.desafio.emprestimo.controller.dtos;

import java.util.List;

import com.desafio.emprestimo.entity.Emprestimo;

public record EmprestimosResponseDto(String nomeCliente, List<Emprestimo> emprestimos) {
    
}
