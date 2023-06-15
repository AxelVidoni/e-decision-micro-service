package com.example.edecision.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity (name = "Equipes")
@Table (name = "equipes")
public class Equipe implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	// Utilisateur manageur de l'équipe
	@Column 
	private int id_manager;
	//Utilisateur maitre de l'équipe
	@Column 
	private int id_team_master;
	//Projet auquel l'équipe est rattachée
	@Column 
	private int id_projet;
	

	@ElementCollection
	@CollectionTable(name="equipiers",
	joinColumns = @JoinColumn(name="id_equipe"))
	@Column(name = "id_utilisateur")
	private List<Integer> lesParticipants;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getIdManager() {
		return id_manager;
	}
	public void setIdManager(int id_manager) {
		this.id_manager = id_manager;
	}
	public int getIdTeamMaster() {
		return id_team_master;
	}
	public void setIdTeamMaster(int id_team_master) {
		this.id_team_master = id_team_master;
	}
	public int getIdProjet() {
		return id_projet;
	}
	public void setIdProjet(int id_projet) {
		this.id_projet = id_projet;
	}
	public List<Integer> getListeEquipier() {
		return lesParticipants;
	}

	public void setListeEquipier(List<Integer> lesParticipants) {
		this.lesParticipants = lesParticipants;
	}
	
}
