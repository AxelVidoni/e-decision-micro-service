package com.example.edecision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.edecision.model.Proposition;
import com.example.edecision.model.PropositionRepository;

@Service
public class PropositionService {
	
	@Autowired
	private PropositionRepository propositionRepo;
	
	public List<Proposition> listPropositions() {
		List<Proposition> lesPropositions = this.propositionRepo.listPropositions();
		return lesPropositions;
	}
	
	//Récupération de toutes les infos d'une proposition
	public Proposition getPropositionById(int idProjet)
	{
		Proposition uneProposition = this.propositionRepo.getPropositionById(idProjet);

		return uneProposition;
	}
	
	//Création d'une proposition
			public String createProposition(Proposition uneProposition)
			{
				return this.propositionRepo.createProposition(uneProposition);
			}
	
	//Suppression d'une proposition
	public String delete(int id) {
		return this.propositionRepo.delete(id);
	}
	
	//Différentes méthodes pour modifier les attributs d'une proposition
	public String modifyEnonce(int id, String enonce) {
		return this.propositionRepo.modifyEnonce(id, enonce);
	}

}
