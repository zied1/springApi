package com.example.project.Repository;

import com.example.project.Entity.Company;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("companyrepository")
public interface CompanyRepository extends JpaRepository <Company, Integer> {

}
