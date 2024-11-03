# Nome do Projeto

Uma API RESTful desenvolvida em Java com Spring Boot para gerenciar dados de usuários, posts e comentários

## Índice

1. [Sobre o Projeto](#sobre-o-projeto)
2. [Tecnologias Utilizadas](#tecnologias-utilizadas)
3. [Funcionalidades](#funcionalidades)
4. [Como Usar](#como-usar)
6. [Endpoints da API](#endpoints-da-api)

## Sobre o Projeto

Este projeto é uma API para gerenciamento de uma rede social. Ele permite a criação, atualização, busca e exclusão de registros de dados, com foco na eficiência e segurança dos dados.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- MongoDB
- Postman (para testes)

## Funcionalidades

- CRUD para Users e Posts:
  Busca por id
  Buscar todos
  Deletar por id
  Atualizar
  Inserir dados
- Incluindo busca por título para Posts

## Como Usar

1. Clone o repositório.
   ```bash
   git clone https://github.com/seu-usuario/nome-do-repositorio.git

## Endpoint da API

---

## Users

### 1. Obter todos os usuários
- **Método:** `GET`
- **Endpoint:** `/users`
- **Descrição:** Retorna uma lista de todos os usuários.

### 2. Obter usuário por ID
- **Método:** `GET`
- **Endpoint:** `/users/{id}`
- **Descrição:** Retorna os detalhes de um usuário específico identificado pelo seu ID.

### 3. Criar um novo usuário
- **Método:** `POST`
- **Endpoint:** `/users`
- **Descrição:** Insere um novo usuário no sistema. O corpo da requisição deve conter os dados do usuário.

### 4. Deletar um usuário
- **Método:** `DELETE`
- **Endpoint:** `/users/{id}`
- **Descrição:** Remove um usuário do sistema identificado pelo seu ID.

### 5. Atualizar um usuário
- **Método:** `PUT`
- **Endpoint:** `/users/{id}`
- **Descrição:** Atualiza os dados de um usuário existente identificado pelo seu ID. O corpo da requisição deve conter os dados atualizados do usuário.

### 6. Obter posts de um usuário
- **Método:** `GET`
- **Endpoint:** `/users/{id}/posts`
- **Descrição:** Retorna uma lista de todos os posts de um usuário específico identificado pelo seu ID.

## Posts

### 1. Obter todos os posts
- **Método:** `GET`
- **Endpoint:** `/posts`
- **Descrição:** Retorna uma lista de todos os posts.

### 2. Obter post por ID
- **Método:** `GET`
- **Endpoint:** `/posts/{id}`
- **Descrição:** Retorna os detalhes de um post específico identificado pelo seu ID.

### 3. Criar um novo post
- **Método:** `POST`
- **Endpoint:** `/posts`
- **Descrição:** Insere um novo post no sistema. O corpo da requisição deve conter os dados do post.

### 4. Deletar um post
- **Método:** `DELETE`
- **Endpoint:** `/posts/{id}`
- **Descrição:** Remove um post do sistema identificado pelo seu ID.

### 5. Atualizar um post
- **Método:** `PUT`
- **Endpoint:** `/posts/{id}`
- **Descrição:** Atualiza os dados de um post existente identificado pelo seu ID. O corpo da requisição deve conter os dados atualizados do post.

### 6. Buscar posts pelo título
- **Método:** `GET`
- **Endpoint:** `/posts/titlesearch`
- **Parâmetros:**
  - `text`: texto para buscar nos títulos dos posts.
- **Descrição:** Retorna uma lista de posts cujo título contém o texto especificado.

### 7. Busca completa de posts
- **Método:** `GET`
- **Endpoint:** `/posts/fullsearch`
- **Parâmetros:**
  - `text`: texto para buscar nos posts.
  - `minDate`: data mínima para a busca (formato: `yyyy-MM-dd`).
  - `maxDate`: data máxima para a busca (formato: `yyyy-MM-dd`).
- **Descrição:** Retorna uma lista de posts que correspondem ao texto de busca e estão dentro do intervalo de datas especificado.

---

## Observações
- Todos os endpoints que aceitam um corpo de requisição devem ser chamados com o tipo de conteúdo `application/json`.
- Os IDs de usuários e posts devem ser fornecidos como strings.
