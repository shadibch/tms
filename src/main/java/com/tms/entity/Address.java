package com.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAddresLineOne() {
		return addresLineOne;
	}
	public void setAddresLineOne(String addresLineOne) {
		this.addresLineOne = addresLineOne;
	}
	public String getAddresLineTwo() {
		return addresLineTwo;
	}
	public void setAddresLineTwo(String addresLineTwo) {
		this.addresLineTwo = addresLineTwo;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	@NotEmpty
	@NotNull
	private String addresLineOne;
	@Column(nullable=true)
	private String addresLineTwo;
	@NotEmpty
	@NotNull
	private String countryCode;
	@NotEmpty
	@NotNull
	private String town;
	@NotEmpty
	@NotNull
	private String postcode;

	
}
