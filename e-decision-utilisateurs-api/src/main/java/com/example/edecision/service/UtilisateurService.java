package com.example.edecision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.edecision.model.Utilisateur;
import com.example.edecision.model.UtilisateurRepository;

@Service
public class UtilisateurService {
	
	@Autowired
	private UtilisateurRepository utilisateurRepo;
	
	public List<Utilisateur> listUtilisateurs() {
		List<Utilisateur> lesUtilisateurs = this.utilisateurRepo.listUtilisateurs();
		return lesUtilisateurs;
	}
	
	//Récupération de toutes les infos d'un utilisateur
	public Utilisateur getUtilisateurByNumero(long numeroUtilisateur)
	{
		Utilisateur unUtilisateur = this.utilisateurRepo.getUtilisateurByNumero(numeroUtilisateur);

		return unUtilisateur;
	}
	
	//Création d'un utilisateur
			public String createUtilisateur(Utilisateur unUtilisateur)
			{
				return this.utilisateurRepo.createUtilisateur(unUtilisateur);
			}
	
	//Suppression d'un utilisateur
	public String delete(long numero) {
		return this.utilisateurRepo.delete(numero);
	}
	
	//Différentes méthodes pour modifier les attributs d'un utilisateur
	public String modifyName(long numero, String name) {
		return this.utilisateurRepo.modifyName(numero, name);
	}

}
