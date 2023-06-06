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

import com.example.edecision.model.Projet;
import com.example.edecision.service.ProjetService;


@RestController
public class ProjetController {
	
	@Autowired
	private ProjetService service;

	@GetMapping(value = "/projets")
	public List<Projet> getProjets() {
		List<Projet> lesProjets = service.listProjets(); 
		return lesProjets;
	}
	
	//Récupération des infos d'un projet
			@GetMapping("projet/{id}")
			public Projet getProjetById(@PathVariable("id") int id)
			{
				Projet projet = service.getProjetById(id);
				return projet;
				
			}
			
			//Création d'un projet
			@PostMapping("projet")
			public String ajoutProjet(@RequestBody Projet unProjet)
			{
				String result = service.createProjet(unProjet);
				return result;
			}
			
			//Suppression d'un projet
			@DeleteMapping("projet/{id}")
			public String delete(@PathVariable("id") int id)
			{
				String result = service.delete(id);
				return result;
			}
			

			//En commentaire première version des requetes de modification avec des path variables et avec un boolean en retour
//			@PutMapping("projet/{numero}/name/{name}")
//			public Boolean modifyName(@PathVariable("numero") long numero , @PathVariable("name") String name)
//			{
//				Boolean result = service.modifyName(numero, name);
//				return result;
//			}
			
			//Nouvelle requete de modification d'un attribut d'un projet en utilisant des request param et en retournant une chaine de caractère
//			@PutMapping("projet/{numero}")
//			public String modifyName(@PathVariable("numero") long numero , @RequestParam String nom)
//			{
//				String result = service.modifyName(numero, nom);
//				return result;
//			}

}
