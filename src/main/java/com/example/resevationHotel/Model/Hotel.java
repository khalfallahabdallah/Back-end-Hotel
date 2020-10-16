package com.example.resevationHotel.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    String nom;
    @NotNull
    String adresse;
    @NotNull
    String ville;
    @NotNull
    String numbetoile;
    @NotNull
    String telp;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getNumbetoile() {
		return numbetoile;
	}
	public void setNumbetoile(String numbetoile) {
		this.numbetoile = numbetoile;
	}
	public String getTelp() {
		return telp;
	}
	public void setTelp(String telp) {
		this.telp = telp;
	}

	
    

}
