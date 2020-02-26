package com.example.project.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.Entity.Employe;


@Repository("employeRepository")
public interface EmployeRepository extends JpaRepository<Employe, Integer> {


}
