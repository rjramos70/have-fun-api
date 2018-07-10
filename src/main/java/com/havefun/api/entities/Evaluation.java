package com.havefun.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table( name = "evaluation")
public class Evaluation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Event event;
	private Date evaluation_date;
	private Integer punctuality;
	private Integer hygiene;
	private Integer professionalism;
	private Integer structure;
	private Integer organization;
	private Person responsible;		// Person who made the Evaluation
	private Date creation_date;
	private Date updated_date;
	
	public Evaluation() {
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

	@OneToOne( mappedBy = "evaluation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Column( name = "evaluation_date", nullable = false )
	public Date getEvaluation_date() {
		return evaluation_date;
	}

	public void setEvaluation_date(Date evaluation_date) {
		this.evaluation_date = evaluation_date;
	}

	@Column( name = "punctuality", nullable = false )
	public Integer getPunctuality() {
		return punctuality;
	}

	public void setPunctuality(Integer punctuality) {
		this.punctuality = punctuality;
	}

	@Column( name = "hygiene", nullable = false )
	public Integer getHygiene() {
		return hygiene;
	}

	public void setHygiene(Integer hygiene) {
		this.hygiene = hygiene;
	}

	@Column( name = "professionalism", nullable = false )
	public Integer getProfessionalism() {
		return professionalism;
	}

	public void setProfessionalism(Integer professionalism) {
		this.professionalism = professionalism;
	}

	@Column( name = "structure", nullable = false )
	public Integer getStructure() {
		return structure;
	}

	public void setStructure(Integer structure) {
		this.structure = structure;
	}

	@Column( name = "organization", nullable = false )
	public Integer getOrganization() {
		return organization;
	}

	public void setOrganization(Integer organization) {
		this.organization = organization;
	}

	@OneToOne( mappedBy = "evaluation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Person getResponsible() {
		return responsible;
	}

	public void setResponsible(Person responsible) {
		this.responsible = responsible;
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
		return "Evaluation [id=" + id + ", event=" + event + ", evaluation_date=" + evaluation_date + ", punctuality="
				+ punctuality + ", hygiene=" + hygiene + ", professionalism=" + professionalism + ", structure="
				+ structure + ", organization=" + organization + ", responsible=" + responsible + ", creation_date="
				+ creation_date + ", updated_date=" + updated_date + "]";
	}

}
