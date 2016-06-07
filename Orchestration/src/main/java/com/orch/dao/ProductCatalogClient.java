package com.orch.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.catalogue.entity.Product;
import com.orch.ProductUrl;

@Component
public class ProductCatalogClient {

	@Autowired
	private RestTemplate restTemplate;

	
	public Product[] getAllProducts() {
		ResponseEntity<Product[]> responseEntity = restTemplate.exchange(
				ProductUrl.PRODUCT_URL, HttpMethod.GET, null, Product[].class);
		return responseEntity.getBody();
	}
	
	public Product[] getSpecificProducts(String searchType, String searchValue) {
		ResponseEntity<Product[]> responseEntity = restTemplate.exchange(
				ProductUrl.PRODUCT_SEARCH_URL, HttpMethod.GET, null, Product[].class, searchType, searchValue);
		return responseEntity.getBody();
	}
}
