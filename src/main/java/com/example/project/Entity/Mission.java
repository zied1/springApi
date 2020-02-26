package com.example.project.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Mission {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Employe emp;
	
	
	
	public Mission() {
	
	}
	
	public Mission(int id) {
		this.id = id;
	}
	
	public Mission(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	
	



	public Mission(int id, String description, Employe emp) {
		super();
		this.id = id;
		this.description = description;
		this.emp = emp;
	}

	
	public Employe getemp() {
		return emp;
	}

	
	public void setemp(Employe emp) {
		this.emp = emp;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
