package com.example.project.Services;

import java.util.Optional;

import com.example.project.Entity.*;


public interface EmployeService {

	public Iterable<Employe> getAllEmploye();
	
	public void addEmploye(Employe emp, Company c);
	
	public  void updateEmploye(Employe emp, int id);
	
	public void delete(int id);
	
	public Optional<Employe> findById (int id);

	
	
	
	
	
	
}
