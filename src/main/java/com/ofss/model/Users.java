package com.ofss.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
@Entity
@Table(name="users")
public class Users {
	@Id
	private int userid;
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
	@Column(name="cash_balance", nullable = false, precision = 8, scale=3)
	private float cashbalance;

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public float getCashbalance() {
		return cashbalance;
	}
	public void setCashbalance(float cashbalance) {
		this.cashbalance = cashbalance;
	}

	public Users(int userid, String username, String password, String firstname, String email, String lastname,
			float cashbalance, String userrole) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.email = email;
		this.lastname = lastname;
		this.cashbalance = cashbalance;
	}

	public Users() {
		// TODO Auto-generated constructor stub
	}
}
