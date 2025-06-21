package com.projeto.todolist.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projeto.todolist.dto.TodoDTO;
import com.projeto.todolist.services.TodoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/todos")
@Tag(name = "Gerenciamento de Tarefas", description = "Endpoints para criar, listar, atualizar e deletar tarefas (To-dos)")

public class TodoController {
    @Autowired
    private TodoService todoService;

    @Operation(summary = "Cria uma nova tarefa", description = "Cria uma nova tarefa e retorna a lista completa de tarefas atualizada.")
    @PostMapping
    public ResponseEntity<List<TodoDTO>> create(@RequestBody TodoDTO entity) {
        try{
            List<TodoDTO> todos = todoService.create(entity);
            return ResponseEntity.ok(todos);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Operation(summary = "Lista todas as tarefas", description = "Retorna uma lista com todas as tarefas cadastradas.")
    @GetMapping
    public ResponseEntity<List<TodoDTO>> list() {
        try {
            List<TodoDTO> todos = todoService.list();
            return ResponseEntity.ok(todos);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Operation(summary = "Deleta uma tarefa existente", description = "Deleta uma tarefa com base no seu ID e retorna a lista de tarefas restante.")
   @DeleteMapping(value = "/{id}")
    public ResponseEntity<List<TodoDTO>> delete(@PathVariable Long id) {
        try {
            List<TodoDTO> todos = todoService.delete(id);
            return ResponseEntity.ok(todos);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Operation(summary = "Atualiza uma tarefa existente", description = "Atualiza os dados de uma tarefa existente com base no seu ID.")
    @PutMapping(value = "/{id}")
    public ResponseEntity<List<TodoDTO>> update(@PathVariable Long id, @RequestBody TodoDTO entity) {
        try {
            List<TodoDTO> todos = todoService.update(id, entity);
            return ResponseEntity.ok(todos);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
