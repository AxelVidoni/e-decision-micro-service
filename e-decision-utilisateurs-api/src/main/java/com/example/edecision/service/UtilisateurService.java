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
	public Utilisateur getUtilisateurByNumero(int numeroUtilisateur)
	{
		Utilisateur unUtilisateur = this.utilisateurRepo.getUtilisateurByNumero(numeroUtilisateur);

		return unUtilisateur;
	}
	
	//Récupération de l'id d'un utilisateur par rapport à son id authentification
		public int getIdUtilisateurByNumeroAuthent(int numeroAuthentUtilisateur)
		{
			int idUtilisateur = this.utilisateurRepo.getIdUtilisateurByNumeroAuthent(numeroAuthentUtilisateur);

			return idUtilisateur;
		}
	
	//Création d'un utilisateur
			public String createUtilisateur(Utilisateur unUtilisateur)
			{
				return this.utilisateurRepo.createUtilisateur(unUtilisateur);
			}
	
	//Suppression d'un utilisateur
	public String delete(int numero) {
		return this.utilisateurRepo.delete(numero);
	}
	
	//Différentes méthodes pour modifier les attributs d'un utilisateur
	public String modifyName(int numero, String name) {
		return this.utilisateurRepo.modifyName(numero, name);
	}

}
