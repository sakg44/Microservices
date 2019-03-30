package com.ecommerce.microcommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value= {"id","prixDachat"})
public class Product {
	@Id
	@GeneratedValue
	private int id;
	
	@Length(min=3, max=20,message = "Nom trop long ou trop court")
    private String nom;
	
	@Min(value=1)
    private int prix;
	
	private int prixDachat;
    
    
    
	public Product() {
		super();
	}



	public Product(int id, @Length(min = 3, max = 20, message = "Nom trop long ou trop court") String nom,
			@Min(1) int prix, int prixDachat) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.prixDachat = prixDachat;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public int getPrix() {
		return prix;
	}



	public void setPrix(int prix) {
		this.prix = prix;
	}



	public int getPrixDachat() {
		return prixDachat;
	}



	public void setPrixDachat(int prixDachat) {
		this.prixDachat = prixDachat;
	}


    
    
    

}
