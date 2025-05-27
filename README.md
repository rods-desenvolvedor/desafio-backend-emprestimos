# API de Empréstimos
Minha implementação de uma API de emprestimos desenvolvida como parte de um desafio backend. 

Permite:

Cadastro de clientes.

Consulta de modalidades de empréstimos disponíveis.

Link do desafio : https://github.com/backend-br/desafios/blob/master/loans/PROBLEM.md

## Tecnologias

- Java 21

- Spring Boot 3

- Spring Data JPA

- PostgreSQL

- Flyway

- Docker

- OpenAPI Swagger (springdoc-openapi)

- JUnit + Mockito

## Executando o projeto

Subindo o banco com Docker

```bash
docker-compose up -d
```
Rodando o backend

```bash
./mvnw spring-boot:run
```

Ou, se estiver usando Maven instalado na máquina:

```bash
mvn spring-boot:run
```

## Acessando a documentação Swagger
```bash
http://localhost:8080/swagger-ui/index.html
Endpoints principais
Método	Endpoint	Descrição
POST	/api/clientes	Cadastrar cliente
GET	/api/clientes	Listar clientes
GET	/api/clientes/{id}	Buscar cliente por ID
PUT	/api/clientes/{id}	Atualizar cliente
DELETE	/api/clientes/{id}	Deletar cliente
GET	/api/clientes/{id}/emprestimos-disponiveis	Consultar empréstimos disponíveis
```


Documentação da API
A API segue os padrões OpenAPI e conta com interface Swagger disponível no endpoint /swagger-ui/index.html

Observações
O projeto utiliza Flyway para versionamento do banco de dados.

O container do banco de dados pode ser gerenciado pelo Docker utilizando o arquivo docker-compose.yml.

