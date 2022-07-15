package com.example.demo.service;

import java.util.List;

import com.example.demo.document.Actor;

public interface IActorAssociationMgmtService {
	public String registerActor(Actor actor);
	public String registerActorGroup(List<Actor>actorsGroup);
	public List<Actor>getAllActor();
	public List<Actor>getActorsByCategory(String cat);
	public Actor getActorByActorId(Integer id);
	public String updateActorByActorId(Integer id, String newAdd, Long mobileNO);
	public String updateActorsRenumerationByCategoryAndAge(String category, Double renumeration, Float age);
	public String saveOrUpdateActorByRenumeration(Double start, Double end, String newAddress, Float newAge, Long newMobileNo);
	public String removeDocumentByAge(Float age);
}
