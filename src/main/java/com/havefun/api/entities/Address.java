package com.havefun.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table( name = "address")
public class Address implements Serializable {
		
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String street;
	private int number;
	private String complement;
	private String zipCode;
	private String city;
	private String state;
	private String country;
	private double latitude;
	private double longitude;
	private Date creation_date;
	private Date updated_date;
	
	
	public Address(String street, int number, String complement, String zipCode, String city, String state,
			String country, double latitude, double longitude) {
		
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.zipCode = zipCode;
		this.city = city;
		this.state = state;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Address() {
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

	@Column( name = "street", nullable = false )
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column( name = "number", nullable = false )
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Column( name = "complement", nullable = true )
	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	@Column( name = "zip_code", nullable = false )
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Column( name = "city", nullable = false )
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column( name = "state", nullable = false )
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column( name = "country", nullable = false )
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column( name = "latitude", nullable = false )
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@Column( name = "longitude", nullable = false )
	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	@Column( name = "creation_date", nullable = false )
	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	@Column( name = "updated_date", nullable = false )
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
		return "Address [id=" + id + ", street=" + street + ", number=" + number + ", complement=" + complement
				+ ", zipCode=" + zipCode + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", creation_date=" + creation_date
				+ ", updated_date=" + updated_date + "]";
	}

	
}
