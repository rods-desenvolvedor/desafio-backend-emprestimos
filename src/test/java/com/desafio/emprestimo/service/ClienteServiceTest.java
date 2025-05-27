package com.desafio.emprestimo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;

import com.desafio.emprestimo.controller.dtos.ClienteRequestDto;
import com.desafio.emprestimo.controller.dtos.ClienteResponseDto;
import com.desafio.emprestimo.entity.Cliente;
import com.desafio.emprestimo.repository.ClienteRepository;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    void deveCadastrarClienteComSucesso()
    {
        UUID id = UUID.randomUUID();

        ClienteRequestDto clienteRequestDto = new ClienteRequestDto(
            "Rods", 25, "12345678900", new BigDecimal("7000.0"), "SP"
        );

        Cliente clienteSalvo = new Cliente(
            id, "Rods", 25, "12345678900", new BigDecimal("7000.0"), "SP"
        );

        when(clienteRepository.save(any(Cliente.class))).thenReturn(clienteSalvo);

        ClienteResponseDto clienteResponseDto = clienteService.cadastrarCliente(clienteRequestDto);

        assertEquals("Rods", clienteResponseDto.nome());
        assertEquals(25, clienteResponseDto.idade());
        assertEquals("SP", clienteResponseDto.estado());

        verify(clienteRepository, times(1)).save(any(Cliente.class));

    }

    void deveRetornarTodosOsClientesComSucesso()
    {
        Cliente cliente1 = new Cliente(
            UUID.randomUUID(), "Cliente1", 20, "12345678900",
            new BigDecimal("3500.0"), "SP"
        );

        Cliente cliente2 = new Cliente(
            UUID.randomUUID(), "Cliente2", 22, "12345678901",
            new BigDecimal("3500.0"), "SP"
        );

        List<Cliente> listaClientes = List.of(cliente1, cliente2);
    }


    
}
