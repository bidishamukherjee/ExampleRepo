package com.catalogue.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.catalogue.entity.Product;

public interface ProductDAO extends CrudRepository<Product, String> {

	List<Product> findByTypeIgnoreCase(String type);
	
	List<Product> findByBrandLikeIgnoreCase(String brand);	
	
}
