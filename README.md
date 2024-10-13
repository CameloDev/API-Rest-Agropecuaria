## Instalação

### Pré-requisitos

- **Java 21** ou superior
- **Maven**
- **MySQL**

### Passos para rodar o projeto

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/CameloDev/api-rest-agropecuaria.git
   ```

2. **Configure o banco de dados**:
   Certifique-se de que o MySQL está instalado e rodando. Crie um banco de dados chamado `agropecuariateste` ou modifique o arquivo `application.properties` para refletir suas configurações de banco.

3. **Execute as migrações Flyway**:
   O Flyway será executado automaticamente ao iniciar o projeto, criando as tabelas necessárias no banco.

4. **Compile e rode o projeto**:
   Dentro do diretório do projeto, execute o seguinte comando para iniciar a API:
   ```bash
   mvn spring-boot:run
   ```

5. **Acesse a documentação da API**:
   A documentação da API pode ser acessada via OpenAPI em:
   ```
   http://localhost:8080/swagger-ui.html
   ```

## Funcionalidades

- **Clientes**: Cadastro, listagem, atualização e remoção de clientes.
- **Fornecedores**: Gerenciamento de fornecedores da agropecuária.
- **Funcionários**: Controle dos dados de funcionários.
- **Produtos**: Inserção, consulta e edição de produtos.
- **Pedidos**: Criação e gerenciamento de pedidos e entregas.

## Segurança

A API utiliza **JWT (JSON Web Tokens)** para autenticação. O usuário precisa estar autenticado para acessar as rotas protegidas.

## Testes

O projeto inclui dependências para testes com **JUnit** e **Spring Security**. Para rodar os testes, use:
```bash
mvn test
```

## Contribuição

Sinta-se à vontade para contribuir com este projeto. Basta fazer um fork e enviar um pull request.

## Contribuintes
## @clebson-dev
