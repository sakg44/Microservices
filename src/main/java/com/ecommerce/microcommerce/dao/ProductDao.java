package com.ecommerce.microcommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.microcommerce.model.Product;

@Repository                   //jparepo permet de faciliter les requetes
public interface ProductDao extends JpaRepository<Product, Integer> {
	public List<Product>findAll();
	public Product findById(int id);

	public List<Product> findByPrixGreaterThan(int prixLimit);
	/* public Product save(Product product);*/

}
