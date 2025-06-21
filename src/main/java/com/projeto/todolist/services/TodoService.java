package com.projeto.todolist.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.projeto.todolist.dto.TodoDTO;
import com.projeto.todolist.entities.Todo;
import com.projeto.todolist.repositories.TodoRepository;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<TodoDTO> create (TodoDTO entity){
        Todo todoExiste = todoRepository.findByNome(entity.getNome());
        if (todoExiste != null) {
            throw new RuntimeException("Já existe uma tarefa com esse nome");
        }
        Todo todoNovo = new Todo();
        todoNovo.setNome(entity.getNome());
        todoNovo.setDescricao(entity.getDescricao());
        todoNovo.setRealizado(entity.isRealizado());
        todoNovo.setPrioridade(entity.getPrioridade());
        todoRepository.save(todoNovo);
        return list();
    }

    public List<TodoDTO> update(Long id, TodoDTO entity){
        var todoExiste = todoRepository.findById(id);
        if(todoExiste.isPresent()){
            if(entity.getNome() != null){
                todoExiste.get().setNome(entity.getNome());
            }
            if (entity.getDescricao() != null) {
                todoExiste.get().setDescricao(entity.getDescricao());
            }
            if (entity.getPrioridade() != null) {
                todoExiste.get().setPrioridade(entity.getPrioridade());
            }
            if (entity.isRealizado() != todoExiste.get().isRealizado()) {
                todoExiste.get().setRealizado(entity.isRealizado());
            }
            todoRepository.save(todoExiste.get());
            return list();
        }
        throw new RuntimeException("Tarefa não encontrada");
    }

    public List<TodoDTO> delete(Long id){
        var todoExiste = todoRepository.findById(id);
        if(todoExiste.isPresent()){
            todoRepository.delete(todoExiste.get());
            return list();
        }
        throw new RuntimeException("Tarefa não encontrada");
    }

    public List<TodoDTO> list(){
        Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
        List<Todo> listaTodos = todoRepository.findAll(sort);
        List <TodoDTO> listaDTO = listaTodos.stream()
            .map(x -> new TodoDTO(x))
            .toList();
        return listaDTO;
    }
}
