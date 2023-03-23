
# Desafio Full-stack (backend)



## Stack utilizada

**Backend-end:** Java 17, Spring Boot 2.7.9

**Banco de dados:** MySQL e H2database (para caso não seja possível subir o MySQL)

## Rodando localmente

Clone o projeto

```bash
  git clone https://github.com/LemosLeonardo/desafio-fullstack-acc-backend
```

Importe o projeto em uma IDE ou editor de texto

```
Ex: Visual Studio Code, IntelliJ  Etc.
```

**Configurando do Banco de dados:**

Abra o arquivo ``application.properties`` localizado neste diretório:
```
src\main\resources\application.properties
```

Preencha os parâmetros do MySQL (não se esqueça de criar o banco de dados para este projeto)

```bash 
spring.datasource.url=jdbc:mysql://localhost:3306/desafio
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Caso não queira utilizar o MySQL, você precisa comentar/excluir as configurações acima e descomentar (tirar as #) das configurações do H2.


Feito isso, execute o projeto.
## Documentação da API
### Empresas
#### Retorna todos os itens

```http
  GET /api/company
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
|             | `List` |Retorna todas as empresas |

#### Retorna um item

```http
  GET /api/company/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID da empresa que você deseja buscar |

```http
  GET /api/company/total
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
|       | `Long` | Retorna o número de empresas cadastradas |

```http
  POST /api/company
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
|      `Company`       | `Company` |Cria uma empresa e retorna seus dados |

```http
  PUT /api/company/{id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
|      `id`       | `string` |Localiza a empresa pelo ID  |
|      `Company`       | `Company` |Atualiza seu registros com as informações passadas  |

```http
  DELETE /api/company/{id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
|      `id`       | `string` |Localiza a empresa pelo ID e realiza a exclusão dela.|



### Fornecedores
#### Retorna todos os itens

```http
  GET api/vendor/pj
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
|             | `List` |Retorna todos os fornecedores |


```http
  GET api/vendor/pj/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do fornecedor que você deseja buscar |


```http
  GET api/vendor/pj/total
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
|       | `Long` | Retorna o número de fornecedores cadastrados |


```http
  POST api/vendor/pj
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
|      `VendorPJ`       | `VendorPJ` |Cria um fornecedor e retorna seus dados |

```http
  PUT api/vendor/pj/{id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
|      `id`       | `string` |Localiza o fornecedor pelo ID  |
|      `VendorPJ`       | `VendorPJ` |Atualiza seu registros com as informações passadas  |

```http
  DELETE api/vendor/pj/{id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
|      `id`       | `string` |Localiza o fornecedor pelo ID e realiza sua exclusão.|

# Próximos passos

- Adicionar relação empresa x fornecedor
- Validação de campos:
    - Se campos chaves já estão sendo utilizados (cnpj, cpf, rg e email);
    - Validar se os dados de endereço fornecidos pelo front-end são consistentes
- Adicionar cadastro para fornecedor Pessoa Jurídica
    - Seguir validações propostas pelo desafio
- Aplicar camada de serviço
- Implementar testes
- Implementar Spring Security e exigir autenticação na API

# Melhorias
- Refatorar modelos e relações entre entidades 
