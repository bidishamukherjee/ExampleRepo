package com.pricing.dao;

import org.springframework.data.repository.CrudRepository;

import com.pricing.entity.ProductPrice;



public interface PricingDAO extends CrudRepository<ProductPrice, String> {

	
}
