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

import com.example.edecision.model.Equipe;
import com.example.edecision.service.EquipeService;

@RestController
public class EquipeController {
	
	@Autowired
	private EquipeService service;

	@GetMapping(value = "/equipes")
	public List<Equipe> getEquipes() {
		List<Equipe> lesEquipes = service.listEquipes(); 
		return lesEquipes;
	}
	//Récupération des infos d'une équipe
		@GetMapping("equipe/{numeroEquipe}")
		public Equipe getEquipeByNumero(@PathVariable("numeroEquipe") int numeroEquipe)
		{
			Equipe equipe = service.getEquipeByNumero(numeroEquipe);
			return equipe;
			
		}
		
		//Création d'une équipe
		@PostMapping("equipe")
		public String ajoutEquipe(@RequestBody Equipe uneEquipe)
		{
			String result = service.createEquipe(uneEquipe);
			return result;
		}
		
		//Suppression d'une équipe
		@DeleteMapping("equipe/{numero}")
		public String delete(@PathVariable("numero") int numero)
		{
			String result = service.delete(numero);
			return result;
		}
		

		//En commentaire première version des requetes de modification avec des path variables et avec un boolean en retour
//		@PutMapping("equipe/{numero}/pv/")
//		public Boolean modifyPv(@PathVariable("numero") int numero , @PathVariable("pointDeVie") int pointDeVie)
//		{
//			Boolean result = service.modifyPv(numero, pointDeVie);
//			return result;
//		}
		
		//Nouvelle requete de modification d'un attribut d'une equipe en utilisant des request param et en retournant une chaine de caractère
		@PutMapping("equipe/{numero}")
		public String modifyName(@PathVariable("numero") int numero , @RequestParam String nom)
		{
			String result = service.modifyName(numero, nom);
			return result;
		}
		
			
			

}
