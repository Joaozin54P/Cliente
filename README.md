# 👤 API de Clientes - Spring Boot + MongoDB

Este projeto consiste no desenvolvimento de uma API REST para gerenciamento de clientes, utilizando **Spring Boot** e **MongoDB**.

A aplicação permite realizar operações completas de CRUD (Create, Read, Update e Delete), além de estruturar os dados com endereço vinculado ao cliente.

---

## 🎯 Objetivo

Desenvolver uma API para cadastro e gerenciamento de clientes, aplicando conceitos de:

* Arquitetura em camadas (Controller, Service, Repository, Model)
* Integração com banco de dados NoSQL (MongoDB)
* Construção de endpoints RESTful
* Uso de DTOs para entrada e saída de dados

---

## 🛠 Tecnologias Utilizadas

* Java 17+
* Spring Boot
* Spring Web
* Spring Data MongoDB
* MongoDB
* Postman

---

## 📁 Estrutura do Projeto

```bash

src/main/java/com/github/Cliente
│
├── controller     # Recebe as requisições HTTP
├── service        # Contém as regras de negócio
├── repository     # Comunicação com o banco de dados
├── model          # Estrutura dos dados (Cliente, Endereco)
├── dto            # Objetos de entrada e saída (Request/Response)
└── CrudJoaoApplication.java  # Classe principal
```
---

## ⚙️ Funcionalidades

✔️ Cadastro de cliente
✔️ Listagem de clientes
✔️ Busca por ID
✔️ Atualização de dados
✔️ Remoção de cliente
✔️ Associação de endereço ao cliente

---

## 🌐 Endpoints da API

### 📌 Criar Cliente

POST /cliente

json
{
  "nome": "João Pedro",
  "dtNascimento": "2005-04-10",
  "logradouro": "Rua Exemplo",
  "numero": "123",
  "cidade": "São Paulo",
  "estado": "SP"
}


---

### 📋 Listar Clientes

<img width="1078" height="506" alt="image" src="https://github.com/user-attachments/assets/757e67fd-fc65-4e3a-9c6b-fd77e7e499ec" />


---

### 🔄 Atualizar Cliente

<img width="1086" height="519" alt="image" src="https://github.com/user-attachments/assets/a8e63ed2-315c-4e22-b004-4b0156e57159" />


---

### ❌ Deletar Cliente

<img width="1090" height="403" alt="image" src="https://github.com/user-attachments/assets/84456857-6781-4b46-a3b4-1fb545a78e35" />


---

### ➕ Cadastro de Cliente

<img width="1085" height="511" alt="image" src="https://github.com/user-attachments/assets/002064fe-a2fd-444e-9940-ae83ef3b44b8" />


---

## 📌 Observações

* O projeto utiliza MongoDB como banco NoSQL
* O ID dos clientes é gerado automaticamente
* O endereço é armazenado como objeto dentro do cliente
* A API segue padrão REST

---

## 👨‍💻 Desenvolvedores

Projeto desenvolvido por:

* João Pedro da Silva Machado Felix
* Giovanna Aparecida Vivencio Rodrigues

---

## 🎓 Contexto Acadêmico

Este projeto foi desenvolvido como atividade avaliativa, contemplando a construção de uma arquitetura baseada em microsserviços, dividida em diferentes módulos:

* 👤 Cliente → gerenciamento de clientes
* 🔐 Login → autenticação de usuários (JWT)
* 📦 Produto → gerenciamento de produtos e lista de compras
* 🌐 Gateway → centralização das requisições

---

## 🏗 Arquitetura do Projeto

A aplicação segue o padrão de microsserviços, onde cada módulo possui sua responsabilidade específica, promovendo:

* Separação de responsabilidades
* Organização do código
* Facilidade de manutenção
* Integração entre serviços

O API Gateway atua como ponto de entrada único, direcionando as requisições para os serviços correspondentes.

---

## 🚀 Considerações Finais

Este projeto teve como objetivo aplicar, na prática, conceitos de desenvolvimento backend com Spring Boot, além de explorar a construção de APIs REST e organização em microsserviços.
A implementação permitiu consolidar conhecimentos sobre integração com banco de dados, estruturação de código e boas práticas no desenvolvimento de sistemas distribuídos.
