package com.example.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.dto.PersonDTO;
import com.example.spring.service.PersonService;

/**
 * Classe responsavel pela esposição rest de Pessoa
 * @author willans firmo
 * @since 13/03/2019
 *
 */
@RestController
@RequestMapping(value = "/api/person")
public class PersonController {
	
	private PersonService pessoaService;

	@Autowired
	public PersonController(PersonService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
	@RequestMapping(value = "",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PersonDTO>> findAll() {
		return ResponseEntity.ok(pessoaService.findAll());
	}
	
	@RequestMapping(value = "/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonDTO> findOne(@PathVariable("id") long id) {
		return ResponseEntity.ok(pessoaService.findOne(id));
	}
	
	@RequestMapping(value = "",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonDTO> create(@Validated @RequestBody PersonDTO dto) {
		return ResponseEntity.ok(pessoaService.create(dto));
	}
	
	@RequestMapping(value = "",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		pessoaService.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonDTO> update(@Validated @RequestBody PersonDTO dto) {
		return ResponseEntity.ok(pessoaService.create(dto));
	}

}
