package com.projeto.todolist.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projeto.todolist.entities.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    public Todo findByNome(String nome);
}
