package com.example.project.ServiceImpl;


import java.util.Optional;
import java.util.logging.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Entity.*;

import com.example.project.Repository.CompanyRepository;
import com.example.project.Services.CompanyService;


@Service("companyservice")
public class CompanyServiceImpl implements CompanyService {
	
	 Logger logger = Logger.getLogger(CompanyServiceImpl.class.getName()); 

	
	@Autowired
	private CompanyRepository companyRep;
		
	
	@Override
	public  Iterable<Company> getAllCompany(){
		return companyRep.findAll();
	}
	
	
	
	@Override
	public Optional<Company> findCompanyById (int id) {
		return companyRep.findById(id);
		
	}
	
	@Override
	public void deleteCompany(int id) {
		companyRep.deleteById(id);
		
	}
	

	@Override
	public void updateCompany(Company company, int id) {
		Company c = findCompanyById(id).get();
		c.setName(company.getName());
		c.setAdresse(company.getAdresse());
		
		
		companyRep.save(c);
	}


	@Override
	public void addCompany(Company company) {
		companyRep.save(company);
	}

}
