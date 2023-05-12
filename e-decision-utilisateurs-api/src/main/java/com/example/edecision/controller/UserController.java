package com.example.edecision.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.edecision.model.Utilisateur;
import com.example.edecision.service.UtilisateurService;

@RestController
public class UserController {
	
	@Autowired
	private UtilisateurService service;

	@GetMapping(value = "/utilisateurs")
	public List<Utilisateur> getUsers() {
		List<Utilisateur> lesUtilisateurs = service.listUtilisateurs(); 
		return lesUtilisateurs;
	}
	
	//Récupération des infos d'un utilisateur
	@GetMapping("utilisateur/{numeroUtilisateur}")
	public Utilisateur getUtilisateurByNumero(@PathVariable("numeroUtilisateur") long numeroUtilisateur)
	{
		Utilisateur utilisateur = service.getUtilisateurByNumero(numeroUtilisateur);
		return utilisateur;
		
	}
	
	//Création d'un utilisateur
			@PostMapping("utilisateur")
			public String ajoutUtilisateur(@RequestBody Utilisateur unUtilisateur)
			{
				String result = service.createUtilisateur(unUtilisateur);
				return result;
			}
	
	//Suppression d'un utilisateur
	@DeleteMapping("utilisateur/{numero}")
	public String delete(@PathVariable("numero") long numero)
	{
		String result = service.delete(numero);
		return result;
	}
	

	//En commentaire première version des requetes de modification avec des path variables et avec un boolean en retour
//	@PutMapping("utilisateur/{numero}/name/{name}")
//	public Boolean modifyName(@PathVariable("numero") long numero , @PathVariable("name") String name)
//	{
//		Boolean result = service.modifyName(numero, name);
//		return result;
//	}
	
	//Nouvelle requete de modification d'un attribut d'un utilisateur en utilisant des request param et en retournant une chaine de caractère
	@PutMapping("utilisateur/{numero}")
	public String modifyName(@PathVariable("numero") long numero , @RequestParam String nom)
	{
		String result = service.modifyName(numero, nom);
		return result;
	}

}
