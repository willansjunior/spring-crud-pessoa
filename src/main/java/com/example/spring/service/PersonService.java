package com.example.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.ErrorException;
import com.example.spring.dto.PersonDTO;
import com.example.spring.model.Person;
import com.example.spring.repository.PersonRepository;

/**
 * Classe responsavel pela regra de negocio dos serviços de Pessoa
 * @author willans firmo
 * @since 13/03/2019
 *
 */
@Service
public class PersonService {
	
	private PersonRepository pessoaRepository;
	
	private ModelMapper mapper;
	
	@Autowired
	public PersonService(PersonRepository pessoaRepository,
			ModelMapper mapper) {
		this.pessoaRepository = pessoaRepository;
		this.mapper = mapper;
	}

	@Transactional
	public List<PersonDTO> findAll() {
		List<PersonDTO> result = new ArrayList<>();
		for (Person pessoa : pessoaRepository.findAll()) {
			result.add(mapper.map(pessoa, PersonDTO.class));
		}
		return result;
	}

	@Transactional
	public List<PersonDTO> findByNome(String name) {
		List<PersonDTO> result = new ArrayList<>();
		for (Person pessoa : pessoaRepository.findByName(name)) {
			result.add(mapper.map(pessoa, PersonDTO.class));
		}
		return result;
	}
	
	@Transactional
	public PersonDTO create(PersonDTO dto) {
		Person pessoa = pessoaRepository.findOne(dto.getId());
		if (pessoa == null) {
			pessoa = mapper.map(dto, Person.class);
			pessoaRepository.save(pessoa);
		} else {
			throw new ErrorException("Já existe uma pessoa com o codigo " + dto.getId() + "!");
		}
		
		return mapper.map(pessoa, PersonDTO.class);
	}
	
	@Transactional
	public void delete(long codigo) {
		Person pessoa = pessoaRepository.findOne(codigo);
		if (pessoa == null) {
			throw new ErrorException("Não existe uma pessoa com o codigo " + codigo + "!");
		}
		
		pessoaRepository.delete(pessoa);
	}

	public PersonDTO findOne(long id) {
		Person pessoa = pessoaRepository.findOne(id);
		return mapper.map(pessoa, PersonDTO.class);
	}

}
