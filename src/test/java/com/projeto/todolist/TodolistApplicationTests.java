package com.projeto.todolist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.projeto.todolist.dto.TodoDTO;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodolistApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTodoSuccess() {
		TodoDTO todo = new TodoDTO("Test Todo", "This is a test todo", false, 1); 
		
		webTestClient.post()
			.uri("/todos")
			.bodyValue(todo)
			.exchange() // Envia a requisição e obtém a resposta
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$").isArray() // Verifica se a resposta é um array
			.jsonPath("$[0].nome").isEqualTo(todo.getNome())
			.jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
			.jsonPath("$[0].realizado").isEqualTo(todo.isRealizado())
			.jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade());
	}

	@Test
	void testCreatTodoFailuire(){
		webTestClient.post()
			.uri("/todos")
			.bodyValue(new TodoDTO("","",false, 1))
			.exchange()
			.expectStatus().isBadRequest(); // Verifica se o status da resposta é 400 Bad Request
	}

}
