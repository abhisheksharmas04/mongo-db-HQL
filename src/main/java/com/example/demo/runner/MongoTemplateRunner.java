package com.example.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.service.IActorAssociationMgmtService;

@Component
public class MongoTemplateRunner implements CommandLineRunner {
	
	@Autowired
	private IActorAssociationMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		//------------------Insert operation---------------------------------------------------------
		//System.out.println(service.registerActor(new Actor(new Random().nextInt(40000), "Akshay Kumar","Hero",58.0f,4345678L)));
		
		////------------------bulk Insert operation---------------------------------------------------------
		/*service.registerActor((Actor) List.of(new Actor(new Random().nextInt(4000), "Sonu Sood", "Hero", 45.9f,12345L),
				new Actor(new Random().nextInt(4000), "Salam Khan", "Hero", 50.2f, 4552345L)));*/
		
		//---------------------------FIND METHOD FOR SELECT OPERATION------------------------------------------
		//service.getAllActor().forEach(System.out::println);
		//service.getActorsByCategory("Hero").forEach(System.out::println);
		//System.out.println(service.getActorByActorId(33857));
		
		//-----------------------------UPDATE METHOD-----------------------------------------------------------
		/*System.out.println(service.updateActorByActorId(33857,"Mumbai",987878323L));
		System.out.println(service.updateActorsRenumerationByCategoryAndAge("Hero",100000.0,40.0f));
		System.out.println(service.saveOrUpdateActorByRenumeration(100000.0,100000.0, "Mumbai",58f,2384934L));*/
		
		//-----------------------------Find ALL and REMOVE-----------------------------------------------------------
			System.out.println(service.removeDocumentByAge(56.0f));
				
	}

}
