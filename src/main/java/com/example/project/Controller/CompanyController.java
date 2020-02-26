package com.example.project.Controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.Entity.*;

import com.example.project.Services.CompanyService;
import com.example.project.Services.DepartmentService;

@RestController
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private DepartmentService deptService;
	
	
	
	@GetMapping(path="/companies")
	
	public @ResponseBody Iterable<Company> getAllEmploye(){
		return companyService.getAllCompany();
	}
	
	@PostMapping(path="/companies/add")
	public @ResponseBody  void addCompany(@RequestBody Company company) {
		
		companyService.addCompany(company);
	}
	
	@GetMapping(path="/companies/find/{id}")
	public Optional<Company> findById(@PathVariable int id) {
		return companyService.findCompanyById(id);
	}
	
	@PostMapping(path="/companies/delete/{id}")
	public void delete(@PathVariable int id) {
		 companyService.deleteCompany(id);
	}
	
	@PostMapping(path="/companies/update/{id}")
	public void update(@RequestBody Company company ,@PathVariable int id) {
		companyService.updateCompany(company, id);
	}

}
