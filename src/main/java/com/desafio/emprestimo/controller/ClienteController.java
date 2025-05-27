package com.desafio.emprestimo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.emprestimo.controller.dtos.ClienteRequestDto;
import com.desafio.emprestimo.controller.dtos.ClienteResponseDto;
import com.desafio.emprestimo.controller.dtos.EmprestimosResponseDto;
import com.desafio.emprestimo.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {


    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService)
    {
        this.clienteService = clienteService;
    }

    @Operation(summary = "Cadastrar novo cliente",
     description = "Faz o cadastro de um novo cliente no sistema")
    @PostMapping("/cadastrar")
    public ClienteResponseDto cadastrarCliente(@RequestBody ClienteRequestDto clienteRequestDto)
    {
        return clienteService.cadastrarCliente(clienteRequestDto);
    }


    @Operation(summary = "Listar os clientes",
    description = "Retorna todos os clientes salvos no sistema")
    @GetMapping("/listar")
    public List<ClienteResponseDto> listarClientes()
    {
        return clienteService.listarClientes();
    }


    @Operation(summary = "Apagar um cliente", 
    description = "Apaga um cliente a partir do ID(UUID) do mesmo")
    @DeleteMapping("/{idCliente}/apagar")
    public void apagarCliente(@PathVariable UUID idCliente)
    {
        clienteService.apagarCliente(idCliente);
    }

    @Operation(summary = "Atualizar um cliente",
    description = "Atualiza os dados de um cliente a partir do ID(UUID) - É necessário passar TODOS os dados")
    @PutMapping("/{idCliente}/atualizar")
    public ClienteResponseDto atualizarCliente(@PathVariable UUID idCliente,@RequestBody ClienteRequestDto clienteRequestDto)
    {
        return clienteService.atualizarCliente(idCliente, clienteRequestDto);
    }


    @Operation(summary = "Verificar os emprestimos disponiveis",
    description = "Serviço principal - Retorna os emprestimos disponiveis de um cliente a partir das suas informações de renda e UF")
    @PostMapping("/{idCliente}/verificar-emprestimos")
    public EmprestimosResponseDto verificarEmprestimosDisponiveis(@PathVariable UUID idCliente)
    {
        return clienteService.verificarEmprestimosDisponiveis(idCliente);
    }
    
}
