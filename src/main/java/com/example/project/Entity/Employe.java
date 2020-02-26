package com.example.project.Entity;


import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
public class Employe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotEmpty(message="Please enter your name")
	private String name;
	
	@NotEmpty(message="Please enter your adresse")
	private String adresse;
	
	
	@Min(value=18, message = "Age should not be less than 18")
	private int age;
	
	@NotEmpty(message="Please enter your email")
	@Email(message="Please enter a valid email")
	private String email;
	
	@NotEmpty(message="Please enter your password")
	@Size(min=8, message="Password shoud not be less the 8 caracters")
	private String password;
	
	
	@ManyToOne(fetch = FetchType.EAGER)    
	private Company company;
	
	
	@OneToMany(mappedBy = "emp",fetch= FetchType.EAGER, cascade= {CascadeType.ALL}, orphanRemoval = true)
	private List<Mission> missons = new ArrayList<>();
	
	
	@OneToOne(mappedBy= "emp", fetch= FetchType.EAGER, cascade= CascadeType.ALL, orphanRemoval = true)
	private Contract contart;
	
	
	
	public Employe() {
		
	}
	
	
	
	public Employe(int id, String name, String adresse) {
		
		this.id = id;
		this.name = name;
		this.adresse = adresse;
		
	}
	
	
	public Employe(int id, String name, String adresse, Company company, List<Mission> missons, Contract contart) {
		
		this.id = id;
		this.name = name;
		this.adresse = adresse;
		this.company = company;
		this.missons = missons;
		this.contart = contart;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	
	public Company getcompany() {
		return  company;
	}

	public void setcompany(Company company) {
		this.company = company;
	}

	@JsonIgnore
	public List<Mission> getMissons() {
		return missons;
	}

	public void setMissons(List<Mission> missons) {
		this.missons = missons;
	}

	public Contract getContart() {
		return contart;
	}

	public void setContart(Contract contart) {
		this.contart = contart;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getemail() {
		return email;
	}



	public void setemail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	
	
	
	
	
	
	

}
