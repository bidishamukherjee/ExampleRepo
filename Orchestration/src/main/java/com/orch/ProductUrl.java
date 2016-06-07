package com.orch;

public interface ProductUrl {
	String PRODUCT_URL = "http://localhost:9000/catalog/product";
	String PRODUCT_ID_URL = "http://localhost:9000/catalog/product/{id}";
	String PRODUCT_SEARCH_URL = "http://localhost:9000/catalog/product/search/{searchType}?searchValue={searchValue}";

	String PRODUCT_PRICE_URL = "http://localhost:9001/productPricing/price";
	String PRODUCT_PRICE_ID_URL = "http://localhost:9001/productPricing/price/{id}";
}
