package com.example.edecision.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ProjetRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	//Récupération de tous les projets
	public List<Projet> listProjets()
	{
		return em.createQuery("SELECT p FROM Projets p", Projet.class).getResultList();
	}
	
	//Récupération du projet en fonction de son id
	public Projet getProjetById(int id)
	{
		Projet entity = em.find(Projet.class, id);
		if (entity == null) {
			return null;
		}
		return entity;
	}
	
	//Création d'un projet
		public String createProjet(Projet unProjet)
		{
			Projet entity = em.find(Projet.class, unProjet.getId());
			if (entity != null) {
				return "Projet deja existant";
			}
			else {
			em.persist(unProjet);
			return "Ajout du projet réalisé";
		    }
		}

	//Suppression d'un projet
	public String delete(int id) {
		Projet entity = em.find(Projet.class, id);
		if (entity == null) {
			return "Id inconnu, veuillez réessayez";
		}
		em.remove(entity);
		return "Suppression réalisée";
	}
	
	// méthode permettant de modifier un attribut du projet 
	public String modifyName(int id , String name)
	{
		if (name != null)
		{
			Projet entity = em.find(Projet.class, id);
		if (entity == null) {
			return "Id inconnu, veuillez réessayez";
		}
		entity.setName(name);
		return "Modification du nom effectuée";
		}
		else
		{
			return "Un projet ne peut pas, ne pas avoir de nom";
		}
	}

}
