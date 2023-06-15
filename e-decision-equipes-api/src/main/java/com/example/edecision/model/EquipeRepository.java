package com.example.edecision.model;

import java.util.ArrayList;
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
	
	//Récupération de toutes les équipes
	public List<Equipe> listEquipes()
	{
		return em.createQuery("SELECT e FROM Equipes e", Equipe.class).getResultList();
	}
	
	//Récupération d'une équipe en fonction de son id
	public Equipe getEquipeById(int id)
	{
		Equipe entity = em.find(Equipe.class, id);
		if (entity == null) {
			return null;
		}
		return entity;
	}
	
	//Création d'une équipe
	public String createEquipe(EquipeSimple uneEquipeS)
	{
		Equipe entity = em.find(Equipe.class, uneEquipeS.getId());
		if (entity != null) {
			return "Equipe deja existante";
		}
		else {
		//Transformation de l'équipe simple (sans equipier) en une equipe
		//avec pour seul coéquipier le créateur
		Equipe uneEquipe = new Equipe();
		uneEquipe.setName(uneEquipeS.getName());
		uneEquipe.setIdManager(uneEquipeS.getIdManager());
		uneEquipe.setIdProjet(uneEquipeS.getIdProjet());
		uneEquipe.setIdTeamMaster(uneEquipeS.getIdTeamMaster());
		List<Integer> lesCoequipiers = new ArrayList<Integer>();
		lesCoequipiers.add(uneEquipeS.getIdTeamMaster());
		uneEquipe.setListeEquipier(lesCoequipiers);
		em.persist(uneEquipe);
		return "Ajout de l'équipe réalisée";
	    }
	}

	//Suppression d'une équipe
	public String delete(int id) {
		Equipe entity = em.find(Equipe.class, id);
		if (entity == null) {
			return "Id inconnu, veuillez réessayez";
		}
		em.remove(entity);
		return "Suppression réalisée";
	}
	
	// Ajout des coéquipiers à l'équipe
	public String addEquipier(int id , List<Integer> lesCoequipiers)
	{
		if (lesCoequipiers != null)
		{
			Equipe entity = em.find(Equipe.class, id);
		if (entity == null) {
			return "Id inconnu, veuillez réessayez";
		}
		entity.setListeEquipier(lesCoequipiers);
		return "Ajout des coéquipiers effectués";
		}
		else
		{
			return "La liste de coéquipier est vide";
		}
	}

}
