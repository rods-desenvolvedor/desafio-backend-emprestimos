package com.desafio.emprestimo.controller.dtos;

import java.math.BigDecimal;

public record ClienteRequestDto(
    String nome,
    int idade,
    String cpf,
    BigDecimal renda,
    String estado
    ) {
    
}
