package com.example.edecision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.edecision.model.Projet;
import com.example.edecision.model.ProjetRepository;

@Service
public class ProjetService {
	
	@Autowired
	private ProjetRepository projetRepo;
	
	public List<Projet> listProjets() {
		List<Projet> lesProjets = this.projetRepo.listProjets();
		return lesProjets;
	}
	
	//Récupération de toutes les infos d'un projet
			public Projet getProjetById(int idProjet)
			{
				Projet unProjet = this.projetRepo.getProjetById(idProjet);

				return unProjet;
			}
			
			//Création d'un projet
			public String createProjet(Projet unProjet)
			{
				return this.projetRepo.createProjet(unProjet);
			}
			
			//Suppression d'un projet
			public String delete(int id) {
				return this.projetRepo.delete(id);
			}
			
			//Différentes méthodes pour modifier les attributs d'un projet
			public String modifyName(long numero, String name) {
				return this.projetRepo.modifyName(numero, name);
			}

}
