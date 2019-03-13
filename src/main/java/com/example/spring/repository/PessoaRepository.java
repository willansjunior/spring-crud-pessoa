package com.example.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.model.Pessoa;

/**
 * @author willans firmo
 * @since 13/03/2019
 *
 */
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	List<Pessoa> findByName(String name);

}
