package com.example.project.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Company {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	private String name;
	private String adresse;
	
	
	@OneToMany(mappedBy = "company",fetch= FetchType.EAGER ,cascade= {CascadeType.REMOVE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE}, orphanRemoval = true)
	private  List<Employe>  emps = new ArrayList<>();
	
	
	@ManyToMany
	@JoinTable(name="company_dept",
			joinColumns = { @JoinColumn(name = "company_id") })
	private List<Department> department = new ArrayList<Department>();
	
	
	
	
	
	public Company() {
		super();
	}
	
	public Company(int id) {
		this.id = id;
	}



	public Company(int id, String name, String adresse) {
		this.id = id;
		this.name = name;
		this.adresse = adresse;
	}
	
	

	
	
	public Company(int id, String name, String adresse, List<Employe> emps, List<Department> department) {
		super();
		this.id = id;
		this.name = name;
		this.adresse = adresse;
		this.emps = emps;
		this.department = department;
	}



	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	@JsonIgnore
	public List<Employe> getEmps() {
		return emps;
	}



	public void setEmps(List<Employe> emps) {
		this.emps = emps;
	}


	@JsonIgnore
	public List<Department> getdepartment() {
		return department;
	}



	public void setdepartment(List<Department> department) {
		this.department = department;
	}
	
	
	
	
	
}
