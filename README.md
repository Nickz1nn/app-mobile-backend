# 🎯 AppSport - Backend

Este é o backend da aplicação **AppSport**, um projeto desenvolvido para gerenciar eventos esportivos de forma prática e moderna! Aqui usamos **Java**, **Spring Boot** e **PostgreSQL** para construir uma API organizada, escalável e pronta para o futuro 🚀.

---

## 🔧 Tecnologias Utilizadas

<div align="left">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" alt="Java Badge"/>
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white" alt="Spring Boot Badge"/>
  <img src="https://img.shields.io/badge/PostgreSQL-336791?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL Badge"/>
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white" alt="Maven Badge"/>
</div>

---

## 📚 Sobre o Projeto

O **AppSport API** é responsável por:

* **🧑‍💻 Cadastro e autenticação de usuários**
* **🏃 Criação, listagem e gerenciamento de eventos esportivos**
* **⚽🏀🏈 Categorização de eventos por modalidades**
* **📊 Cadastro de performance de usuários em eventos**
* **🔔 Envio de notificações aos participantes**

---

### Estrutura (futuramente baseada na Clean Architecture):

```
appsport-api/
├── core/ (domínio e casos de uso)
├── application/ (serviços de aplicação)
├── infrastructure/ (repositórios, configs)
└── api/ (controllers e DTOs)
```

---

## 🏗️ Como Rodar o Projeto

### Pré-requisitos

* [Java 17](https://adoptium.net/)
* [Maven](https://maven.apache.org/)
* [PostgreSQL](https://www.postgresql.org/)

### Passo a Passo

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/appsport-api.git
cd appsport-api

# Configure o banco de dados PostgreSQL
# - Nome: qual_a_boa_df
# - Usuário: postgres
# - Senha: sua_senha

# Atualize o application.properties com suas configs de banco

# Rode a aplicação
./mvnw spring-boot:run
```

---

## 🗄️ Banco de Dados

O banco é criado manualmente no **pgAdmin4** usando o script SQL disponível na pasta `/db`.
Caso queira gerar dados automaticamente para teste, a aplicação conta com um `@PostConstruct` para inserção de dados iniciais.

---

## 📝 Documentação do Projeto

Para acompanhar o progresso do desenvolvimento, controle de tarefas e documentação detalhada do projeto, acesse o link do **Notion**:

🔗 [**TCC DOS CRIAS - Notion**](https://www.notion.so/TCC-DOS-CRIAS-8cec6677afe44832bfcea740d20a6a44?pvs=4)

---

## 🛠️ Funcionalidades futuras

* Integração com APIs externas de eventos
* Melhorias no sistema de notificações
* Implementação de autenticação JWT
* Dashboard administrativo

---

## 🤝 Contribuindo

Sinta-se à vontade para abrir issues, propor melhorias ou dar um ⭐ no repositório!

---

## 👨‍💻 Autor

* **Nicollas, Ian e Gustavo** — Desenvolvimento Backend
* Projeto orientado pela professora Karla Sardin.
