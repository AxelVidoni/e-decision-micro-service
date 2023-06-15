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

	//Récupération de tous les utilisateurs
	@GetMapping(value = "/utilisateurs")
	public List<Utilisateur> getUsers() {
		List<Utilisateur> lesUtilisateurs = service.listUtilisateurs(); 
		return lesUtilisateurs;
	}
	
	//Récupération des infos d'un utilisateur
	@GetMapping("utilisateur/{idUtilisateur}")
	public Utilisateur getUtilisateurById(@PathVariable("idUtilisateur") int idUtilisateur)
	{
		Utilisateur utilisateur = service.getUtilisateurById(idUtilisateur);
		return utilisateur;
		
	}
	
	//Récupération de l'id d'un utilisateur par rapport à son id authentification
		@GetMapping("utilisateur/getId/{idAuthentUtilisateur}")
		public int getIdUtilisateurByIdoAuthent(@PathVariable("idAuthentUtilisateur") int idAuthentUtilisateur)
		{
			int idUtilisateur = service.getIdUtilisateurByIdAuthent(idAuthentUtilisateur);
			return idUtilisateur;
			
		}
	
	//Création d'un utilisateur
			@PostMapping("utilisateur")
			public String ajoutUtilisateur(@RequestBody Utilisateur unUtilisateur)
			{
				String result = service.createUtilisateur(unUtilisateur);
				return result;
			}
	
	//Suppression d'un utilisateur
	@DeleteMapping("utilisateur/{id}")
	public String delete(@PathVariable("id") int id)
	{
		String result = service.delete(id);
		return result;
	}
	

	
	//Modification du nom d'un utilisateur
	@PutMapping("utilisateur/{id}")
	public String modifyName(@PathVariable("id") int id , @RequestParam String nom)
	{
		String result = service.modifyName(id, nom);
		return result;
	}

}
