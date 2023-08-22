package com.ofss.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
@Entity
@Table(name="investor")
public class Investor {

	@Id
	private int investorid;
	@Column(name="username", nullable = false, length=20)
	private String username;
	@Column(name="password", nullable = false, length=20)
	private String password;
	@Column(name="first_name", nullable = false, length=20)
	private String firstname;
	@Column(name="email", nullable = false, length=20)
	private String email;
	@Column(name="last_name", nullable = false, length=20)
	private String lastname;
//	@Column(name="cash_balance", nullable = false, precision = 8, scale=3)
//	private float cashbalance;
	public int getInvestorid() {
		return investorid;
	}


	public void setInvestorid(int investorid) {
		this.investorid = investorid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public Investor() {
		// TODO Auto-generated constructor stub
	}
	
}
