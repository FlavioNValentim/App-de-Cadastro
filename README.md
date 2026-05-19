# App-de-Cadastro
Sistema Simples de Cadastro.

Aplicativo Android simples desenvolvido em Java utilizando SQLite para cadastro de contatos.

## Funcionalidades

- Inserir contatos
- Listar contatos cadastrados
- Alterar contatos
- Excluir contatos
- Preencher automaticamente os dados de um contato pesquisando pelo nome

## Tecnologias Utilizadas

- Java
- Android Studio
- SQLite
- Android SDK

## Estrutura do Projeto

- `MainActivity.java`
  - Responsável pelas ações da interface e operações do app.

- `HelperDB.java`
  - Classe responsável pela criação e manipulação do banco SQLite.

## Banco de Dados

Tabela criada:

```sql
CREATE TABLE contatos (
    nome TEXT PRIMARY KEY,
    celular TEXT,
    email TEXT
);
