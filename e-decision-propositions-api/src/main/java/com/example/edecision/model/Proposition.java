package com.example.edecision.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity (name = "Propositions")
@Table (name = "propositions")
public class Proposition implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Column
    private String enonce;
    @Column
    private String problematique;
    @Column
    private String resolution;
    //Boolean pour savoir si c'est une proposition bloquante pour un projet
    @Column
    private Boolean block_project;
    //Date de création de la proposition
    @Column
    @Temporal(TemporalType.DATE)
    private Date date_proposition;
    //Boolean pour savoir si la proposition a été accepté
    @Column(nullable = true)
    private Boolean accepted = null;
    //Permet de savoir combien de semaine cette proposition va être débattu
    @Column
    private int nbr_semaine_debat;
    
    //Liste des utilisateurs porteurs de la proposition
    @ElementCollection
    @CollectionTable(name="porteurs",
    joinColumns = @JoinColumn(name="id_proposition"))
    @Column(name = "id_utilisateur")
    private List<Integer> lesPorteurs;
    
    //Liste des utilisateurs soutiens de la proposition
    @ElementCollection
    @CollectionTable(name="soutiens",
    joinColumns = @JoinColumn(name="id_proposition"))
    @Column(name = "id_utilisateur")
    private List<Integer> lesSoutiens;
    
    //Liste des équipes impactées par la proposition
    @ElementCollection
    @CollectionTable(name="impactees",
    joinColumns =  @JoinColumn(name="id_proposition"))
    @Column(name = "id_equipe")
    private List<Integer> lesImpactees;

    //Proposition escaladée ou amendée
    @ManyToOne
    @JoinColumn(name = "id_proposal", referencedColumnName = "id", nullable = true)
    private Proposition proposal = null;
	
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getEnonce() {
        return enonce;
    }
    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }
    public String getProblematique() {
        return problematique;
    }
    public void setProblematique(String problematique) {
        this.problematique = problematique;
    }
    public String getResolution() {
        return resolution;
    }
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
    public Boolean getBlockProject() {
        return block_project;
    }
    public void setBlockProject(Boolean block_project) {
        this.block_project = block_project;
    }
    public Date getDateProposition() {
        return date_proposition;
    }
    public void setDateProposition(Date date_proposition) {
        this.date_proposition = date_proposition;
    }
    public Boolean getAccepted() {
        return accepted;
    }
    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }
    public int getNbrSemaineDebat() {
        return nbr_semaine_debat;
    }
    public void setNbrSemaineDebat(int nbr_semaine_debat) {
        this.nbr_semaine_debat = nbr_semaine_debat;
    }
    public List<Integer> getListePorteur() {
        return lesPorteurs;
    }

    public void setListePorteur(List<Integer> lesPorteurs) {
        this.lesPorteurs = lesPorteurs;
    }
    public List<Integer> getListeSoutien() {
        return lesSoutiens;
    }

    public void setListeSoutien(List<Integer> lesSoutiens) {
        this.lesSoutiens = lesSoutiens;
    }
    public List<Integer> getListeImpactees() {
        return lesImpactees;
    }

    public void setListeImpactees(List<Integer> lesImpactees) {
        this.lesImpactees = lesImpactees;
    }
    public Proposition getProposal() {
        return proposal;
    }

    public void setProposal(Proposition proposal) {
        this.proposal = proposal;
    }
	
}
