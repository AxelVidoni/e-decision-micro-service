package com.example.edecision.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.edecision.model.Proposition;
import com.example.edecision.service.PropositionService;

@RestController
public class PropositionController {
	
	@Autowired
	private PropositionService service;

	//Récupération de toutes les propositions
	@GetMapping(value = "/propositions")
	public List<Proposition> getPropositions() {
		List<Proposition> lesPropositions = service.listPropositions(); 
		return lesPropositions;
	}
	
	//Récupération des infos d'une proposition
	@GetMapping("proposition/{idProposition}")
	public Proposition getPropositionById(@PathVariable("idProposition") int idProposition)
	{
		Proposition proposition = service.getPropositionById(idProposition);
		return proposition;
		
	}
	
	//Création d'une proposition
			@PostMapping("proposition")
			public String ajoutProposition(@RequestBody Proposition uneProposition)
			{
				String result = service.createProposition(uneProposition);
				return result;
			}
	
	//Suppression d'une proposition
	@DeleteMapping("proposition/{id}")
	public String delete(@PathVariable("id") int id)
	{
		String result = service.delete(id);
		return result;
	}
	

	
	//Nouvelle requete de modification d'un attribut d'une proposition 
	@PutMapping("proposition/{id}")
	public String modifyName(@PathVariable("id") int id , @RequestParam String enonce)
	{
		String result = service.modifyEnonce(id, enonce);
		return result;
	}

}
