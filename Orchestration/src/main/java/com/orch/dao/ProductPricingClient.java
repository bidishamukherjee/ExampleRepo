package com.orch.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.orch.ProductUrl;
import com.pricing.entity.ProductPrice;

@Component
public class ProductPricingClient {
	@Autowired
	private RestTemplate restTemplate;

	public ProductPrice getProductPrice(String id) {
		ResponseEntity<ProductPrice> responseEntity = restTemplate.exchange(
				ProductUrl.PRODUCT_PRICE_ID_URL, HttpMethod.GET, null,
				ProductPrice.class, id);
		return responseEntity.getBody();
	}
}
