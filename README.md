# <p>Trabalho-OO-FGA0158</p>
UnB - Universidade de Brasilia<br>
FCTE - Faculdade de Ciências e Tecnologias em Engenharia<br>
OO - Orientação por Objetos<br>
Prof. André Luiz Peron Martins Lanna

## :octocat: Integrantes do Projeto

| [![Isadora Quaresma Oliveira](https://avatars.githubusercontent.com/u/182124838?v=4)]([https://github.com/Potatoyz908]([https://github.com/PedroRSR](https://github.com/isadoraqo))) | [![Pedro Ramos Sousa Reis](https://avatars.githubusercontent.com/u/127259012?v=4)]([https://github.com/Potatoyz908](https://github.com/PedroRSR)) | 
|-------------------------------------------------------------|-----------------------------------------------------------|
| Isadora Quaresma Oliveira | Pedro Ramos Sousa Reis |
222025155 | 222031680 |

## Resumo do Projeto

### Objetivo

Desenvolver um sistema de reserva de espaços físicos para a Universidade de Brasília (UnB). A aplicação, desenvolvida em Java, permite o gerenciamento de agendamentos de salas, laboratórios e auditórios por diferentes perfis da comunidade acadêmica (alunos, professores e servidores). A interação com o usuário é realizada através de uma interface gráfica simples, utilizando a biblioteca Swing (JOptionPane).

### Funcionalidades Principais

#### Gerenciamento de Usuários (CRUD)
- Cadastro: Permite o registro de três perfis distintos: Aluno, Professor e Servidor Administrativo, cada um com seus atributos específicos.
- Busca: Possibilita a busca de usuários por identificadores únicos (matrícula ou email), essencial para operações de agendamento e relatórios.
- Exclusão: Permite a remoção de usuários do sistema através de sua matrícula.

#### Cadastro de Espaços Físicos
- Registro de diferentes tipos de espaços, como Sala de Aula, Laboratório e Auditório.
- Especificação de detalhes como nome, capacidade máxima, localização e lista de equipamentos.

#### Sistema de Agendamento
- Realização de novas reservas de espaços por usuários devidamente cadastrados.
- Validação de regras de negócio críticas, como conflito de horários e limites de duração por perfil.

#### Geração de Relatório
- Emissão de relatórios de todos os agendamentos realizados por um usuário específico.
- Geração de relatórios de ocupação de um espaço físico em um determinado período.

### Exceções Customizadas

O sistema implementa várias exceções personalizadas para garantir a integridade dos dados e a consistência das operações:

- **UsuarioNaoEncontradoException**: Lançada quando uma busca por usuário (via email ou matrícula) não retorna resultados;
- **UsuarioJaCadastradoException**: Impede o cadastro de usuários com emails duplicados;
- **HorarioIndisponivelException**: Sinaliza um conflito de horários ao tentar agendar um espaço já ocupado;
- **DiasExcedidosException**: Garante que a regra de negócio que limita a duração dos agendamentos de alunos seja cumprida;
- **CampoInvalidoException**: Usada para validações de formulário, indicando que um campo obrigatório está vazio ou com formato incorreto.

## Features

- [x] Cadastro de Usuários (Aluno, Professor, Servidor)
- [x] Cadastro de Espaços Físicos (Sala de Aula, Laboratório, Auditório)
- [x] Sistema de Agendamento com Validação de Regras
- [x] Geração de Relatórios por Usuário e Espaço
- [x] Busca e Exclusão de Usuários (CRUD)
- [x] Implementação de Exceções
- [x] Uso dos conceitos de OO:

- Encapsulamento
- Herança
- Polimorfismo

## ☕ Como executar o projeto

#### Pré-requisitos
- É necessário ter o Java Development Kit (JDK) versão 11 ou superior instalado e configurado em sua máquina.
   Segue o link para instalar a versão mais recente Java/jdk:

   [![Baixar JDK](https://img.shields.io/badge/Download_JDK-Oracle-red)]([https://www.oracle.com/java/technologies/downloads/?er=221886#jdk22-windows](https://www.oracle.com/java/technologies/downloads/))

### Executando pela IDE
1. Clone este repositório para o seu computador.
2. Abra o projeto na sua IDE de preferência (VS Code, IntelliJ, Eclipse).
3. Localize a classe Principal.java.
4. Execute o método main() contido nela.

## 🛠️ Ferramentas e Modelagem

- Linguagem: Java
- Interface Gráfica: Java Swing (utilizando JOptionPane)
- Controle de Versão: Git & GitHub
- IDE: Visual Studio Code
- Modelagem UML: draw.io
