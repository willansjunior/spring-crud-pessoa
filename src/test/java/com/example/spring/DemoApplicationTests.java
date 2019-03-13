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
	
	PersonRepository pessoaRepository;
	
	PersonService pessoaService;
	
	@Autowired
	ModelMapper mapper;
	
	private List<PersonDTO> listPessoa = new ArrayList<>();
	
	@Before
	public void inicializar() {
		pessoaRepository = EasyMock.createMock(PersonRepository.class);
		pessoaService = EasyMock.createMock(PersonService.class);
		
		/**
		 * Montando a lista de pessoas
		 */
		gerarLista();
		
	}

	/**
	 * Listar todas as pessoas
	 * @return List<PessoaDTO>
	 */
	@Test
	public void findAllPessoa() {
		EasyMock.expect(pessoaService.findAll()).andReturn(listPessoa);
		EasyMock.replay(pessoaService);
		List<PersonDTO> list = pessoaService.findAll();
		assertNotNull(list);
		EasyMock.verify(pessoaService);
	}
	
	/**
	 * Listar todas as pessoas usando como filtro o nome
	 * @param nome String - o nome da pessoa
	 * @return List<PessoaDTO> - Retorno em lista pois podem existir homonimos
	 */
	@Test
	public void findByNamePessoa() {
		EasyMock.expect(pessoaService.findByNome("Willans Firmo")).andReturn(listPessoa);
		EasyMock.replay(pessoaService);
		List<PersonDTO> list = pessoaService.findByNome("Willans Firmo");
		assertNotNull(list);
		EasyMock.verify(pessoaService);
	}
	
	/**
	 * Criar pessoa
	 * @param PersonDTO
	 * @return PessoaDTO
	 */
	@Test
	public void criarPessoa() {
		PersonDTO dto = new PersonDTO();
		dto.setId(12L);
		dto.setName("Willans Firmo");
		
		EasyMock.expect(pessoaRepository.findOne(dto.getId())).andReturn(null);
		EasyMock.replay(pessoaRepository);
		Person pessoaMock = pessoaRepository.findOne(dto.getId());
		assertNull(pessoaMock);
		
		EasyMock.verify(pessoaRepository);
		
		EasyMock.expect(pessoaService.create(dto)).andReturn(dto);
		EasyMock.replay(pessoaService);
		PersonDTO pessoaDTO = pessoaService.create(dto);
		assertNotNull(pessoaDTO);
		
		EasyMock.verify(pessoaService);
	}
	
	/**
	 * Montagem da lista de Pessoas
	 */
	private void gerarLista() {
		Person pessoa = getPessoa();
		
		listPessoa.add(mapper.map(pessoa, PersonDTO.class));
	}
	
	/**
	 * Monta uma pessoa
	 * @return Pessoa
	 */
	private Person getPessoa() {
		Person pessoa = new Person();
		pessoa.setId(12L);
		pessoa.setName("Willans Firmo");
		
		return pessoa;
	}
	
}
