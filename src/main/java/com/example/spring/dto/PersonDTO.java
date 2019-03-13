package com.example.spring.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * DTO para exposição dos dados de uma pessoa
 * @author willans firmo
 * @since 13/03/2019
 *
 */
@SuppressWarnings("serial")
public class PersonDTO implements Serializable {
	
	private Long id;
	
	@NotNull(message = "Nome obrigatorio!")
	private String name;
	
	private String street;
	
	private String number;
	
	private String neighborhood;
	
	private String city;
	
	private String state;
	
	private String cellphone;
	
	private String phone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
