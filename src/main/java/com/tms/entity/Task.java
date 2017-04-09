package com.tms.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

@Entity

@GroupSequence({ Task.class, Address.class})
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Title getTitile() {
		return titile;
	}
	public void setTitile(Title titile) {
		this.titile = titile;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getMovingDate() {
		return movingDate;
	}
	public void setMovingDate(Date movingDate) {
		this.movingDate = movingDate;
	}
	public Float getCubicFeet() {
		return cubicFeet;
	}
	public void setCubicFeet(Float cubicFeet) {
		this.cubicFeet = cubicFeet;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Enumerated
	@NotNull
	private Title titile;
	@Enumerated
	@NotNull
	private Status status = Status.Pending;
	@NotNull
	@NotEmpty
	private String firstName;
	@NotNull
	@NotEmpty
	private String lastName;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date movingDate;

	private Float cubicFeet;
	@Lob
	private String note;
	@OneToOne(cascade=CascadeType.ALL,orphanRemoval=true)	
	private Address  address;
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Transient
	public String getName() {
		return titile + " " + firstName + " " + lastName;
	}

}
