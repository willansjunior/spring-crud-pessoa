package com.example.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.model.Person;

/**
 * @author willans firmo
 * @since 13/03/2019
 *
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	List<Person> findByName(String name);

}
