package com.example.project.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Entity.*;
import com.example.project.Repository.DepartmentRepository;
import com.example.project.Services.CompanyService;
import com.example.project.Services.DepartmentService;

@Service("departmentservice")
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRep;
	
	@Autowired
	private CompanyService companyService;

	@Override
	public Iterable<Department> getAllDepartement() {
		return departmentRep.findAll();
	}
	

	@Override
	public void updateDepartment(Department dept, int id) {
		Department d = findDepartmentById(id).get();
		d.setName(dept.getName());
		d.setCompany(dept.getCompany());
		departmentRep.save(d);
		
	}

	@Override
	public void deleteDepartment(int id) {
		departmentRep.deleteById(id);
		
	}

	@Override
	public Optional<Department> findDepartmentById(int id) {
		return departmentRep.findById(id);
	}



	@Override
	public void addDepartment(Department dept, Optional<Company> company) {
		List<Company> companies = new ArrayList<>();
		companies.add(company.get());
		dept.setCompany(companies);
		departmentRep.save(dept);
		
	}

	

}
