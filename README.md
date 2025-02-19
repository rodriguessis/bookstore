Bookstore

Descrição

O Bookstore é um sistema de gerenciamento de livraria desenvolvido com Spring Boot no backend e Vue.js 3 no frontend. O projeto permite a administração de livros, categorias e usuários, oferecendo uma interface moderna e responsiva para gestão de estoque e vendas.

Tecnologias Utilizadas

Spring Boot - Backend e API REST

Vue.js 3 - Frontend SPA

MySQL - Banco de dados relacional

Tailwind CSS - Estilização da interface

Docker (Opcional) - Contêinerização do ambiente

Funcionalidades

Gerenciamento de livros (CRUD)

Categorização de livros

Controle de estoque

Autenticação e autorização de usuários

Interface responsiva e intuitiva

Instalação

Requisitos

Antes de iniciar, certifique-se de ter instalado:

Java 17+

Maven

Node.js & npm

MySQL ou PostgreSQL

Passo a Passo

Clone o repositório:

git clone https://github.com/rodriguessis/bookstore.git
cd bookstore

Instale as dependências do backend:

mvn clean install

Instale as dependências do frontend:

npm install

Configure o ambiente:

cp .env.example .env

Atualize as credenciais do banco de dados no arquivo .env.

Execute as migrações e popule o banco:

mvn spring-boot:run

Inicie o servidor backend:

mvn spring-boot:run

Inicie o servidor frontend:

npm run dev

Uso

Acesse o frontend em http://localhost:5173 (se configurado com Vite)

API disponível em http://127.0.0.1:8080/api

Docker (Opcional)

Caso queira rodar o projeto usando Docker, utilize:

docker-compose up -d --build

Isso irá subir os containers do Spring Boot, banco de dados e frontend.

Testes

Para executar os testes do backend:

mvn test

Para testar o frontend:

npm run test

Licença

Este projeto está licenciado sob a MIT License.

Autor

Desenvolvido por Rodriguessis. Contribuições são bem-vindas! 🚀
