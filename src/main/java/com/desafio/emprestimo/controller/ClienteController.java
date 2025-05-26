package com.desafio.emprestimo.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.emprestimo.controller.dtos.ClienteRequestDto;
import com.desafio.emprestimo.controller.dtos.ClienteResponseDto;
import com.desafio.emprestimo.controller.dtos.EmprestimosResponseDto;
import com.desafio.emprestimo.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {


    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService)
    {
        this.clienteService = clienteService;
    }

    @PostMapping("/cadastrar")
    public ClienteResponseDto cadastrarCliente(@RequestBody ClienteRequestDto clienteRequestDto)
    {
        return clienteService.cadastrarCliente(clienteRequestDto);
    }

    @PostMapping("/{idCliente}/verificar-emprestimos")
    public EmprestimosResponseDto verificarEmprestimosDisponiveis(@PathVariable UUID idCliente)
    {
        return clienteService.verificarEmprestimosDisponiveis(idCliente);
    }
    
}
