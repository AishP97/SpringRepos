package com.example.ToDoList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {
	
	@Autowired
	private ToDoService sertodo;
	
	@PostMapping
	public ResponseEntity<EntityToDo> createToDo(@RequestBody EntityToDo todo){
		EntityToDo createdToDo = sertodo.createToDo(todo);
		return new ResponseEntity<>(createdToDo, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<EntityToDo>> getAllTodo(){
		List<EntityToDo> ltodoslist = sertodo.getAllTodo();
		return ResponseEntity.ok(ltodoslist);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EntityToDo> getToDoByID(@PathVariable Long id){
		EntityToDo todo = sertodo.getToDoByID(id);
		return ResponseEntity.ok(todo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EntityToDo> TodoComplete(@PathVariable Long id){
		EntityToDo updatedToDo = sertodo.TodoComplete(id);
		return ResponseEntity.ok(updatedToDo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<EntityToDo> deleteToDo(@PathVariable Long id){
		sertodo.deleteToDo(id);
		return ResponseEntity.noContent().build();
	}

}
