package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bmdb.business.Movie;
import com.bmdb.db.MovieRepo;

@CrossOrigin
@RestController
@RequestMapping("/movies")
public class MovieController {
	
	/*
	 * A controller will implement 5 CRUD methods:
	 * 1) GET ALL
	 * 2) GET BY ID
	 * 3) POST - Insert / Create
	 * 4) PUT - Update
	 * 5) DELETE - Delete
	 */
	
	@Autowired
	private MovieRepo movieRepo; 
	//instance variable for MovieRepo. Defined at the class level.
	//movieRepo is an instance variable of the MovieController class
	
	
	//get all movies
	
	@GetMapping("/")
	public List<Movie> getAll() {
		return movieRepo.findAll();
	}
	
	
	//get movie by id
	
	@GetMapping("/{id}")
	public Optional<Movie> getById(@PathVariable int id) {
		return movieRepo.findById(id);
	}
	

	// add a movie
	//pass instance of movie in and use JPA to add it to the database
	
	@PostMapping("/")
	public  Movie addMovie(@RequestBody Movie m) {
		m = movieRepo.save(m);
		return m;
	}
	
	
	//update a movie
	
	@PutMapping("/")
	public Movie updateMovie(@RequestBody Movie m) {
		m = movieRepo.save(m);
		return m;
	}
	
	//delete a movie
	
	@DeleteMapping("/{id}")
	public Movie deleteMovie(@PathVariable int id) {
		Optional<Movie> m = movieRepo.findById(id);
		if (m.isPresent()) {
			movieRepo.deleteById(id);
		} else {
			System.out.println("Error - movie not found for id " + id);
		}
		return m.get();
	}
	
}
