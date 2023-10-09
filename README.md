# projeto-spring-boot-postegres

# Desafio Spring Boot: Gerenciamento de Pessoas e Tarefas

Este projeto é uma API REST construída com Spring Boot que permite o gerenciamento de pessoas e suas tarefas em um contexto de departamentos.

## Funcionalidades

- Adicionar uma pessoa
- Alterar informações de uma pessoa
- Remover uma pessoa
- Adicionar uma tarefa
- Listar todas as tarefas
- Alocar uma pessoa a uma tarefa (desde que pertençam ao mesmo departamento)

## Tecnologias Utilizadas

- Java
- Spring Boot
- Banco de Dados PostgreSQL
- Gradle

## Endpoints

- **GET /pessoas**: Retorna a lista de todas as pessoas cadastradas.
- **GET /pessoas/{id}**: Retorna os detalhes de uma pessoa específica.
- **POST /pessoas**: Adiciona uma nova pessoa.
- **PUT /pessoas/{id}**: Atualiza as informações de uma pessoa existente.
- **DELETE /pessoas/{id}**: Remove uma pessoa do sistema.
- **POST /tarefas**: Adiciona uma nova tarefa.

## Modelo de Dados

### Pessoa
- ID
- Nome
- Departamento
- Lista de Tarefas

### Tarefa
- ID
- Título
- Descrição
- Prazo
- Departamento
- Duração
- Pessoa Alocada
- Finalizado

## Como Executar o Projeto

1. Clone este repositório: `git clone https://github.com/seu-usuario/desafio-spring-boot.git`
2. Configure o banco de dados PostgreSQL no arquivo `application.properties`.
3. Execute o projeto com o Gradle: `./gradlew bootRun`
4. Acesse a API em `http://localhost:8080`.
