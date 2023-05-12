package com.example.edecision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.edecision.model.Vote;
import com.example.edecision.model.VoteRepository;

@Service
public class VoteService {
	
	@Autowired
	private VoteRepository voteRepo;
	
	public List<Vote> listVotes() {
		List<Vote> lesVotes = this.voteRepo.listVotes();
		return lesVotes;
	}
	
	//Récupération de toutes les infos d'un vote
	public Vote getVoteByNumero(long numeroVote)
	{
		Vote unVote = this.voteRepo.getVoteByNumero(numeroVote);

		return unVote;
	}
	
	//Création d'un vote
			public String createVote(Vote unVote)
			{
				return this.voteRepo.createVote(unVote);
			}
	
	//Suppression d'un vote
	public String delete(long numero) {
		return this.voteRepo.delete(numero);
	}
	
	//Différentes méthodes pour modifier les attributs d'un vote
	public String modifyName(long numero, String name) {
		return this.voteRepo.modifyName(numero, name);
	}

}
