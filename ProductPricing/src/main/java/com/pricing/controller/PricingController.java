package com.pricing.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pricing.dao.PricingDAO;
import com.pricing.entity.ProductPrice;

@RestController
@RequestMapping("/price")
public class PricingController {

	@Autowired
	private PricingDAO repository;

	@RequestMapping(value = "{productId}", method = RequestMethod.GET)
	public ProductPrice getPriceByProductId(
			@PathVariable("productId") String productId) {
		return repository.findOne(productId);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addProductPrice(@RequestBody @Valid ProductPrice productPrice) {
		repository.save(productPrice);

	}

}
