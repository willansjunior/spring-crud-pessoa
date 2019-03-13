package com.example.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.ErrorException;
import com.example.spring.dto.PessoaDTO;
import com.example.spring.model.Pessoa;
import com.example.spring.repository.PessoaRepository;

/**
 * Classe responsavel pela regra de negocio dos serviços de Pessoa
 * @author willans firmo
 * @since 13/03/2019
 *
 */
@Service
public class PessoaService {
	
	private PessoaRepository pessoaRepository;
	
	private ModelMapper mapper;
	
	@Autowired
	public PessoaService(PessoaRepository pessoaRepository,
			ModelMapper mapper) {
		this.pessoaRepository = pessoaRepository;
		this.mapper = mapper;
	}

	@Transactional
	public List<PessoaDTO> findAll() {
		List<PessoaDTO> result = new ArrayList<>();
		for (Pessoa pessoa : pessoaRepository.findAll()) {
			result.add(mapper.map(pessoa, PessoaDTO.class));
		}
		return result;
	}

	@Transactional
	public List<PessoaDTO> findByNome(String name) {
		List<PessoaDTO> result = new ArrayList<>();
		for (Pessoa pessoa : pessoaRepository.findByName(name)) {
			result.add(mapper.map(pessoa, PessoaDTO.class));
		}
		return result;
	}
	
	@Transactional
	public PessoaDTO create(PessoaDTO dto) {
		Pessoa pessoa = pessoaRepository.findOne(dto.getId());
		if (pessoa == null) {
			pessoa = mapper.map(dto, Pessoa.class);
			pessoaRepository.save(pessoa);
		} else {
			throw new ErrorException("Já existe uma pessoa com o codigo " + dto.getId() + "!");
		}
		
		return mapper.map(pessoa, PessoaDTO.class);
	}
	
	@Transactional
	public void delete(long codigo) {
		Pessoa pessoa = pessoaRepository.findOne(codigo);
		if (pessoa == null) {
			throw new ErrorException("Não existe uma pessoa com o codigo " + codigo + "!");
		}
		
		pessoaRepository.delete(pessoa);
	}

	public PessoaDTO findOne(long id) {
		Pessoa pessoa = pessoaRepository.findOne(id);
		return mapper.map(pessoa, PessoaDTO.class);
	}

}
