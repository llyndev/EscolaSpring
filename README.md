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
- Banco de dados H2
- Maven

---

## Funcionalidades

- Cadastro de **Alunos** e **Professores**
- Filtros por CPF, RG, nome, matrícula, data de nascimento e licenciatura
- Atualização e exclusão de cadastros
- Persistência em banco H2 (console disponível em `http://localhost:8080/h2-console`)

---

## Endpoints disponíveis

### Alunos

#### Listagem

| Método | Endpoint                                  | Descrição                      |
|--------|-------------------------------------------|--------------------------------|
| `GET`  | `/alunos`                                 | Listar todos os alunos         |
| `GET`  | `/alunos/matricula?matricula={matricula}` | Buscar por matrícula           |
| `GET`  | `/alunos/nome?nome={nome}`                | Buscar por nome                |
| `GET`  | `/alunos/data?data={dd/MM/yyyy}`          | Buscar por data de nascimento  |
| `GET`  | `/alunos/cpf?cpf={cpf}`                   | Buscar por CPF                 |
| `GET`  | `/alunos/rg?rg={rg}`                      | Buscar por RG                  |

#### Modificação

| Método  | Endpoint                           | Descrição                          |
|---------|------------------------------------|------------------------------------|
| `POST`  | `/alunos`                          | Cadastrar novo aluno               |
| `PUT`   | `/alunos?matricula={matricula}`    | Atualizar aluno por matrícula      |
| `DELETE`| `/alunos?matricula={matricula}`    | Remover aluno por matrícula        |

#### Exemplo de body para cadastro:
```json
{
    "cpf": 12345678931,
    "rg": 123456789012345,
    "name": "Exemplo",
    "dataDeNascimento": "10/10/2001",
    "endereco": "Rua Exemplo, 123"
} 
```

### Professores

#### Listagem

| Método | Endpoint                                     | Descrição                      |
|--------|----------------------------------------------|--------------------------------|
| `GET`  | `/professor`                                 | Listar todos os professores    |
| `GET`  | `/professor/matricula?matricula={matricula}` | Buscar por matrícula           |
| `GET`  | `/professor/nome?nome={nome}`                | Buscar por nome                |
| `GET`  | `/professor/data?data={dd/MM/yyyy}`          | Buscar por data de nascimento  |
| `GET`  | `/professor/cpf?cpf={cpf}`                   | Buscar por CPF                 |
| `GET`  | `/professor/rg?rg={rg}`                      | Buscar por RG                  |
| `GET`  | `/professor/materia?materia={materia}`       | Buscar por licenciatura        |

#### Modificação

| Método  | Endpoint                             | Descrição                           |
|---------|--------------------------------------|-------------------------------------|
| `POST`  | `/professor`                         | Cadastrar novo professor            |
| `PUT`   | `/professor?matricula={matricula}`   | Atualizar professor por matrícula   |
| `DELETE`| `/professor?matricula={matricula}`   | Remover professor por matrícula     |

#### Exemplo de body para cadastro:
```json
{
    "cpf": 12345678931,
    "rg": 123456789012345,
    "name": "Exemplo",
    "dataDeNascimento": "10/10/2001",
    "licenciatura": "Inglês",
    "endereco": "Rua Exemplo, 456"
} 
```

## Próximos passos

- [ ] Criar interface web com Spring MVC ou React  
- [ ] Adicionar testes unitários e de integração  
- [ ] Implementar autenticação (JWT ou Spring Security)  
- [ ] Persistência com banco relacional real (PostgreSQL ou MySQL)
