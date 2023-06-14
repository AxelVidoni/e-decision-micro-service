package com.example.edecision.model;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
	
	public Proposition getPropositionById(int id)
	{
		Proposition entity = em.find(Proposition.class, id);
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
				//Verification qu'une proposition avec la meme problématique n'a pas été soumise
				if (getPropositionByProblematique(uneProposition.getProblematique()) != null)
				{
					return "Une proposition avec cette problématique a deja été soumise";
				}
//				LocalDate test = uneProposition.getDateProposition().toInstant()
//					      .atZone(ZoneId.systemDefault())
//					      .toLocalDate();
//				test = test.minusDays(7);
//				for (Proposition uneProposition2 : getPropositionByDate(java.sql.Date.valueOf(test))) {
//					
//				}
				//Date test = uneProposition.getDateProposition().
				//Verification qu'une proposition impactant cette equipe n'a pas été soumise il y a moins de 7j
			em.persist(uneProposition);
			return "Ajout de la proposition réalisée";
		    }
		}

	//Suppression d'une proposition
	public String delete(int id) {
		Proposition entity = em.find(Proposition.class, id);
		if (entity == null) {
			return "Id inconnu, veuillez réessayez";
		}
		em.remove(entity);
		return "Suppression réalisée";
	}
	
	// méthode permettant de modifier un attribut d'une proposition ici le nom
	public String modifyEnonce(int id , String enonce)
	{
		if (enonce != null)
		{
			Proposition entity = em.find(Proposition.class, id);
		if (entity == null) {
			return "Id inconnu, veuillez réessayez";
		}
		entity.setEnonce(enonce);
		return "Modification de l'enonce effectuée";
		}
		else
		{
			return "Une proposition ne peut pas pas avoir d enonce";
		}
	}
	
	public Proposition getPropositionByProblematique(String problematique)
	{
		Proposition entity;
		try {
		 entity = em.createQuery("SELECT p FROM Propositions p WHERE p.problematique = :problematique", Proposition.class).setParameter("problematique", problematique).getSingleResult();
		}
		catch (Exception e)
		{
			entity = null;
		}
		return entity;
	}
//	public List<Proposition> getPropositionByDate(Date laDate)
//	{
//		List<Proposition> entity;
//		try {
//		 entity = em.createQuery("SELECT p FROM Propositions JOIN  p WHERE p.date_proposition = :date_proposition", Proposition.class).setParameter("date_proposition", laDate).getResultList();
//		}
//		catch (Exception e)
//		{
//			entity = null;
//		}
//		return entity;
//	}

}
