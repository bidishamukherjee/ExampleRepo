package com.pricing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.pricing.dao.PricingDAO;
import com.pricing.entity.ProductPrice;

@SpringBootApplication
@EnableWebMvc
@EntityScan(basePackages = "com.pricing.entity")
public class PricingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(
				PricingApplication.class, args);
		PricingDAO pricingDAO = (PricingDAO) context.getBean("pricingDAO");

		pricingDAO.save(new ProductPrice("101", 2000d));
		pricingDAO.save(new ProductPrice("102", 1500d));
		pricingDAO.save(new ProductPrice("103", 1700d));
		pricingDAO.save(new ProductPrice("104", 2500d));
		pricingDAO.save(new ProductPrice("105", 1500d));

	}
}
