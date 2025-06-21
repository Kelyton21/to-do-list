package com.projeto.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.todolist.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
