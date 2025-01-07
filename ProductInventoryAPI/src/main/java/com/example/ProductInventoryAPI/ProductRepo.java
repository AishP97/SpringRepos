package com.example.ProductInventoryAPI;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<EntityProduct, Long>{

}
