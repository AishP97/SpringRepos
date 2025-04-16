package com.example.ToDoList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*; 

@SpringBootTest
@AutoConfigureMockMvc
class ToDoListApplicationTests {

	@Autowired
	private MockMvc mvc;
	
	@Test
	void getToDoReturnList() throws Exception  {
		mvc.perform(MockMvcRequestBuilders.get(("/api/todo")))
				.andExpect(status().isOk())
	               .andExpect(jsonPath("$[0]").value("Learn CI/CD using Github Actions) "));

	}

}
