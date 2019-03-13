package com.example.spring;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.spring.dto.PersonDTO;
import com.example.spring.model.Person;
import com.example.spring.repository.PersonRepository;
import com.example.spring.service.PersonService;

/**
 * Classe utilizada para os testes unitarios de Pessoa
 * @author willans firmo
 * @since 13/03/2019
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class DemoApplicationTests {
	
	PersonRepository personRepository;
	
	PersonService personService;
	
	@Autowired
	ModelMapper mapper;
	
	private List<PersonDTO> listPerson = new ArrayList<>();
	
	@Before
	public void inicializar() {
		personRepository = EasyMock.createMock(PersonRepository.class);
		personService = EasyMock.createMock(PersonService.class);
		
		/**
		 * Montando a lista de pessoas
		 */
		gerarLista();
		
	}

	/**
	 * Listar todas as pessoas
	 * @return List<PersonDTO>
	 */
	@Test
	public void findAllPerson() {
		EasyMock.expect(personService.findAll()).andReturn(listPerson);
		EasyMock.replay(personService);
		List<PersonDTO> list = personService.findAll();
		assertNotNull(list);
		EasyMock.verify(personService);
	}
	
	/**
	 * Listar todas as pessoas usando como filtro o nome
	 * @param nome String - o nome da pessoa
	 * @return List<PersonDTO> - Retorno em lista pois podem existir homonimos
	 */
	@Test
	public void findByNamePerson() {
		EasyMock.expect(personService.findByNome("Willans Firmo")).andReturn(listPerson);
		EasyMock.replay(personService);
		List<PersonDTO> list = personService.findByNome("Willans Firmo");
		assertNotNull(list);
		EasyMock.verify(personService);
	}
	
	/**
	 * Criar pessoa
	 * @param PersonDTO
	 * @return PersonDTO
	 */
	@Test
	public void createPerson() {
		PersonDTO dto = new PersonDTO();
		dto.setId(12L);
		dto.setName("Willans Firmo");
		
		EasyMock.expect(personRepository.findOne(dto.getId())).andReturn(null);
		EasyMock.replay(personRepository);
		Person personMock = personRepository.findOne(dto.getId());
		assertNull(personMock);
		
		EasyMock.verify(personRepository);
		
		EasyMock.expect(personService.create(dto)).andReturn(dto);
		EasyMock.replay(personService);
		PersonDTO personDTO = personService.create(dto);
		assertNotNull(personDTO);
		
		EasyMock.verify(personService);
	}
	
	/**
	 * Montagem da lista de Pessoas
	 */
	private void gerarLista() {
		Person person = getPessoa();
		
		listPerson.add(mapper.map(person, PersonDTO.class));
	}
	
	/**
	 * Monta uma pessoa
	 * @return Person
	 */
	private Person getPessoa() {
		Person person = new Person();
		person.setId(12L);
		person.setName("Willans Firmo");
		
		return person;
	}
	
}
