package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmdb.business.User;
import com.bmdb.db.UserRepo;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

	
		
		/*
		 * A controller will implement 5 CRUD methods:
		 * 1) GET ALL
		 * 2) GET BY ID
		 * 3) POST - Insert / Create
		 * 4) PUT - Update
		 * 5) DELETE - Delete
		 */
		
		@Autowired
		private UserRepo userRepo; 
		
		
		
		@GetMapping("/")
		public List<User> getAll() {
			return userRepo.findAll();
		}
		

		
		@GetMapping("/{id}")
		public Optional<User> getById(@PathVariable int id) {
			return userRepo.findById(id);
		}
		

		
		@PostMapping("/")
		public  User addUser(@RequestBody User u) {
			u = userRepo.save(u);
			return u;
		}
		
		
		
		@PutMapping("/")
		public User updateUser(@RequestBody User u) {
			u = userRepo.save(u);
			return u;
		}
		
		
		@DeleteMapping("/{id}")
		public User deleteUser(@PathVariable int id) {
			Optional<User> u = userRepo.findById(id);
			if (u.isPresent()) {
				userRepo.deleteById(id);
			} else {
				System.out.println("Error - user not found for id " + id);
			}
			return u.get();
		}
		
//		@GetMapping("/find-by-rating")
//		public List<Movie> getAllRating(String rating) {
//			return movieRepo.findByRating(rating);
//		}
//		
//		@GetMapping("/find-by-director")
//		public List<Movie> getAllDirector(String director) {
//			return movieRepo.findByDirector(director);
		
		
	}


