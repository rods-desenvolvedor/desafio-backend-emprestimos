package com.desafio.emprestimo.controller.dtos;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ClienteRequestDto(

    @Schema(description = "Nome do cliente", example = "Pedro")
    @NotBlank(message = "Nome do cliente é obrigatório")
    String nome,

    @Schema(description = "Idade do cliente", example = "25")
    @Min(value = 18, message = "Idade mínima é 18 anos")
    int idade,

    @Schema(description = "CPF do cliente", example = "12345678900")
    @Pattern(regexp = "\\d{11}", message = "CPF deve ter 11 digitos numéricos")
    String cpf,

    @Schema(description = "Renda mensal do cliente", example = "3500.0")
    @Positive(message = "Renda deve ser maior que zero")
    BigDecimal renda,

    @Schema(description = "Estado do cliente (UF - usar apenas a sigla)", example = "SP")
    @Size(min = 2, max = 2, message = "Estado deve ser abreviado - UF")
    String estado
    ) {
    
}
