package com.catalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.catalogue.dao.ProductDAO;
import com.catalogue.entity.Product;

@SpringBootApplication
@EnableWebMvc
@EntityScan(basePackages="com.catalogue.entity")

public class CatalogApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CatalogApplication.class, args);
		ProductDAO productDAO=(ProductDAO)context.getBean("productDAO");
		productDAO.save(new Product("101", "head first java", "oreily", "book"));
		productDAO.save(new Product("102", "head first servlet jsp", "oreily", "book"));
		productDAO.save(new Product("103", "head first sql", "oreily", "book"));
		productDAO.save(new Product("104", "bat", "rbk", "sports"));
		productDAO.save(new Product("105", "football", "nike", "sports"));
		
		
		
	}
}
