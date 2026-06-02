# User Management API

API REST para gerenciamento e autenticação de usuários desenvolvida com Java e Spring Boot.

## 📖 Sobre o Projeto

Este projeto foi desenvolvido com o objetivo de praticar conceitos fundamentais do desenvolvimento backend utilizando Java e Spring Boot.

A aplicação permite realizar operações de cadastro, listagem, atualização, remoção e autenticação de usuários, aplicando conceitos importantes como DTOs, validação de dados e arquitetura em camadas.

## 💻 Tecnologias Utilizadas

- Java
- Spring Boot
- Maven
- Lombok
- Bean Validation (Jakarta Validation)
- Git
- GitHub

## 🚀 Funcionalidades

- Cadastro de usuários
- Listagem de usuários
- Atualização de usuários
- Remoção de usuários
- Login de usuários
- Validação de dados com Bean Validation
- Arquitetura em camadas (Controller, Service, DTO e Model)

## 📁 Estrutura do Projeto

```text
src
└── main
    └── java
        └── com.ryanteles.user_management_api
            ├── controller
            ├── dto
            ├── model
            └── service
```

## ⚙️ Como Executar o Projeto

### Pré-requisitos

- Java 21 ou superior
- Maven
- Git

A aplicação será iniciada em:

```text
http://localhost:8080
```

## 📍 Endpoints

### Criar usuário

```http
POST /usuarios
```

Exemplo de requisição:

```json
{
  "nome": "Ryan",
  "sobrenome": "Teles",
  "dataNascimento": "2004-11-21",
  "email": "ryan@email.com",
  "senha": "123456"
}
```

---

### Listar usuários

```http
GET /usuarios
```

---

### Atualizar usuário

```http
PUT /usuarios/{id}
```

---

### Remover usuário

```http
DELETE /usuarios/{id}
```

---

### Login

```http
POST /auth/login
```

Exemplo de requisição:

```json
{
  "email": "ryan@email.com",
  "senha": "123456"
}
```

Resposta:

```json
"Login realizado!"
```

## ✅ Validações Implementadas

- Nome obrigatório
- Sobrenome obrigatório
- Data de nascimento obrigatória
- Email válido
- Senha com no mínimo 6 caracteres

## 🎯 Conceitos Aplicados

- Programação Orientada a Objetos (POO)
- APIs REST
- DTO (Data Transfer Object)
- Injeção de Dependência
- Bean Validation
- Arquitetura em Camadas
- Versionamento com Git


## 👨‍💻 Autor

Ryan Teles
