# 📋 Todo List

API para gerenciamento de tarefas (To-dos), permitindo **criar**, **listar**, **atualizar** e **remover** tarefas com prioridade, descrição e status de conclusão.

---

## 🚀 Tecnologias Utilizadas

- ✅ **Java 17+**
- ✅ **Spring Boot**
- ✅ **Spring Data JPA**
- ✅ **PostgreSQL** (produção)
- ✅ **H2 Database** (testes e desenvolvimento)
- ✅ **Lombok**
- ✅ **SpringDoc OpenAPI 3 (Swagger UI)**

---

## 🔧 Práticas Adotadas

- Arquitetura em **Camadas (Controller, Service, Repository)**
- **API RESTful**
- **Injeção de Dependência** com `@Autowired`
- **Validação de dados** com `@Valid`
- **DTOs** para abstração e segurança de dados expostos
- **Tratamento de erros** e exceções com mensagens apropriadas
- Documentação automática com **Swagger/OpenAPI 3**

---

## 🔨 Endpoints Disponíveis

| Método | Rota            | Descrição                      |
|--------|------------------|-------------------------------|
| POST   | `/todos`         | Cria uma nova tarefa          |
| GET    | `/todos`         | Lista todas as tarefas        |
| PUT    | `/todos/{id}`    | Atualiza uma tarefa existente |
| DELETE | `/todos/{id}`    | Deleta uma tarefa existente   |

---

## 📘 Exemplo de Objeto JSON

```json
{
  "nome": "Estudar Spring Boot",
  "descricao": "Revisar conceitos de API REST e práticas com JPA",
  "realizado": false,
  "prioridade": 2
}

  
  
