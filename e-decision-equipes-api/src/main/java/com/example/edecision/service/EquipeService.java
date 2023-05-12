package com.example.edecision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.edecision.model.Equipe;
import com.example.edecision.model.EquipeRepository;

@Service
public class EquipeService {
	
	@Autowired
	private EquipeRepository equipeRepo;
	
	public List<Equipe> listEquipes() {
		List<Equipe> lesEquipes = this.equipeRepo.listEquipes();
		return lesEquipes;
	}
	//Récupération de toutes les infos d'une equipe
		public Equipe getEquipeByNumero(int numeroEquipe)
		{
			Equipe uneEquipe = this.equipeRepo.getEquipeByNumero(numeroEquipe);

			return uneEquipe;
		}
		
		//Création d'une équipe
		public String createEquipe(Equipe uneEquipe)
		{
			return this.equipeRepo.createEquipe(uneEquipe);
		}
		
		//Suppression d'une equipe
		public String delete(int numero) {
			return this.equipeRepo.delete(numero);
		}
		
		//Différentes méthodes pour modifier les attributs d'une equipe
		public String modifyName(int numero, String name) {
			return this.equipeRepo.modifyName(numero, name);
		}

}
