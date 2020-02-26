package com.example.project.Services;

import java.util.Optional;


import com.example.project.Entity.*;

public interface DepartmentService {

	public  Iterable<Department> getAllDepartement();
	
	public  void addDepartment(Department dept, Optional<Company> company);
	
	public  void updateDepartment(Department dept, int id);
	
	public  void deleteDepartment(int id);
	
	public  Optional<Department> findDepartmentById (int id);
	
}
