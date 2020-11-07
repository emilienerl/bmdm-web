package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bmdb.business.Actor;
import com.bmdb.db.ActorRepo;

@CrossOrigin
@RestController
@RequestMapping("/actors")
public class ActorController {
	
	/*
	 * A controller will implement 5 CRUD methods:
	 * 1) GET ALL
	 * 2) GET BY ID
	 * 3) POST - Insert / Create
	 * 4) PUT - Update
	 * 5) DELETE - Delete
	 */
	
	@Autowired
	private ActorRepo actorRepo; 
	//instance variable for MovieRepo. Defined at the class level.
	//movieRepo is an instance variable of the MovieController class
	
	
	//get all actors
	
	@GetMapping("/")
	public List<Actor> getAll() {
		return actorRepo.findAll();
	}
	
	
	//get actor by id
	
	@GetMapping("/{id}")
	public Optional<Actor> getById(@PathVariable int id) {
		return actorRepo.findById(id);
	}
	

	// add a actor
	//pass instance of movie in and use JPA to add it to the database
	
	@PostMapping("/")
	public Actor addActor(@RequestBody Actor a) {
		a = actorRepo.save(a);
		return a;
	}
	
	
	//update a actor
	
	@PutMapping("/")
	public Actor updateActor(@RequestBody Actor a) {
		a = actorRepo.save(a);
		return a;
	}
	
	//delete a actor
	
	@DeleteMapping("/{id}")
	public Actor deleteActor(@PathVariable int id) {
		Optional<Actor> a = actorRepo.findById(id);
		if (a.isPresent()) {
			actorRepo.deleteById(id);
		} else {
			System.out.println("Error - actor not found for id " + id);
		}
		return a.get();
	}
	
}
