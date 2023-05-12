package com.example.edecision.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class EquipeRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Equipe> listEquipes()
	{
		return em.createQuery("SELECT e FROM Equipes e", Equipe.class).getResultList();
	}
	
	public Equipe getEquipeByNumero(int numero)
	{
		Equipe entity = em.find(Equipe.class, numero);
		if (entity == null) {
			return null;
		}
		return entity;
	}
	
	//Création d'une équipe
	public String createEquipe(Equipe uneEquipe)
	{
		Equipe entity = em.find(Equipe.class, uneEquipe.getId());
		if (entity != null) {
			return "Equipe deja existante";
		}
		else {
		em.persist(uneEquipe);
		return "Ajout de l'équipe réalisée";
	    }
	}

	//Suppression d'une equipe
	public String delete(int numero) {
		Equipe entity = em.find(Equipe.class, numero);
		if (entity == null) {
			return "Numéro inconnu, veuillez réessayez";
		}
		em.remove(entity);
		return "Suppression réalisée";
	}
	
	// méthode permettant de modifier un attribut de l'équipe ici le nom
	public String modifyName(int numero , String name)
	{
		if (name != null)
		{
			Equipe entity = em.find(Equipe.class, numero);
		if (entity == null) {
			return "Numéro inconnu, veuillez réessayez";
		}
		entity.setName(name);
		return "Modification du nom effectuée";
		}
		else
		{
			return "Une équipe ne peut pas pas avoir de nom";
		}
	}

}
