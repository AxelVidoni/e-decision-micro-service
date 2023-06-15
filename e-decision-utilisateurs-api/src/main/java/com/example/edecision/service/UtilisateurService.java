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
	
	//Récupération de tous les utilisateurs
	public List<Utilisateur> listUtilisateurs() {
		List<Utilisateur> lesUtilisateurs = this.utilisateurRepo.listUtilisateurs();
		return lesUtilisateurs;
	}
	
	//Récupération de toutes les infos d'un utilisateur
	public Utilisateur getUtilisateurById(int idUtilisateur)
	{
		Utilisateur unUtilisateur = this.utilisateurRepo.getUtilisateurById(idUtilisateur);

		return unUtilisateur;
	}
	
	//Récupération de l'id d'un utilisateur par rapport à son id authentification
		public int getIdUtilisateurByIdAuthent(int idAuthentUtilisateur)
		{
			int idUtilisateur = this.utilisateurRepo.getIdUtilisateurByIdAuthent(idAuthentUtilisateur);

			return idUtilisateur;
		}
	
	//Création d'un utilisateur
			public String createUtilisateur(Utilisateur unUtilisateur)
			{
				return this.utilisateurRepo.createUtilisateur(unUtilisateur);
			}
	
	//Suppression d'un utilisateur
	public String delete(int id) {
		return this.utilisateurRepo.delete(id);
	}
	
	//Différentes méthodes pour modifier les attributs d'un utilisateur
	public String modifyName(int id, String name) {
		return this.utilisateurRepo.modifyName(id, name);
	}

}
