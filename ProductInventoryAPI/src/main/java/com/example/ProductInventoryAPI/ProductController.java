package com.example.ProductInventoryAPI;

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
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductService service;
	
	@PostMapping
	public ResponseEntity<EntityProduct> addProduct(@RequestBody EntityProduct product){
		EntityProduct addedProduct = service.addProduct(product);
		return new ResponseEntity<>(addedProduct,HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<EntityProduct> getAllProducts(){
		return service.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EntityProduct> getProductById(@PathVariable Long id){
		EntityProduct prod = service.getProductById(id);
		return ResponseEntity.ok(prod);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateProduct(@PathVariable Long id,@RequestBody EntityProduct product){
		service.updateProduct(id,product);
		return ResponseEntity.noContent().build();
}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
		service.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}
}
