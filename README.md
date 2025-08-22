# Sistema Escolar (Spring Boot + H2)

Este projeto é uma aplicação simples construída com **Spring Boot** com o objetivo de praticar a criação de APIs RESTful.  
Atualmente utiliza o **banco de dados H2 em memória** (acessível via console) apenas para consultas e persistência simples.

> 🚧 Em desenvolvimento. Futuramente será criada uma interface para interagir com o sistema.

---

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Lombok
- Banco de dados H2
- Maven

---

## Funcionalidades

- Cadastro de **Usuarios** Json Web Token
- Cadastro de **Alunos** e **Professores**
- Cadastro de **Salas de aula** e **Disciplinas**
- Filtros por CPF, RG, nome, matrícula, data de nascimento e disciplina
- Atualização e exclusão de cadastros
- Persistência em banco H2 (console disponível em `http://localhost:8080/h2-console`)

---

## Endpoints disponíveis

### Login/Registro
  
#### Modificação

| Método  | Endpoint         | Descrição         |
|---------|------------------|-------------------|
| `POST`  | `/auth/register` | Cadastrar usuario |
| `POST`  | `/auth/login`    | Logar usuario     |

#### Exemplo de body para cadastro:

```json
{
  "nome": "João",
  "email": "joao@email.com",
  "senha": "123",
  "confirmarSenha": "123"
}
```

#### Exemplo de body para logar:

```json
{
  "email": "joao@email.com",
  "senha": "123"
}
```

### Sala de Aula

#### Listagem

| Método | Endpoint         | Descrição                     |
|--------|------------------|-------------------------------|
| `GET`  | `/serie`         | Listar todos as salas de aula |
| `GET`  | `/serie/id/{id]` | Listar por id                 |

#### Modificação

| Método  | Endpoint | Descrição                   |
|---------|----------|-----------------------------|
| `POST`  | `/serie` | Cadastrar nova sala de aula |

#### Exemplo de body para cadastro:

```json
{
    "nome": "9A",
    "sala": "15",
    "turno": "Tarde"
}
```

### Alunos

#### Listagem

| Método | Endpoint                                   | Descrição                      |
|--------|--------------------------------------------|--------------------------------|
| `GET`  | `/alunos`                                  | Listar todos os alunos         |
| `GET`  | `/alunos/id/{id]`                          | Buscar por id                  |
| `GET`  | `/alunos/matricula/{matricula}`            | Buscar por matrícula           |
| `GET`  | `/alunos/nome?nome={nome}`                 | Listar por nome                |
| `GET`  | `/alunos/data?data={dd/MM/yyyy}`           | Listar por data de nascimento  |
| `GET`  | `/alunos/cpf/{cpf}`                        | Buscar por CPF                 |
| `GET`  | `/alunos/rg/{rg}`                          | Buscar por RG                  |
| `GET`  | `/alunos/serie/id?id={id}`                 | Listar alunos de uma serieId   |
| `GET`  | `/alunos/serie/nome?serieNome={serieNome}` | Listar alunos de uma serieNome |

#### Modificação

| Método  | Endpoint                        | Descrição                     |
|---------|---------------------------------|-------------------------------|
| `POST`  | `/alunos`                       | Cadastrar novo aluno          |
| `PUT`   | `/alunos/matricula/{matricula}` | Atualizar aluno por matrícula |
| `DELETE`| `/alunos/matricula/{matricula}` | Remover aluno por matrícula   |
| `DELETE`| `/alunos/id/{id}`               | Remover aluno por id          |

#### Exemplo de body para cadastro:
```json
{
    "matricula": "123-abc",
    "cpf": 12345678931,
    "rg": 123456789012345,
    "nome": "João Pedro",
    "dataDeNascimento": "10/10/2001",
    "telefone": "+5519994435132",
    "endereco": {
      "logradouro": "Avenida São João",
      "numero": "432",
      "complemento": "Bloco A, Apt 502",
      "bairro": "Jardim das Flores",
      "cidade": "Campinas",
      "estado": "SP",
      "cep": "13084-445",
      "pais": "Brasil"
    },
    "serieId": 1
} 
```

### Disciplinas

#### Listagem

| Método | Endpoint              | Descrição                   |
|--------|-----------------------|-----------------------------|
| `GET`  | `/disciplina`         | Listar todos as disciplinas |
| `GET`  | `/disciplina/id/{id]` | Buscar por id               |

#### Modificação

| Método  | Endpoint      | Descrição                 |
|---------|---------------|---------------------------|
| `POST`  | `/disciplina` | Cadastrar nova disciplina |

#### Exemplo de body para cadastro:

```json
{
    "nome": "Inglês"
}

```

### Professores

#### Listagem

| Método | Endpoint                                                     | Descrição                              |
|--------|--------------------------------------------------------------|----------------------------------------|
| `GET`  | `/professor`                                                 | Listar todos os professores            |
| `GET`  | `/professor/id/{id}`                                         | Buscar por matrícula                   |
| `GET`  | `/professor/matricula/{matricula}`                           | Buscar por matrícula                   |
| `GET`  | `/professor/nome?nome={nome}`                                | Listar por nome                        |
| `GET`  | `/professor/data?data={dd/MM/yyyy}`                          | Listar por data de nascimento          |
| `GET`  | `/professor/cpf/{cpf}`                                       | Buscar por CPF                         |
| `GET`  | `/professor/rg/{rg}`                                         | Buscar por RG                          |
| `GET`  | `/professor/disciplina/id?disciplinasId={disciplinasId}`     | Listar professor de uma disciplinaId   |
| `GET`  | `/professor/disciplina/nome?disciplinaNome={disciplinaNome}` | Listar professor de uma disciplinaNome |

#### Modificação

| Método  | Endpoint                           | Descrição                         |
|---------|------------------------------------|-----------------------------------|
| `POST`  | `/professor`                       | Cadastrar novo professor          |
| `PUT`   | `/professor/matricula/{matricula}` | Atualizar professor por matricula |
| `DELETE`| `/professor/matricula/{matricula}` | Remover professor por matrícula   |
| `DELETE`| `/professor/id/{id}`               | Remover professor por id          |

#### Exemplo de body para cadastro:
```json
{
    "matricula": "123-abc",
    "cpf": 12345678931,
    "rg": 123456789012345,
    "name": "Maria Rosa",
    "dataDeNascimento": "10/10/2001",
    "telefone": "+5519994435132",
    "endereco": {
      "logradouro": "Avenida São João",
      "numero": "432",
      "complemento": "Bloco A, Apt 502",
      "bairro": "Jardim das Flores",
      "cidade": "Campinas",
      "estado": "SP",
      "cep": "13084-445",
      "pais": "Brasil"
  },
    "disciplinasId": [1, 2]
} 
```

## Próximos passos

- [ ] Criar interface web com Spring MVC ou React
- [ ] Adicionar testes unitários e de integração  
- [X] Implementar autenticação (JWT ou Spring Security)  
- [ ] Persistência com banco relacional real (PostgreSQL ou MySQL)
