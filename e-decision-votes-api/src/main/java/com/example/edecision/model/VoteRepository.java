package com.example.edecision.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class VoteRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Vote> listVotes()
	{
		return em.createQuery("SELECT v FROM Votes v", Vote.class).getResultList();
	}
	
	public Vote getVoteByNumero(long numero)
	{
		Vote entity = em.find(Vote.class, numero);
		if (entity == null) {
			return null;
		}
		return entity;
	}
	
	//Création d'un vote
		public String createVote(Vote unVote)
		{
			Vote entity = em.find(Vote.class, unVote.getId());
			if (entity != null) {
				return "Vote deja existant";
			}
			else {
			em.persist(unVote);
			return "Ajout du vote réalisé";
		    }
		}

	//Suppression d'un projet
	public String delete(long numero) {
		Vote entity = em.find(Vote.class, numero);
		if (entity == null) {
			return "Numéro inconnu, veuillez réessayez";
		}
		em.remove(entity);
		return "Suppression réalisée";
	}
	
	// méthode permettant de modifier un attribut du projet ici le nom
	public String modifyName(long numero , String name)
	{
		if (name != null)
		{
			Vote entity = em.find(Vote.class, numero);
		if (entity == null) {
			return "Numéro inconnu, veuillez réessayez";
		}
		entity.setName(name);
		return "Modification du nom effectuée";
		}
		else
		{
			return "Un vote ne peut pas pas avoir de nom";
		}
	}

}
