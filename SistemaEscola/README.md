# Sistema Escolar

Sistema escolar desenvolvido em Java, utilizando PostgreSQL como banco de dados.  
O projeto foi desenvolvido no Eclipse e utiliza JDBC para conexão com o banco.

## Tecnologias Utilizadas

Java (JDK 8 ou superior)  
Eclipse IDE  
PostgreSQL  
pgAdmin 4  
JDBC (PostgreSQL Driver)

## Estrutura do Projeto

SistemaEscola/  
├── src/  
├── database/  
│   └── banco.sql  
├── README.md  

## Banco de Dados

O projeto utiliza PostgreSQL.

Nome do banco de dados:  
escola_at

## Como criar o banco de dados

1. Abrir o pgAdmin 4  
2. Criar um banco de dados com o nome escola_at  
3. Abrir o Query Tool  
4. Executar o script localizado em database/banco.sql  

O script contém a estrutura do banco de dados (tabelas, chaves primárias e estrangeiras).

## Configuração da Conexão com o Banco

A configuração da conexão está localizada no arquivo ConexaoDB.java.

Os dados de conexão devem ser ajustados conforme o ambiente local:

Host: localhost  
Porta: 5432  
Banco: escola_at  
Usuário: postgres  
Senha: definida localmente pelo usuário  

Por motivos de segurança, a senha real do banco de dados não é versionada no GitHub.

## Como executar o projeto

1. Importar o projeto no Eclipse  
2. Garantir que o PostgreSQL esteja em execução  
3. Configurar corretamente os dados de conexão com o banco  
4. Executar a classe principal do sistema  

## Observações

O banco de dados não é enviado em execução, apenas o script SQL.  
As credenciais do banco devem ser configuradas localmente.  
Projeto desenvolvido para fins acadêmicos.

## Autor

Projeto desenvolvido como trabalho acadêmico.
