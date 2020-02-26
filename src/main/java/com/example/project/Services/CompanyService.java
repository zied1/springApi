package com.example.project.Services;


import java.util.List;
import java.util.Optional;

import com.example.project.Entity.*;


public interface CompanyService {
	
	public  Iterable<Company> getAllCompany();
	
	//public  void addDeptCompany(Company company, Optional<Department> dept,  List<Department> list);
	
	public void addCompany(Company company);
	
	public  void updateCompany(Company company, int id);
	
	public  void deleteCompany(int id);
	
	public  Optional<Company> findCompanyById (int id);

}
