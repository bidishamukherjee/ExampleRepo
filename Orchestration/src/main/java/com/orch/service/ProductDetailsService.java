package com.orch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalogue.entity.Product;
import com.orch.bean.ProductDetail;
import com.orch.dao.ProductCatalogClient;
import com.orch.dao.ProductPricingClient;
import com.pricing.entity.ProductPrice;

@Service
public class ProductDetailsService {

	@Autowired
	private ProductPricingClient pricingClient;

	@Autowired
	private ProductCatalogClient productCatalogClient;

	public List<ProductDetail> getAllProducts() {
		List<ProductDetail> productDetails = new ArrayList<>();
		Product[] allProducts = productCatalogClient.getAllProducts();
		for (Product product : allProducts) {
			productDetails.add(mapNewProductDetail(product,
					pricingClient.getProductPrice(product.getProductId())));
		}
		return productDetails;
	}

	private ProductDetail mapNewProductDetail(final Product product,
			final ProductPrice productPrice) {
		ProductDetail productDetail = new ProductDetail();
		productDetail.setProductId(product.getProductId());
		productDetail.setProductName(product.getProductName());
		productDetail.setBrand(product.getBrand());
		productDetail.setType(product.getType());
		productDetail.setPrice(productPrice.getPrice());

		return productDetail;

	}

	public List<ProductDetail> getSpecificProducts(String searchType,
			String searchValue) {
		List<ProductDetail> productDetails = new ArrayList<>();
		for (Product product : productCatalogClient.getSpecificProducts(
				searchType, searchValue)) {
			productDetails.add(mapNewProductDetail(product,
					pricingClient.getProductPrice(product.getProductId())));
		}
		return productDetails;
	}
}
