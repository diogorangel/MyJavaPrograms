# Task Manager API
Author: Diogo Rangel Dos Santos

REST API de gerenciamento de tarefas usando Java 17, Spring Boot, Spring Data JPA e H2.

## Executar

Com Maven instalado, inicie a aplicação na raiz do projeto:

```shell
mvn spring-boot:run
```

A API ficará disponível em `http://localhost:8080/api/v1/tasks`.

## Testes

```shell
mvn test
```

## Endpoints

- `POST /api/v1/tasks` — cria uma tarefa.
- `GET /api/v1/tasks` — lista as tarefas.
- `GET /api/v1/tasks/{id}` — busca uma tarefa.
- `PATCH /api/v1/tasks/{id}/status?status=IN_PROGRESS` — atualiza o status.
