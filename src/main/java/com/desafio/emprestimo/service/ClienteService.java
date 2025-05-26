package com.desafio.emprestimo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.desafio.emprestimo.controller.dtos.ClienteRequestDto;
import com.desafio.emprestimo.controller.dtos.ClienteResponseDto;
import com.desafio.emprestimo.controller.dtos.EmprestimosResponseDto;
import com.desafio.emprestimo.entity.Cliente;
import com.desafio.emprestimo.entity.Emprestimo;
import com.desafio.emprestimo.entity.enums.TipoEmprestimo;
import com.desafio.emprestimo.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository)
    {
        this.clienteRepository = clienteRepository;
    }

    public ClienteResponseDto cadastrarCliente(ClienteRequestDto clienteRequestDto)
    {
        Cliente cliente = new Cliente(
            clienteRequestDto.nome(),
            clienteRequestDto.idade(),
            clienteRequestDto.cpf(),
            clienteRequestDto.renda(),
            clienteRequestDto.estado());

        Cliente clienteSalvo = clienteRepository.save(cliente);

        return new ClienteResponseDto(clienteSalvo);
    }

    public EmprestimosResponseDto verificarEmprestimosDisponiveis(UUID idCliente)
    {
        Cliente cliente = clienteRepository.findById(idCliente)
        .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        List<Emprestimo> emprestimos = new ArrayList<>();

        if(cliente.getRenda().compareTo(new BigDecimal("3000.0")) <= 0)
        {
            emprestimos.add(new Emprestimo(TipoEmprestimo.PESSOAL));
            emprestimos.add(new Emprestimo(TipoEmprestimo.GARANTIA));
        }

        if(cliente.getRenda().compareTo(new BigDecimal("5000.0")) >= 0)
        {
            emprestimos.add(new Emprestimo(TipoEmprestimo.CONSIGNADO));
        }

        if(cliente.getRenda().compareTo(new BigDecimal("3000.0")) > 0
         && cliente.getRenda().compareTo(new BigDecimal("5000.0")) < 0
         && cliente.getEstado().equalsIgnoreCase("SP")
         && cliente.getIdade() < 30)
        {
            emprestimos.add(new Emprestimo(TipoEmprestimo.PESSOAL));
            emprestimos.add(new Emprestimo(TipoEmprestimo.GARANTIA));
        }

        return new EmprestimosResponseDto(cliente.getNome(), emprestimos);
    }
}
