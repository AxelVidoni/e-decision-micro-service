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

import com.example.edecision.model.Vote;
import com.example.edecision.service.VoteService;

@RestController
public class VoteController {
	
	@Autowired
	private VoteService service;

	@GetMapping(value = "/votes")
	public List<Vote> getVotes() {
		List<Vote> lesVotes = service.listVotes(); 
		return lesVotes;
	}
	
	//Récupération des infos d'un vote
	@GetMapping("vote/{numeroVote}")
	public Vote getVoteByNumero(@PathVariable("numeroVote") long numeroVote)
	{
		Vote vote = service.getVoteByNumero(numeroVote);
		return vote;
		
	}
	
	//Création d'un VOTE
			@PostMapping("vote")
			public String ajoutVote(@RequestBody Vote unVote)
			{
				String result = service.createVote(unVote);
				return result;
			}
	
	//Suppression d'un vote
	@DeleteMapping("vote/{numero}")
	public String delete(@PathVariable("numero") long numero)
	{
		String result = service.delete(numero);
		return result;
	}
	

	//En commentaire première version des requetes de modification avec des path variables et avec un boolean en retour
//	@PutMapping("vote/{numero}/name/{name}")
//	public Boolean modifyName(@PathVariable("numero") long numero , @PathVariable("name") String name)
//	{
//		Boolean result = service.modifyName(numero, name);
//		return result;
//	}
	
	//Nouvelle requete de modification d'un attribut d'un vote en utilisant des request param et en retournant une chaine de caractère
	@PutMapping("vote/{numero}")
	public String modifyName(@PathVariable("numero") long numero , @RequestParam String nom)
	{
		String result = service.modifyName(numero, nom);
		return result;
	}

}
