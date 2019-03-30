package com.ecommerce.microcommerce.web.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;
import com.ecommerce.microcommerce.web.exceptions.ProduitIntrouvableException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api( description="API pour es opérations CRUD sur les produits.")
@RestController
public class ProductController {

	@Autowired//hibernate va se charger d'implementer et crer l'objet
	private ProductDao productDao;
	
	@ApiOperation(value = "Récupère tous les produits qui sont en stock!")
	@RequestMapping(value="/Produits", method=RequestMethod.GET)
	public List<Product> listProduits() {
		return productDao.findAll();
	}

	@ApiOperation(value = "Récupère un produit grâce à son ID à condition que celui-ci soit en stock!")
	@GetMapping(value="/Produits/{id}")
	public Product afficheUnProduit(@PathVariable int id) {
		Product product=productDao.findById(id);
		if(product==null)
			throw new ProduitIntrouvableException("le produit dont l'id="+id +" est indisponible");
		return product;
	}


	/*@valid permet de verifier avec les contraite specifier il faut retourner responseEntity pour avoir la main sur les code
	postman faut mettre du json sur body-> raw */
	@ApiOperation(value = "Permet d'ajouter un produit dans le stock!")
	@PostMapping(value = "/Produits")
	public ResponseEntity<Void>  ajouterProduit( @Valid @RequestBody Product product) {
		productDao.save(product);
		return null;
	}
	
	@ApiOperation(value = "Permet de supprimer un produit dans le stock via son ID!")
	@DeleteMapping (value = "/Produits/{id}")
	public void supprimerProduit(@PathVariable int id) {

		productDao.deleteById(id);
	}
	
	//pour update
	@ApiOperation(value = "Permet de mettre à jour un produit dans le stock via son ID!")
	@PutMapping (value = "/Produits")
	  public void updateProduit(@RequestBody Product product) {

	      productDao.save(product);
	  }
}
