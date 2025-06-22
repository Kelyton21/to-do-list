package com.projeto.todolist.dto;
import com.projeto.todolist.entities.Todo;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class TodoDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    private boolean realizado;
    private Integer prioridade;

    public TodoDTO(Todo todo) {
        this.nome = todo.getNome();
        this.descricao = todo.getDescricao();
        this.realizado = todo.isRealizado();
        this.prioridade = todo.getPrioridade();
    }

    public TodoDTO(String nome, String descricao, boolean realizado, Integer prioridade) {
        this.nome = nome;
        this.descricao = descricao;
        this.realizado = realizado;
        this.prioridade = prioridade;
    }
}
