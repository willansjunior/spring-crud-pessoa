package com.example.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	
	private PersonRepository personRepository;
	
	private ModelMapper mapper;
	
	@Autowired
	public PersonService(PersonRepository personRepository,
			ModelMapper mapper) {
		this.personRepository = personRepository;
		this.mapper = mapper;
	}

	/**
	 * Busca todas as pessoas cadastradas
	 * @return List<PersonDTO>
	 */
	@Transactional
	public List<PersonDTO> findAll() {
		List<PersonDTO> result = new ArrayList<>();
		for (Person person : personRepository.findAll()) {
			result.add(mapper.map(person, PersonDTO.class));
		}
		return personRepository.findAll().stream()
				.map(p -> new PersonDTO(p, mapper)).collect(Collectors.toList());
	}

	/**
	 * Busca todas as pessoas a partir do nome
	 * @param name
	 * @return List<PersonDTO>
	 */
	@Transactional
	public List<PersonDTO> findByNome(String name) {
		List<PersonDTO> result = new ArrayList<>();
		for (Person person : personRepository.findByName(name)) {
			result.add(mapper.map(person, PersonDTO.class));
		}
		return result;
	}
	
	/**
	 * Cadastra uma nova pessoa
	 * @param dto
	 * @return PersonDTO
	 */
	@Transactional
	public PersonDTO create(PersonDTO dto) {
		Person person = personRepository.findOne(dto.getId());
		if (person == null) {
			save(dto);
		} else {
			throw new ErrorException("Já existe uma pessoa com o codigo " + dto.getId() + "!");
		}
		
		return mapper.map(person, PersonDTO.class);
	}
	
	/**
	 * Realiza a função de salvar ou atualizar uma pessoa
	 * @param dto
	 */
	private void save(PersonDTO dto) {
		personRepository.save(mapper.map(dto, Person.class));
	}
	
	/**
	 * Remove uma pessoa do banco de dados a partir do id
	 * @param codigo
	 */
	@Transactional
	public void delete(long codigo) {
		Person person = personRepository.findOne(codigo);
		if (person == null) {
			throw new ErrorException("Não existe uma pessoa com o codigo " + codigo + "!");
		}
		
		personRepository.delete(person);
	}

	/**
	 * Busca uma unica pessoa no banco a partir do seu id
	 * @param id
	 * @return PersonDTO
	 */
	@Transactional
	public PersonDTO findOne(long id) {
		Person person = personRepository.findOne(id);
		return mapper.map(person, PersonDTO.class);
	}

	/**
	 * Atualiza os dados de uma pessoa
	 * @param dto
	 * @param id
	 * @return PersonDTO
	 */
	public PersonDTO update(PersonDTO dto, long id) {
		Person person = personRepository.findOne(dto.getId());
		if (person == null) {
			throw new ErrorException("Não existe está pessoa cadastrada!");
		}
		dto.setId(person.getId());
		save(dto);
		return mapper.map(person, PersonDTO.class);
	}

}
