package com.desafio.emprestimo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.emprestimo.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
    
}
