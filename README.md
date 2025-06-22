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
```
### Campos
- **nome** *(string, obrigatório)*: Nome da tarefa
- **descricao** *(string, opcional)*: Descrição detalhada da tarefa
- **realizado** *(boolean)*: Status de conclusão da tarefa
- **prioridade** *(integer)*: Nível de prioridade (1-5, onde 1 é mais alta)
---

## 📚 Como Executar o Projeto
1. Clone o repositório:
git clone https://github.com/seuusuario/todo-list.git
cd todo-list

2. Configure o perfil de projeto do banco de dados (em application.properties)
   - test
   - dev
3. Execute o projeto
4. Acesse a documentação Swagger:
   . http://localhost:8080/swagger-ui.html

## Estrutura do projeto

com.projeto.todolist
├── controllers
├── dto
├── entities
├── repositories
├── services
└── TodoListApplication.java
--- 
### Passos para Execução

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seuusuario/todo-list.git
   cd todo-list
   ```

2. **Configure o perfil do banco de dados:**
   
   Edite o arquivo `application.properties` e escolha o perfil:
   - `test` - Usa H2 Database (em memória)
   - `dev` - Usa PostgreSQL local
   - `prod` - Configuração para produção

3. **Execute o projeto:**
   ```bash
   mvn spring-boot:run
   ```

4. **Acesse a documentação Swagger:**
   
   Abra seu navegador em: http://localhost:8080/swagger-ui.html

## 📁 Estrutura do Projeto

```
com.projeto.todolist/
├── controllers/          # Controladores REST
├── dto/                 # Data Transfer Objects
├── entities/            # Entidades JPA
├── repositories/        # Repositórios de dados
├── services/           # Lógica de negócio
└── TodoListApplication.java  # Classe principal
```
  
