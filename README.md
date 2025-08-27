# Sistema Biblioteca

Este é um sistema de gerenciamento de biblioteca desenvolvido com Spring Boot, que permite o controle de livros, usuários e empréstimos.

## Pré-requisitos

- Java 21 ou superior
- Maven

## Como executar

1. Clone o repositório:
```bash
git clone https://github.com/joao-ac/sistemabiblioteca.git
```

2. Entre na pasta do projeto:
```bash
cd sistemabiblioteca
```

3. Execute o projeto com Maven:
```bash
mvn spring-boot:run
```

O sistema estará disponível em `http://localhost:8080`

## Funcionalidades

- Cadastro e gerenciamento de livros
- Cadastro e gerenciamento de usuários
- Controle de empréstimos
- Interface web para visualização do banco de dados

## Documentação da API

A documentação da API está disponível através do Swagger UI em:
`http://localhost:8080/swagger-ui.html`

## Padrões de Projeto Utilizados

1. **Builder Pattern**
   - Implementado na classe `Livro` para construção de objetos de forma mais flexível e legível

2. **Strategy Pattern**
   - Utilizado no pacote `service.strategy` para diferentes estratégias de negócio

3. **Repository Pattern**
   - Implementado através das interfaces `LivroRepositorio`, `UsuarioRepositorio` e `EmprestimoRepositorio` para abstração da camada de persistência

4. **DTO Pattern**
   - Utilizado através da classe `LivroDTO` para transferência de dados entre camadas

5. **MVC Pattern**
   - Estrutura do projeto segue o padrão Model-View-Controller com:
     - Models: `Livro`, `Usuario`, `Emprestimo`
     - Views: Templates em `resources/templates`
     - Controllers: `LivroControlador`, `WebController`
