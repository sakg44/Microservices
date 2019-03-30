package com.ecommerce.microcommerce.dao;
/*
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.microcommerce.model.Product;

//repo permette de declarer cette classe sera en comme avec la base de donne
@Repository
public class ProductDaoImpl implements ProductDao {

	public static List<Product>products=new ArrayList<>();
	static {
		products.add(new Product(1, new String("Ordinateur portable"), 350,200));
		products.add(new Product(2, new String("Aspirateur Robot"), 500,300)); 
		products.add(new Product(3, new String("Table de Ping Pong"), 750,500));
	}

	@Override
	public List<Product>findAll() {
		return products;
	}

	@Override
	public Product findById(int id) {
		for (Product product : products) {  
			if(product.getId() ==id){
				return product;
			}
		}
		return null;
	}

	@Override
	public Product save(Product product) {
		products.add(product);
		return product;
	}
}*/
