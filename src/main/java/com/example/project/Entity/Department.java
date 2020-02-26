package com.example.project.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	
	@ManyToMany
	@JoinTable(name="company_dept",
			joinColumns = { @JoinColumn(name = "department_id") })
	private List<Company> company = new ArrayList<Company>();
	
	public Department() {
		
	}
	
	public Department(int id) {
		this.id = id;
	}
	
	
	public Department(int id, String name) {
		this.id = id;
		this.name = name;
	}

	
	


	public Department(int id, String name, List<Company> company) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@JsonIgnore
	public List<Company> getCompany() {
		return company;
	}



	public void setCompany(List<Company> company) {
		this.company = company;
	}
	
	
	
	
}
