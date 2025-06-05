# Gerenciador de Tarefas Pessoal

## Status do Projeto
[![Status: Em Desenvolvimento](https://img.shields.io/badge/Status-Em%20Desenvolvimento-blue.svg)]

Este projeto está atualmente em fase de desenvolvimento, com funcionalidades básicas de gerenciamento de tarefas já implementadas e em processo de refinamento.

## Tecnologias Aplicadas

O projeto foi desenvolvido utilizando as seguintes tecnologias, alinhadas com as abordagens do curso:

* **Backend:**
    * **Java 21:** Linguagem de programação principal.
    * **Spring Boot 3.5.0:** Framework para desenvolvimento rápido de aplicações web.
    * **Spring Data JPA:** Abstração para acesso a dados, facilitando a interação com o banco de dados.
    * **Lombok:** Biblioteca para reduzir o código boilerplate (getters, setters, construtores).
    * **H2 Database (modo em memória):** Banco de dados relacional em memória para desenvolvimento e testes. (Pode ser configurado para outros bancos como MySQL, PostgreSQL em ambiente de produção).
    * **JDBC Database:** Banco de dados relacional para base de dados.

* **Frontend:**
    * **HTML5:** Estrutura das páginas web.
    * **CSS3:** Estilização e layout.
    * **JavaScript:** Interatividade das páginas.
    * **Thymeleaf:** Motor de templates para integração entre o backend Java e o frontend HTML.
    * **Bootstrap 5:** Framework CSS para design responsivo e componentes de UI.
    * **Bootstrap Icons:** Biblioteca de ícones.

## Time de Desenvolvedores

* [Thiago dos Santos] - Desenvolvedor(a)

## Objetivo do Software

O **Gerenciador de Tarefas Pessoal** tem como objetivo principal auxiliar indivíduos na organização e acompanhamento de suas atividades diárias. Ele serve como uma ferramenta prática para registrar tarefas, definir prioridades, estipular prazos e marcar o status de conclusão, promovendo assim uma gestão mais eficiente do tempo e das responsabilidades pessoais ou profissionais.

## Funcionalidades do Sistema (Requisitos)

O sistema de gerenciamento de tarefas oferece as seguintes funcionalidades:

1.  **Gerenciamento de Usuários:**
    * **Cadastro de Novo Usuário:** Permite que novos usuários criem suas contas com nome, e-mail e senha.
    * **Login de Usuário:** Autenticação de usuários existentes através de e-mail e senha.
    * **Logout de Usuário:** Encerra a sessão do usuário logado.

2.  **Gerenciamento de Tarefas (Associadas ao Usuário Logado):**
    * **Criação de Tarefa:** Adicionar novas tarefas com título, descrição, prioridade (Alta, Média, Baixa) e data limite.
    * **Visualização de Tarefas:** Listar todas as tarefas cadastradas pelo usuário logado.
    * **Edição de Tarefa:** Atualizar os detalhes de uma tarefa existente.
    * **Exclusão de Tarefa:** Remover uma tarefa do sistema.
    * **Marcação de Conclusão:** Alternar o status de uma tarefa entre "concluída" e "pendente".
    * **Filtro de Tarefas:** Filtrar a lista de tarefas por status (todas, concluídas, pendentes).
    * **Busca de Tarefas:** Pesquisar tarefas por título ou descrição.