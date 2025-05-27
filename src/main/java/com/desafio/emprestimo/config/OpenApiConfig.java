package com.desafio.emprestimo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI customOpenAPI()
    {
        return new OpenAPI()
        .info(new Info()
            .title("API de emprestimos - desafio backend")
            .version("1.0")
            .description("Minha implementação de um desafio backend. Oferece funcionalidades para controle de clientes e verificação de disponibilidade de emprestimos para o mesmo")
            .contact(new Contact().name("Rodolfo Pantoja").url("https://www.linkedin.com/in/rods-desenvolvedor/"))
            );   
    }
}
