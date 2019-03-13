package com.example.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Mapeamento da entidade Pessoa
 * @author willans firmo
 * @since 13/03/2019
 *
 */
@Entity
@Table(name = "person")
@SuppressWarnings("serial")
public class Pessoa implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name", length = 150, nullable = false)
	private String name;
	
	@Column(name = "street", length = 255, nullable = false)
	private String street;
	
	@Column(name = "number", length = 10, nullable = false)
	private String number;
	
	@Column(name = "neighborhood", length = 150, nullable = false)
	private String neighborhood;
	
	@Column(name = "city", length = 150, nullable = false)
	private String city;
	
	@Column(name = "state", length = 4, nullable = false)
	private String state;
	
	@Column(name = "cellphone", length = 20, nullable = false)
	private String cellphone;
	
	@Column(name = "phone", length = 20, nullable = false)
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
