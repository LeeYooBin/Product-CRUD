# CRUD de Produtos

Este projeto é um CRUD completo de produtos utilizando Spring Boot. É possível listar, adicionar, remover e editar um produto. O banco de dados utilizado é o H2, um banco de dados em memória usado para testes, portanto, os produtos persistem apenas enquanto o servidor estiver ativo. Ao iniciar o servidor, alguns produtos são registrados automaticamente para melhor ilustração.

## Funcionalidades

- **Listagem de Produtos:** Lista todos os produtos cadastrados, ordenados pelo valor do menor para o maior.
- **Adicionar Produto:** Formulário para cadastrar um novo produto.
- **Editar Produto:** Formulário para editar informações de produtos existentes.
- **Remover Produto:** Opção de remover produtos existentes.

## Banco de Dados

Este projeto utiliza o banco de dados H2. O H2 é um banco de dados em memória, ideal para testes e desenvolvimento, mas não para produção. Os dados persistem apenas enquanto o servidor estiver em execução.

## Requisitos

- Java 8 ou superior
- Maven
- Navegador Web

## Como Executar

### Usuários Windows

1. **Executar via Script Automatizado**
  - Na raiz do projeto, clique duas vezes no arquivo `start.bat`.

### Manualmente (Para Todos os Sistemas Operacionais)

1. **Navegue para o diretório do projeto Spring Boot:**
  ```bash
  cd products-register
  ```
2. **Inicie o servidor spring boot**
  ```bash
  mvn spring-boot:run
  ```
3. **Abra a página HTML no navegador**
  - **Windows**
  ```bash
  start "frontend\index.html"
  ```
  - **Linux/Mac**
  ```bash
  xdg-open "./frontend/index.html"
  ```

## Observações

- Em todos os casos, é necessário ter um ambiente de desenvolvimento Java configurado na máquina.
- O servidor Spring Boot registra alguns produtos automaticamente ao ser iniciado, facilitando a ilustração das funcionalidades do CRUD.

## Estrutura do Projeto

- products-register: Contém o código fonte do servidor Spring Boot.
- frontend: Contém o arquivo index.html para a interface do usuário.