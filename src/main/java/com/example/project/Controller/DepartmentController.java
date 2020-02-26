package com.example.project.Controller;


import java.util.Optional;
import com.example.project.Exceptions.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.Entity.*;
import com.example.project.Exceptions.NotFoundException;
import com.example.project.Services.CompanyService;
import com.example.project.Services.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService deptService;
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping(path="/departments")
	
	public @ResponseBody Iterable<Department> getAllDepartment(){
		return deptService.getAllDepartement();
	}
	
	@PostMapping(path="/departments/add/{idCompany}")
	public @ResponseBody  void addDepartment(@RequestBody Department dept, @PathVariable int idCompany) {
		Optional<Company> c = companyService.findCompanyById(idCompany);
		deptService.addDepartment(dept, c);
	}
	
	@GetMapping(path="/departments/find/{id}")
	public Department findDepartmentById(@PathVariable int id) {
		return deptService.findDepartmentById(id).orElseThrow(() -> new NotFoundException(id,"Departement"));
	}
	
	@PostMapping(path="/departments/delete/{id}")
	public void deleteDepartment(@PathVariable int id) {
		 deptService.deleteDepartment(id);
	}
	
	@PostMapping(path="/departments/update/{id}")
	public void updateDepartement(@RequestBody Department dept ,@PathVariable int id) {
		deptService.updateDepartment(dept, id);
	}
	
	

	
}
