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
@Table( name = "event")
public class Event implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String title;
	private Date start_date;
	private Date finish_date;
	private Date start_time;
	private Date finish_time; 
	private Address address;
	private List<Evaluation> evaluationList;
	private Company event_owner;
	private Date creation_date;
	private Date updated_date;

	
	public Event() {
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
	
	@Column( name = "title", nullable = false )
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column( name = "start_date", nullable = false )
	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	@Column( name = "finish_date", nullable = false )
	public Date getFinish_date() {
		return finish_date;
	}

	public void setFinish_date(Date finish_date) {
		this.finish_date = finish_date;
	}

	@Column( name = "start_time", nullable = false )
	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	@Column( name = "finish_time", nullable = false )
	public Date getFinish_time() {
		return finish_time;
	}

	public void setFinish_time(Date finish_time) {
		this.finish_time = finish_time;
	}

	@OneToOne( mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@OneToMany( mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Evaluation> getEvaluationList() {
		return evaluationList;
	}

	public void setEvaluationList(List<Evaluation> evaluationList) {
		this.evaluationList = evaluationList;
	}

	@OneToOne( mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Company getEvent_owner() {
		return event_owner;
	}

	public void setEvent_owner(Company event_owner) {
		this.event_owner = event_owner;
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
		return "Event [id=" + id + ", title=" + title + ", start_date=" + start_date + ", finish_date=" + finish_date
				+ ", start_time=" + start_time + ", finish_time=" + finish_time + ", address=" + address
				+ ", evaluationList=" + evaluationList + ", event_owner=" + event_owner + ", creation_date="
				+ creation_date + ", updated_date=" + updated_date + "]";
	}

	

}
