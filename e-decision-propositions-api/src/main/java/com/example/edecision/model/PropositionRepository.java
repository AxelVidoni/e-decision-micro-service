package com.example.edecision.model;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public class PropositionRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Proposition> listPropositions()
	{
		return em.createQuery("SELECT p FROM Propositions p", Proposition.class).getResultList();
	}
	
	public Proposition getPropositionByNumero(long numero)
	{
		Proposition entity = em.find(Proposition.class, numero);
		if (entity == null) {
			return null;
		}
		return entity;
	}
	
	//Création d'une proposition
		public String createProposition(Proposition uneProposition)
		{
			Proposition entity = em.find(Proposition.class, uneProposition.getId());
			if (entity != null) {
				return "Proposition deja existante";
			}
			else {
			em.persist(uneProposition);
			return "Ajout de la proposition réalisée";
		    }
		}

	//Suppression d'une proposition
	public String delete(long numero) {
		Proposition entity = em.find(Proposition.class, numero);
		if (entity == null) {
			return "Numéro inconnu, veuillez réessayez";
		}
		em.remove(entity);
		return "Suppression réalisée";
	}
	
	// méthode permettant de modifier un attribut d'une proposition ici le nom
	public String modifyName(long numero , String name)
	{
		if (name != null)
		{
			Proposition entity = em.find(Proposition.class, numero);
		if (entity == null) {
			return "Numéro inconnu, veuillez réessayez";
		}
		entity.setName(name);
		return "Modification du nom effectuée";
		}
		else
		{
			return "Une proposition ne peut pas pas avoir de nom";
		}
	}

}
