package com.example.edecision.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.edecision.model.Equipe;
import com.example.edecision.model.EquipeSimple;
import com.example.edecision.service.EquipeService;

@RestController
public class EquipeController {
	
	@Autowired
	private EquipeService service;

	//Récupération de toutes les équipes
	@GetMapping(value = "/equipes")
	public List<Equipe> getEquipes() {
		List<Equipe> lesEquipes = service.listEquipes(); 
		return lesEquipes;
	}
	//Récupération des infos d'une équipe
		@GetMapping("equipe/{idEquipe}")
		public Equipe getEquipeById(@PathVariable("idEquipe") int idEquipe)
		{
			Equipe equipe = service.getEquipeById(idEquipe);
			return equipe;
			
		}
		
		//Création d'une équipe
		@PostMapping("equipe")
		public String ajoutEquipe(@RequestBody EquipeSimple uneEquipe)
		{
			String result = service.createEquipe(uneEquipe);
			return result;
		}
		
		//Suppression d'une équipe
		@DeleteMapping("equipe/{id}")
		public String delete(@PathVariable("id") int id)
		{
			String result = service.delete(id);
			return result;
		}
		
		
		//Ajout des équipiers à l'équipe
		@PutMapping("equipe/{id}")
		public String addEquipier(@PathVariable("id") int id , @RequestBody List<Integer> lesCoequipiers)
		{
			String result = service.addEquipier(id, lesCoequipiers);
			return result;
		}
		
			
			

}
