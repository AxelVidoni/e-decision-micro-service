package com.example.edecision.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity (name = "Utilisateurs")
@Table (name = "utilisateurs")
public class Utilisateur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private String adresse_mail;
	//Id correspondant à son login + mdp
	@Column
	private int id_authentification;
	
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresseMail() {
		return adresse_mail;
	}
	public void setAdresseMail(String adresse_mail) {
		this.adresse_mail = adresse_mail;
	}
	public int getIdAuthentification() {
		return id_authentification;
	}
	public void setIdAuthentification(int id_authentification) {
		this.id_authentification = id_authentification;
	}
	
}