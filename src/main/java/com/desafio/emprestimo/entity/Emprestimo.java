package com.desafio.emprestimo.entity;

import java.util.UUID;

import com.desafio.emprestimo.entity.enums.TipoEmprestimo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emprestimos")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private TipoEmprestimo tipoEmprestimo;
   
    private int taxaInteresse;

    
}
