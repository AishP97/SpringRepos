package com.example.ToDoList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ToDoService {
	
	@Autowired
	private ToDoRepo repotodo;
		
	public EntityToDo createToDo(EntityToDo todo) {
		return repotodo.save(todo);
	}
	
	public List<EntityToDo> getAllTodo(){
		return repotodo.findAll();
	}
	
	public EntityToDo getToDoByID(Long id) {
		return repotodo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Data not found"));
	}
	
	public EntityToDo TodoComplete(Long id) {
		EntityToDo todo = getToDoByID(id);
		todo.setCompleted(true);
		return repotodo.save(todo);
	}
	
	public void deleteToDo(Long id) {
		repotodo.deleteById(id);
	}
}
