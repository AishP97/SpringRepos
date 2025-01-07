package com.example.ProductInventoryAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	ProductRepo productrepo;
	
	public EntityProduct addProduct(EntityProduct product) {
	return productrepo.save(product);
	}
	
	public List<EntityProduct> getAllProducts(){
		return productrepo.findAll();
	}
	
	public EntityProduct getProductById(Long id) {
		return productrepo.findById(id).orElseThrow();
	}
	
	public void deleteProduct(Long id) {
		EntityProduct prod = productrepo.findById(id).orElseThrow();
		
		productrepo.deleteById(id);
		productrepo.save(prod);
	}
	
	public void updateProduct(Long id,EntityProduct product) {
		EntityProduct pro = productrepo.findById(id).orElseThrow();
		
		pro.setCategory(product.getCategory());
		pro.setProductName(product.getProductName());
		pro.setPrice(product.getPrice());
		pro.setQuantity(product.getQuantity());
		
		productrepo.save(pro);
	}
}
