# Dimensa-CRUD

http://ec2-18-188-244-186.us-east-2.compute.amazonaws.com/swagger-ui/index.html#/

<p>
  Este projeto consiste em um aplicativo CRUD de contatos desenvolvido com o framework Spring e o Swagger para a documentação. Utilizando o banco de dados PostgreSQL para armazenamento persistente, 
  o aplicativo permite a criação, leitura, atualização e exclusão de informações de contatos. Além disso, o uso do Docker facilita a implantação e execução do aplicativo em diferentes ambientes.
  As requisições são feitas pela ferramenta Postman.
</p>

![Captura de Tela (8)](https://github.com/Pedrooliveira465/Contact-CRUD/assets/92175893/bba874a4-5845-4932-bced-4fbdbc9b9b89)


## Pré-requisitos
- Java 17
- Docker
- Docker Compose
- PostgreSQL
- Postman

## Como executar

### Executar todo o projeto
1. Construir o projeto: ./mvnw clean install ou mvn clean install

2. Levantar os serviços com Docker Compose: docker-compose up --build

### Executar apenas o banco de dados (modo desenvolvimento)
1. Levantar o serviço do PostgreSQL com o Docker Compose específico: docker-compose -f docker-compose.dev.yml up

## Acessar a documentação da API (Swagger)
Após executar o projeto, a documentação da API estará disponível em: http://localhost:8080/swagger-ui.html

![Captura de Tela (6)](https://github.com/Pedrooliveira465/Contact-CRUD/assets/92175893/6e470140-7ec5-40fc-bc7f-7b5a6e52af07)


## Estrutura do Projeto
- `/src`: Código fonte do projeto
- `/src/main/resources`: Arquivos de configuração
- `/docker-compose.yml`: Docker Compose para executar todo o projeto
- `/docker-compose.dev.yml`: Docker Compose para executar apenas o PostgreSQL

## Configuração
Para alterar as configurações do banco de dados, modifique `application.properties` ou `application.yml`.

# Autor

Pedro Lucas De Oliveira Silva

https://www.linkedin.com/in/pedrooliveirajava/
