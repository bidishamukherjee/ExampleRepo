package com.pricing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class ProductPrice {

	@Id
	private String productId;
	private Double price;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ProductPrice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductPrice(String productId, Double price) {
		super();
		this.productId = productId;
		this.price = price;
	}

}
