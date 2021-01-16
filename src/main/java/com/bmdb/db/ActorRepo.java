package com.bmdb.db;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmdb.business.Actor;

public interface ActorRepo extends JpaRepository<Actor, Integer> {
	
	//find actors by gender
	
	List<Actor> findByGender(String gender);
	
	//Param is lastName so that has to spelled as lastName after the ?
	List<Actor> findByLastName(String lastName);
	
	List<Actor> findByLastNameLike(String letter);
	
	List<Actor> findByBirthDateBetween(LocalDate d1, LocalDate d2);

}
