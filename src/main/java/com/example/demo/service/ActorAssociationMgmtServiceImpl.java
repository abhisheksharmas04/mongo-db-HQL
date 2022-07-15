package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.demo.document.Actor;
import com.mongodb.client.result.UpdateResult;

@Service
public class ActorAssociationMgmtServiceImpl implements IActorAssociationMgmtService{
	
	@Autowired
	private MongoTemplate template;

	@Override
	public String registerActor(Actor actor) {
		return "Document is saved with Id:: " + template.save(actor,"Artist").getActorId();
		// create the collection with the given name Artist.
	}

	@Override
	public String registerActorGroup(List<Actor> actorsGroup) {
		return template.insert(actorsGroup).size() + "No of actors are saved";
	}

	@Override
	public List<Actor> getAllActor() {
		return template.findAll(Actor.class,"Artist");
	}

	@Override
	public List<Actor> getActorsByCategory(String cat) {
		Query query = new Query();
		query.addCriteria(Criteria.where("category").is(cat));
		return template.find(query,Actor.class,"Artist");
	}

	@Override
	public Actor getActorByActorId(Integer id) {
		return template.findById(id,Actor.class,"Artist");
	}

	@Override
	public String updateActorByActorId(Integer id, String newAdd, Long mobileNO) {
		//Prepare query object for retrieving  Object
		Query query = new Query();
		query.addCriteria(Criteria.where("actorId").is(id));
		//prepare udpate object for modification
		Update update = new Update();
		update.set("actorAddr",newAdd);
		update.set("mobileNo", mobileNO);	
		// find and modifiy
		Actor actor = template.findAndModify(query, update, Actor.class,"Artist");
		return actor == null?"Actor Not Found":"Actor found and update";
	}

	@Override
	public String updateActorsRenumerationByCategoryAndAge(String category, Double renumeration, Float age) {
		//Prepare query object
		Query query = new Query().addCriteria(Criteria.where("category").is(category)
				.andOperator(Criteria.where("age").gte(age)));
		//Prepare update operation
		Update update = new Update().set("renumeration",renumeration);
		// invoke update multimethod
		UpdateResult result = template.updateMulti(query, update,Actor.class,"Artist");
		return result.getModifiedCount() + "Actors are modified";
	}

	@Override
	public String saveOrUpdateActorByRenumeration(Double start, Double end, String newAddress, Float newAge,
			Long newMobileNo) {
		// Prepare query object
		Query query = new Query().addCriteria(Criteria.where("renumeration").gte(start).
				andOperator(Criteria.where("renumeration").lte(end)));
		//prepare update object
		Update update = new Update().set("actorAddr",newAddress).set("age",newAge).set("mobileNo",newMobileNo);
		//invoke upsert() 
		UpdateResult result = template.upsert(query, update,Actor.class, "Artist");
		return result.getModifiedCount() + " are modified and inserted id:: " + result.getUpsertedId();
	}

	@Override
	public String removeDocumentByAge(Float age) {
		Query query = new Query().addCriteria(Criteria.where("age").is(age));
		Actor actor = template.findAndRemove(query, Actor.class,"Artist");
		return " document is removed"; 
	}

}
