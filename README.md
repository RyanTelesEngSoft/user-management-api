# User Management API

API REST para gerenciamento de usuários, desenvolvida com Java e Spring Boot. O projeto implementa cadastro, autenticação com JWT, controle de acesso baseado em papéis (Roles) e persistência de dados com MySQL.

A aplicação é executada em containers Docker, utilizando Docker Compose para orquestrar a API e o banco de dados.

## Tecnologias utilizadas

- **Java 21**
- **Spring Boot 3.5**
- **Spring Security**
- **Spring Data JPA**
- **Hibernate**
- **MySQL 8**
- **JWT (JSON Web Token)**
- **BCrypt**
- **Maven**
- **Docker**
- **Docker Compose**
- **Lombok**
- **Bean Validation**

## Funcionalidades

- Cadastro de usuários.
- Consulta de usuários.
- Autenticação utilizando e-mail e senha.
- Geração e validação de tokens JWT.
- Criptografia de senhas utilizando BCrypt.
- Controle de acesso baseado em roles.
- Validação de dados com Bean Validation.
- Tratamento global de exceções.
- Persistência de dados utilizando MySQL e JPA/Hibernate.
- Containerização da aplicação e do banco de dados.

## Controle de acesso

A aplicação possui dois níveis de autorização:

| Role | Permissões |
|---|---|
| BASIC | Cadastro e autenticação |
| ADMIN | Acesso aos endpoints protegidos |

Novos usuários recebem automaticamente a role `BASIC`.

A criação do primeiro usuário administrador é realizada manualmente no banco de dados.

## Arquitetura

A aplicação utiliza Docker Compose para executar a API e o MySQL em containers separados, conectados pela rede interna do Docker.

- API: porta `8080`.
- MySQL: porta interna `3306`, publicada na porta `3307` do host.

A API acessa o banco de dados pelo nome do serviço Docker (`mysql`).

## Como executar o projeto

### Pré-requisitos

- Docker
- Docker Compose

### 1. Clone o repositório

```bash
git clone https://github.com/RyanTelesEngSoft/user-management-api.git
```

Entre na pasta:

```bash
cd user-management-api
```

### 2. Configure as variáveis de ambiente

Crie um arquivo `.env` na raiz do projeto:

```env
MYSQL_ROOT_PASSWORD=sua_senha
JWT_EXPIRATION=86400000
JWT_KEY=sua_chave_secreta
```

Substitua os valores pelos seus próprios dados.

**Importante:** nunca compartilhe ou envie o arquivo `.env` para o GitHub.

### 3. Execute a aplicação

Na raiz do projeto, execute:

```bash
docker compose up -d --build
```

O Docker irá construir a imagem da API, iniciar o MySQL e executar a aplicação após o banco de dados ficar saudável.

### 4. Verifique os containers

```bash
docker compose ps
```

Para visualizar os logs da API:

```bash
docker compose logs -f api
```

A API estará disponível em:

```text
http://localhost:8080
```

## Endpoints principais

| Método | Endpoint | Descrição | Acesso |
|---|---|---|---|
| POST | `/usuarios` | Cadastro de usuário | Público |
| POST | `/auth/login` | Autenticação | Público |
| GET | `/usuarios` | Consulta de usuários | ADMIN |

Os demais endpoints protegidos seguem as regras de autorização definidas na configuração de segurança.

## Autenticação

Para realizar o login, envie uma requisição POST para:

```text
/auth/login
```

Exemplo de corpo da requisição:

```json
{
  "email": "usuario@email.com",
  "senha": "sua_senha"
}
```

Após a autenticação, a API retorna um token JWT.

Para acessar endpoints protegidos, envie o token no cabeçalho da requisição:

```text
Authorization: Bearer SEU_TOKEN
```

## Tratamento de exceções

A aplicação possui tratamento centralizado de exceções utilizando `@RestControllerAdvice`.

Principais respostas HTTP:

| Código | Descrição |
|---|---|
| 200 | Requisição realizada com sucesso |
| 201 | Recurso criado |
| 400 | Dados inválidos ou requisição incorreta |
| 401 | Não autenticado |
| 403 | Acesso não autorizado |
| 404 | Recurso não encontrado |
| 500 | Erro interno do servidor |

## Encerrando a aplicação

Para parar e remover os containers:

```bash
docker compose down
```

O volume do MySQL é preservado, mantendo os dados armazenados.

**Atenção:** evite utilizar `docker compose down -v` caso queira preservar os dados do banco.

## Autor

**Ryan Teles**

Estudante de Engenharia de Software, com foco em desenvolvimento Backend utilizando Java e Spring Boot.

- GitHub: [RyanTelesEngSoft](https://github.com/RyanTelesEngSoft)

---

Projeto desenvolvido com o objetivo de praticar e aprofundar conhecimentos em desenvolvimento de APIs REST, persistência de dados, autenticação, autorização e containerização com Docker.