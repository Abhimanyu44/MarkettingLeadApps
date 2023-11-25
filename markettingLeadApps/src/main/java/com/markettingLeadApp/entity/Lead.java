package com.markettingLeadApp.entity;

import javax.persistence.*;

@Entity
@Table(name = "Leads")             // this annotation used when wants to create 
public class Lead {                // table name different from entity class name. But
	@Id                            // if wants same name then no need to use this table annotation
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name= "first_name", nullable=false)   // this column annotation is used to give the 
	private String firstname;                     // snake-case name in DB instead of Camel-case
	
	@Column(name= "last_name", nullable=false)
	private String lastname;
	
	@Column(name= "email", nullable=false)
	private String email;
	
	@Column(name= "mobile", nullable=false)
	private long mobile;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
}