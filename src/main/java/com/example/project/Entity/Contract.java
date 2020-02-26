package com.example.project.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Contract {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String type;
	private String duration;
	
	@OneToOne( fetch= FetchType.EAGER)
	private Employe emp;
	
	
	
	public Contract() {
		
	}
	
public Contract(int id) {
		this.id = id;
	}
	
	public Contract(int id, String type, String duration) {
		super();
		this.id = id;
		this.type = type;
		this.duration = duration;
	}

	
	


	public Contract(int id, String type, String duration, Employe emp) {
		super();
		this.id = id;
		this.type = type;
		this.duration = duration;
		this.emp = emp;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}

	@JsonIgnore
	public Employe getemp() {
		return emp;
	}


	public void setemp(Employe emp) {
		this.emp = emp;
	}
	
	
	
	
	
	
}
