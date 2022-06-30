package com.Qlik.project.palindrome.palindromeservice.service;

import org.springframework.data.repository.CrudRepository;

import com.Qlik.project.palindrome.palindromeservice.service.model.Message;

/* CrudRepository is a Spring Data interface for generic CRUD operations 
   on a repository of a specific type
   Here we specify the entity's class and the entity id's class, which is Message and Long

	Functions used in Code :-
	save(…) – save an Iterable of entities. Here, we can pass multiple objects to save them in a batch
	findOne(…) – get a single entity based on passed primary key value
	findAll() – get an Iterable of all available entities in database
	delete(…) – delete an entity based on the passed object

*/

public interface MessageRepository extends CrudRepository<Message, Long> {

}
