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
	public Proposition getPropositionByNumero(long numeroProjet)
	{
		Proposition uneProposition = this.propositionRepo.getPropositionByNumero(numeroProjet);

		return uneProposition;
	}
	
	//Création d'une proposition
			public String createProposition(Proposition uneProposition)
			{
				return this.propositionRepo.createProposition(uneProposition);
			}
	
	//Suppression d'une proposition
	public String delete(long numero) {
		return this.propositionRepo.delete(numero);
	}
	
	//Différentes méthodes pour modifier les attributs d'une proposition
	public String modifyName(long numero, String name) {
		return this.propositionRepo.modifyName(numero, name);
	}

}
