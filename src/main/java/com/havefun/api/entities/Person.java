package com.havefun.api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.havefun.api.converters.LocalDateConverter;
import com.havefun.api.enums.TypeOfRoleEnum;

@Entity
@Table( name = "person")
public class Person implements Serializable{
	
	private static final long serialVersionUID = 7879038177316060080L;
	
	private Long id;
	private String name;
	private String email;
	private String password;
	private String identification_document;
	private TypeOfRoleEnum type_of_role;
	private List<Address> addresses;
	private LocalDate birthday;
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
	@Column( name = "role", nullable = false)
	public TypeOfRoleEnum getType_of_role() {
		return type_of_role;
	}

	public void setType_of_role(TypeOfRoleEnum type_of_role) {
		this.type_of_role = type_of_role;
	}

	@OneToOne(fetch = FetchType.EAGER)	// Uma pessoal tem um endereço, é do tipo EAGER, sempre que eu carregar uma Pessoa eu quero carregar o Endereço dele.
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public void setAddress(String street, int number, String complement, String zipCode, String city, String state,
			String country, double latitude, double longitude) {
		this.addresses.add(new Address(street, number, complement, zipCode, city, state, country, latitude, longitude));
	}
	
	public void setAddress(Address address) {
		this.addresses.add(address);
	}

	@Column( name = "birthday", nullable = false)
	@Convert( converter = LocalDateConverter.class )
	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	public int getAge() {
		return this.birthday
				   .until(IsoChronology.INSTANCE.dateNow())
				   .getYears();
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
	
	@PreUpdate
	public void preUpdate() {
		this.creation_date = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date current = new Date();
		this.creation_date = current;
		this.updated_date = current;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", identification_document=" + identification_document + ", type_of_role=" + type_of_role
				+ ", addresses=" + addresses + ", creation_date=" + creation_date + ", updated_date=" + updated_date
				+ "]";
	}

	

}
