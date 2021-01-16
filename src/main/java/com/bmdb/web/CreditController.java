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

import com.bmdb.business.Credit;
import com.bmdb.db.CreditRepo;

@CrossOrigin
@RestController
@RequestMapping("/credits")
public class CreditController {
	
	@Autowired
	private CreditRepo creditRepo;
	
	@GetMapping("/")
	public List<Credit> getAllCredits() {
		return creditRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Credit> getById(@PathVariable int id) {
		return creditRepo.findById(id);
	}
	
	// add a credit
		@PostMapping("/")
		public Credit addCredit(@RequestBody Credit c) {
			return creditRepo.save(c);
		}
		
		@PutMapping("/")
		public Credit updateCredit(@RequestBody Credit c) {
			c = creditRepo.save(c);
			return c;
		}

		@DeleteMapping("/{id}")
		public Optional <Credit> deleteCredit(@PathVariable int id) {
			Optional<Credit> c = creditRepo.findById(id);
			if (c.isPresent()) {
				creditRepo.deleteById(id);
			} else {
				System.out.println("Error - credit not found for id " + id);
			}
			return c;
		}
}
