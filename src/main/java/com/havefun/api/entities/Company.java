package com.havefun.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table( name = "company")
public class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String cnpj;
	private String social_name;
	private Address address;
	private String phone;
	private String email;
	private Person responsible;
	private List<Event> eventList;
	private Date creation_date;
	private Date updated_date;
	
	public Company() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column( name = "cnpj", nullable = false )
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Column( name = "social_name", nullable = false )
	public String getSocial_name() {
		return social_name;
	}

	public void setSocial_name(String social_name) {
		this.social_name = social_name;
	}

	@OneToOne( mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column( name = "phone", nullable = false )
	public String getPhoneList() {
		return this.phone;
	}

	public void setPhoneList(String phone) {
		this.phone = phone;
	}
	
	@Column( name = "email", nullable = false )
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToOne( mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Person getResponsible() {
		return responsible;
	}

	public void setResponsible(Person responsible) {
		this.responsible = responsible;
	}

	@OneToMany( mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Event> getEventList() {
		return eventList;
	}

	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
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
		return "Company [id=" + id + ", cnpj=" + cnpj + ", social_name=" + social_name + ", address=" + address
				+ ", phone=" + phone + ", email=" + email + ", responsible=" + responsible + ", eventList="
				+ eventList + ", creation_date=" + creation_date + ", updated_date=" + updated_date + "]";
	}
	
	

}
