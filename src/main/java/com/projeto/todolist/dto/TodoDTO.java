package com.projeto.todolist.dto;
import com.projeto.todolist.entities.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class TodoDTO {
    private String nome;
    private String descricao;
    private boolean realizado;
    private Integer prioridade;

    public TodoDTO(Todo todo) {
        this.nome = todo.getNome();
        this.descricao = todo.getDescricao();
        this.realizado = todo.isRealizado();
        this.prioridade = todo.getPrioridade();
    }
}
