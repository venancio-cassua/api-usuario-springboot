# API Usuário - Spring Boot

## 📌 Sobre o projeto

Este projeto tem como objetivo praticar e demonstrar o desenvolvimento de uma API REST utilizando Spring Boot, aplicando arquitetura em camadas e boas práticas de organização de código.

O projeto está em desenvolvimento contínuo e será evoluído gradualmente com novas funcionalidades, melhorias estruturais e boas práticas de mercado.

---

## Objetivo técnico

- Aplicar arquitetura em camadas (Controller, Service, Repository)
- Utilizar DTO para transferência de dados
- Implementar CRUD completo
- Trabalhar com persistência de dados utilizando JPA
- Evoluir progressivamente com melhorias estruturais

---

## Tecnologias utilizadas até o momento

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Bean Validation
- Maven
- MariaDB

Novas tecnologias poderão ser adicionadas conforme a evolução do projeto.

---

## Estrutura atual do projeto

O projeto segue o padrão de arquitetura em camadas:

- model → Entidades da aplicação
- dto → Objetos de transferência de dados
- repository → Comunicação com banco de dados
- service → Regras de negócio
- controller → Endpoints REST

---

## ⚙️ Como executar o projeto

### Pré-requisitos

- Java 17 instalado
- MariaDB instalado e em execução
- IDE compatível com Java 17 (Eclipse, IntelliJ, VS Code, etc.)

---

### Configuração do banco de dados

Este projeto utiliza MariaDB.

É necessário:

1. Criar um banco de dados manualmente.
2. Ajustar as credenciais no arquivo:
