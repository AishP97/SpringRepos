package com.example.ToDoList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepo extends JpaRepository<EntityToDo, Long> {
	
}
