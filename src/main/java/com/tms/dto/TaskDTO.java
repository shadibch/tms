package com.tms.dto;

import java.sql.Date;



import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.tms.entity.*;

public class TaskDTO {
	public TaskDTO() {
		
	}
	public TaskDTO(Task task) {
		setId(task.getId());
		setTitile(task.getTitile());
		setCubicFeet(task.getCubicFeet());
		setFirstName(task.getFirstName());
		setLastName(task.getLastName());
		setNote(task.getNote());
		setMovingDate(task.getMovingDate());
		setStatus(task.getStatus());
	}
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
	
	private String note;
	public String getName() {
		return titile + " " + firstName + " " + lastName;
	}


}
