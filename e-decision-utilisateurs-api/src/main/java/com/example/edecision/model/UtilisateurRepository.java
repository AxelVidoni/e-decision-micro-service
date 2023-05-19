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
	
	public List<Utilisateur> listUtilisateurs()
	{
		return em.createQuery("SELECT v FROM Utilisateurs v", Utilisateur.class).getResultList();
	}
	
	public Utilisateur getUtilisateurByNumero(int numero)
	{
		Utilisateur entity = em.find(Utilisateur.class, numero);
		if (entity == null) {
			return null;
		}
		return entity;
	}
	
	public int getIdUtilisateurByNumeroAuthent(int numeroAuthentUtilisateur)
	{
		Utilisateur entity;
		int idUtilisateur = -1;
		try {
		 entity = em.createQuery("SELECT p FROM Utilisateurs p WHERE p.id_authentification = :numeroAuthentUtilisateur", Utilisateur.class).setParameter("numeroAuthentUtilisateur", numeroAuthentUtilisateur).getSingleResult();
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
	public String delete(int numero) {
		Utilisateur entity = em.find(Utilisateur.class, numero);
		if (entity == null) {
			return "Numéro inconnu, veuillez réessayez";
		}
		em.remove(entity);
		return "Suppression réalisée " + entity.getId();
	}
	
	// méthode permettant de modifier un attribut de l'utilisateur ici le nom
	public String modifyName(int numero , String name)
	{
		if (name != null)
		{
			Utilisateur entity = em.find(Utilisateur.class, numero);
		if (entity == null) {
			return "Numéro inconnu, veuillez réessayez";
		}
		entity.setNom(name);
		return "Modification du nom effectuée";
		}
		else
		{
			return "Un utilisateur ne peut pas pas avoir de nom";
		}
	}

}