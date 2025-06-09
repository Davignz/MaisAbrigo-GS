# 📊 Projeto FIAP - MaisAbrigo-GS - Java Advanced + DevOps Tools & Cloud Computing

## Objetivo

Este projeto integra as disciplinas **Java Advanced** e **DevOps Tools & Cloud Computing** da FIAP, promovendo tecnologia e inovação para mitigar impactos de eventos extremos, entregando uma solução de API REST com containerização, persistência real em banco de dados e boas práticas arquiteturais.

---

## Funcionalidades e Requisitos Atendidos

### Java Advanced

- API REST seguindo boas práticas de arquitetura (Spring Boot)
- Persistência em Banco de Dados Relacional Oracle XE utilizando Spring Data JPA
- Mapeamento de relacionamento entre entidades (1:N, N:N, etc)
- Validação com Bean Validation
- Paginação, ordenação e filtros nos endpoints
- Documentação automática da API (Swagger/OpenAPI)
- Autenticação JWT (JSON Web Token)

### DevOps Tools & Cloud Computing

- Containerização dos serviços:
    - **Aplicação Java** (imagem customizada com usuário não-root, workdir, variáveis de ambiente e porta exposta)
    - **Banco Oracle XE** (imagem oficial, volume nomeado, porta/variáveis expostas)
- Execução dos containers em modo background (`-d`)
- Evidências apresentadas via terminal (sem interface gráfica Docker)
- Scripts para teste dos endpoints da API
- Persistência efetiva e volume Docker

---

## Como Executar

### Pré-requisitos

- Docker
- Java 21 / Maven (opcional para build local)
- Git

# Requisições utilizadas no vídeo de Devops:
Coleção de Requisições Postman: https://davi-19954.postman.co/workspace/Davi's-Workspace~ad6a48de-c7cb-4b37-8739-4151b5eda126/collection/45299053-58cc5995-1059-4860-b290-4c910669a0a5?action=share&creator=45299053
