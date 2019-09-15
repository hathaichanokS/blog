package org.fealise.blog.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account {

	private long id;
	 private String accountName;
	 private String firstName;
	 private String lastName;
	 private Date created;
	  
	 public Account() {
		 
	 }

	public Account(long id, String accountName, String firstName, String lastName) {
		this.id = id;
		this.accountName = accountName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.created = new Date();
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
