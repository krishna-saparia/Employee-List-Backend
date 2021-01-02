package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "employees")
public class Employee {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	    @Column(name = "first_name")
	    private String first_name;
	    @Column(name = "last_name")
	    private String last_name;
	    @Column(name = "email_id")
	    private String emailID;
	    public Employee(){

	    }
	    public Employee(String first_name, String last_name, String emailID) {
	        super();
	        this.first_name = first_name;
	        this.last_name = last_name;
	        this.emailID = emailID;
	    }

	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public String getFirst_name() {
	        return first_name;
	    }

	    public void setFirst_name(String first_name) {
	        this.first_name = first_name;
	    }

	    public String getLast_name() {
	        return last_name;
	    }

	    public void setLast_name(String last_name) {
	        this.last_name = last_name;
	    }

	    public String getEmailID() {
	        return emailID;
	    }

	    public void setEmailID(String emailID) {
	        this.emailID = emailID;
	    }


}
