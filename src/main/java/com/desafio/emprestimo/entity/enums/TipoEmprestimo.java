package com.desafio.emprestimo.entity.enums;

import java.math.BigDecimal;

public enum TipoEmprestimo {
    PESSOAL(new BigDecimal("4.0")),
    CONSIGNADO(new BigDecimal("2.0")),
    GARANTIA(new BigDecimal("3.0"));

    private final BigDecimal taxa;

    TipoEmprestimo(BigDecimal taxa)
    {
        this.taxa = taxa;
    }

    public BigDecimal getTaxa()
    {
        return this.taxa;
    }
}
