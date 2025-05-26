package com.desafio.emprestimo.entity;

import java.math.BigDecimal;
import com.desafio.emprestimo.entity.enums.TipoEmprestimo;

public class Emprestimo {

    public Emprestimo() {}

    public Emprestimo(TipoEmprestimo tipoEmprestimo)
    {
        this.tipoEmprestimo = tipoEmprestimo;
        this.taxa = tipoEmprestimo.getTaxa();
    }

    private TipoEmprestimo tipoEmprestimo;
   
    private BigDecimal taxa;

    public TipoEmprestimo getTipoEmprestimo() {
        return tipoEmprestimo;
    }

    public void setTipoEmprestimo(TipoEmprestimo tipoEmprestimo) {
        this.tipoEmprestimo = tipoEmprestimo;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    

    
}
