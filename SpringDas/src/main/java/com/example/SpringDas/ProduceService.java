package com.example.SpringDas;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProduceService {
	
	List<grocery> groceries = Arrays.asList(new grocery("Okra", 10, 8),
		(new grocery("Potatoes",14,6)),
		(new grocery("Tomatoes",16,20)),
		(new grocery("Pumpkin",12,30)),
		(new grocery("Lemons",11,50)),
		(new grocery("Onions",19,60)),
		(new grocery("Sweet Potatoes",20,60))
			
	);
	
	public List<grocery> getGroceries(){
		return groceries;
	}

}
