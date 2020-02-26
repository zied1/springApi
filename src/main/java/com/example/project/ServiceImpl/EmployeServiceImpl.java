package com.example.project.ServiceImpl;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Entity.*;

import com.example.project.Repository.EmployeRepository;
import com.example.project.Services.EmployeService;

@Service("employeService")
public class EmployeServiceImpl implements EmployeService {
	
	@Autowired
	private EmployeRepository empRep;
	
	
	/*public List <Employe> getAllEmployeee() {
		List<Employe> listEmp = new ArrayList<>();
		 empRep.findAll().forEach(listEmp::add);
		 return listEmp;
	}*/

	@Override
	public Iterable <Employe> getAllEmploye(){
		return empRep.findAll();
	}
	
	@Override
	public void addEmploye(Employe emp,  Company c) {
		emp.setcompany(c);
		 empRep.save(emp);
	}
	
	
	@Override
	public Optional<Employe> findById (int id) { 
		return empRep.findById(id);
	}
	
	@Override
	public void delete(int id) {
		
		empRep.deleteById(id);
		
		
	}
	
	public  void updateEmploye(Employe emp, int id) {
		Employe e= findById(id).get();
		e.setName(emp.getName());
		e.setAdresse(emp.getAdresse());
		e.setAge(emp.getAge());
		e.setemail(emp.getemail());
		e.setcompany(emp.getcompany());
		//e.setContart(emp.getContart());
		//e.setMissons(emp.getMissons());
		
		empRep.save(e);
	}

	

	
}
