package com.havefun.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.havefun.api.enums.TypePersonEnum;

@Entity
@Table( name = "person")
public class Person implements Serializable{
	
	private static final long serialVersionUID = 7879038177316060080L;
	
	private Long id;
	private String name;
	private String email;
	private String password;
	private String identification_document;
	private TypePersonEnum type_of_person;
	private List<Address> adresses;
	private Date creation_date;
	private Date updated_date;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column( name = "email", nullable = false )
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column( name = "password", nullable = false )
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column( name = "identification_document")
	public String getIdentification_document() {
		return identification_document;
	}

	public void setIdentification_document(String identification_document) {
		this.identification_document = identification_document;
	}

	@Enumerated(EnumType.STRING)
	@Column( name = "type_of_person",  nullable = false)
	public TypePersonEnum getType_of_person() {
		return type_of_person;
	}

	public void setType_of_person(TypePersonEnum type_of_person) {
		this.type_of_person = type_of_person;
	}

	public List<Address> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Address> adresses) {
		this.adresses = adresses;
	}

	@Column( name = "creation_date")
	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	@Column( name = "updated_date")
	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", identification_document=" + identification_document + ", type_of_person=" + type_of_person
				+ ", adresses=" + adresses + ", creation_date=" + creation_date + ", updated_date=" + updated_date
				+ "]";
	}
	
	
	
}
