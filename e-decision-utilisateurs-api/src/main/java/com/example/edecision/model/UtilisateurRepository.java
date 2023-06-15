package com.example.edecision.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UtilisateurRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	//Récupération de tous les utilisateurs
	public List<Utilisateur> listUtilisateurs()
	{
		return em.createQuery("SELECT v FROM Utilisateurs v", Utilisateur.class).getResultList();
	}
	
	//Récupération d'un utilisateur en fonction de son id
	public Utilisateur getUtilisateurById(int id)
	{
		Utilisateur entity = em.find(Utilisateur.class, id);
		if (entity == null) {
			return null;
		}
		return entity;
	}
	
	//Récupération de l'id d'un utilisateur en fonction de son id authentification
	public int getIdUtilisateurByIdAuthent(int idAuthentUtilisateur)
	{
		Utilisateur entity;
		int idUtilisateur = -1;
		try {
		 entity = em.createQuery("SELECT p FROM Utilisateurs p WHERE p.id_authentification = :idAuthentUtilisateur", Utilisateur.class).setParameter("idAuthentUtilisateur", idAuthentUtilisateur).getSingleResult();
		 idUtilisateur = entity.getId();
		}
		catch (Exception e)
		{
			entity = null;
		}
		return idUtilisateur;
	}
	
	//Création d'un utilisateur
		public String createUtilisateur(Utilisateur unUtilisateur)
		{
			Utilisateur entity = em.find(Utilisateur.class, unUtilisateur.getId());
			if (entity != null) {
				return "Utilisateur deja existant";
			}
			else {
			em.persist(unUtilisateur);
			return "Ajout de l'Utilisateur réalisé";
		    }
		}

	//Suppression d'un utilisateur
	public String delete(int id) {
		Utilisateur entity = em.find(Utilisateur.class, id);
		if (entity == null) {
			return "Id inconnu, veuillez réessayez";
		}
		em.remove(entity);
		return "Suppression réalisée " + entity.getId();
	}
	
	// Modification du nom de l'utilisateur
	public String modifyName(int id , String name)
	{
		if (name != null)
		{
			Utilisateur entity = em.find(Utilisateur.class, id);
		if (entity == null) {
			return "Id inconnu, veuillez réessayez";
		}
		entity.setNom(name);
		return "Modification du nom effectuée";
		}
		else
		{
			return "Un utilisateur ne peut pas, ne pas avoir de nom";
		}
	}

}