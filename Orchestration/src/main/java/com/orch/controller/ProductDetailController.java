package com.orch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orch.bean.ProductDetail;
import com.orch.service.ProductDetailsService;

@RestController
@RequestMapping("/productdetail")
public class ProductDetailController {

	@Autowired
	private ProductDetailsService productDetailsService;

	@RequestMapping(method = RequestMethod.GET)
	public List<ProductDetail> getAllProducts() {
		return productDetailsService.getAllProducts();
	}

	@RequestMapping(value = "/search/{searchType}", method = RequestMethod.GET)
	public List<ProductDetail> getSpecificProducts(
			@PathVariable("searchType") String searchType,
			@RequestParam("searchValue") String searchValue) {
		return productDetailsService.getSpecificProducts(searchType,
				searchValue);
	}

	/*
	 * @RequestMapping(method = RequestMethod.POST)
	 * 
	 * @ResponseStatus(HttpStatus.CREATED) public ProductDetail add(@RequestBody
	 * 
	 * @Valid ProductDetail productDetail) { // return
	 * repository.save(productDetail); return null; }
	 * 
	 * @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	 * 
	 * @ResponseStatus(HttpStatus.NO_CONTENT) public void
	 * remove(@PathVariable("id") String id) { // repository.delete(id); }
	 */
}
