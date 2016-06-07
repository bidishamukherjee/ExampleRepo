package com.catalogue.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Product {

	@Id
	private String productId;
	@NotEmpty(message="product can not be empty")
	private String productName;
	private String brand;
	private String type;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Product(String productId, String productName, String brand,
			String type) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.brand = brand;
		this.type = type;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

}
