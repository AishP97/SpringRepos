package com.example.SpringDas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduceController{
	
	@Autowired
	ProduceService service;
	
	
	@RequestMapping("/grocery")
	public List<grocery> getGroceries(){
		return service.getGroceries();
		
	}
}