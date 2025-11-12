# FuturaSkill 2030 – Plataforma de Upskilling e Reskilling
# João Victor Soares Rodrigues
# RM551410

## Resumo

Este projeto consiste no desenvolvimento de uma API RESTful, denominada **FuturaSkill 2030**, que simula uma plataforma de capacitação profissional git lohggoyfocada em *upskilling* e *reskilling*. A aplicação foi concebida no contexto da disciplina de Global Solution da FIAP, visando abordar as transformações no mercado de trabalho e a necessidade de aprendizado contínuo. A plataforma permite o gerenciamento de usuários e trilhas de conhecimento, fornecendo uma base para sistemas de gestão de talentos e desenvolvimento de competências.

## Introdução

O cenário contemporâneo do trabalho é marcado por rápidas transformações tecnológicas e mercadológicas, exigindo que os profissionais se adaptem por meio do desenvolvimento contínuo de novas competências (*reskilling*) e do aprofundamento das habilidades existentes (*upskilling*). O presente projeto propõe uma solução tecnológica para apoiar essa dinâmica, materializada em uma plataforma de gestão de aprendizado. A FuturaSkill 2030 serve como um protótipo para sistemas que visam facilitar a jornada de capacitação dos colaboradores em um ambiente corporativo.

## Arquitetura e Modelagem

A arquitetura da aplicação segue o padrão em camadas (*Layered Architecture*), promovendo a separação de responsabilidades e a manutenibilidade do código. As camadas são divididas em:

- `controller`: Responsável pela exposição dos endpoints da API REST e pelo tratamento das requisições HTTP.
- `service`: Contém a lógica de negócio e as regras da aplicação.
- `repository`: Define as interfaces para a persistência e consulta de dados, abstraindo o acesso ao banco de dados.
- `entities`: Representa as entidades do domínio (e.g., `Usuario`, `Trilha`) e seu mapeamento objeto-relacional (ORM).
- `dto`: Objetos de Transferência de Dados (*Data Transfer Objects*) para a comunicação segura e eficiente entre as camadas.
- `exception`: Centraliza o tratamento de exceções personalizadas, garantindo respostas de erro consistentes.

## Tecnologias Utilizadas

- **Java 17**: Versão da linguagem de programação base do projeto.
- **Spring Boot 3**: Framework para o desenvolvimento de aplicações Java, com foco em simplicidade e produtividade.
- **Spring Web**: Módulo para a construção de aplicações web e APIs RESTful.
- **Spring Data JPA**: Facilita a implementação da camada de persistência de dados com base na Java Persistence API (JPA).
- **H2 Database**: Banco de dados relacional em memória, ideal para ambientes de desenvolvimento e teste.
- **Flyway**: Ferramenta para versionamento e migração de schema de banco de dados (*Database Migration*).
- **Bean Validation**: Implementa a especificação JSR 380 para validação de dados em objetos.

## Documentação da API

A API expõe recursos para o gerenciamento de usuários e trilhas de aprendizado.

### Recurso: Usuários (`/api/usuarios`)

- `GET /`: Retorna uma lista de todos os usuários cadastrados.
- `GET /{id}`: Busca um usuário específico pelo seu identificador único.
- `POST /`: Cria um novo registro de usuário.
- `PUT /{id}`: Atualiza os dados de um usuário existente.
- `DELETE /{id}`: Remove um usuário do sistema.

### Recurso: Trilhas (`/api/trilhas`)

- `GET /`: Retorna uma lista de todas as trilhas de aprendizado.
- `GET /{id}`: Busca uma trilha específica pelo seu identificador.
- `POST /`: Cria uma nova trilha de aprendizado.
- `PUT /{id}`: Atualiza os dados de uma trilha existente.
- `DELETE /{id}`: Remove uma trilha do sistema.

## Instalação e Execução

**Pré-requisitos:**
- JDK 17 ou superior.
- Apache Maven 3.8 ou superior.

**Passos para execução:**
1. Clone o repositório:
   ```sh
   git clone <URL_DO_REPOSITORIO>
   ```
2. Navegue até o diretório raiz do projeto.
3. Execute a aplicação utilizando o Maven Wrapper:
   ```sh
   ./mvnw spring-boot:run
   ```
A API estará acessível em `http://localhost:8080`.