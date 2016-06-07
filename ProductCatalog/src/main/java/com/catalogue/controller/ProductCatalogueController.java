package com.catalogue.controller;

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

import com.catalogue.SearchTypeEnum;
import com.catalogue.dao.ProductDAO;
import com.catalogue.entity.Product;

@RestController
@RequestMapping("/product")
public class ProductCatalogueController {

	@Autowired
	private ProductDAO repository;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Product> getAllProducts() {
		return repository.findAll();
	}

	@RequestMapping(value = "/search/{searchType}", method = RequestMethod.GET)
	public Iterable<Product> getSpecificProducts(
			@PathVariable("searchType") String searchType,
			@RequestParam("searchValue") String searchValue) {
		Iterable<Product> productList = null;
		if (SearchTypeEnum.BRAND.equals(SearchTypeEnum.valueOf(searchType))) {
			productList = repository.findByBrandLikeIgnoreCase(searchValue);
		} else if (SearchTypeEnum.TYPE.equals(SearchTypeEnum
				.valueOf(searchType))) {
			productList = repository.findByTypeIgnoreCase(searchValue);
		}
		return productList;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Product add(@RequestBody @Valid Product product) {
		return repository.save(product);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable("id") String id) {
		repository.delete(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Product getById(@PathVariable("id") String id) {
		return repository.findOne(id);
	}
}
