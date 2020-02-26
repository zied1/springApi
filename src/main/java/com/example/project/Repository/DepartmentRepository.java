package com.example.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.Entity.Department;

@Repository("departmentrepository")
public interface DepartmentRepository  extends JpaRepository <Department, Integer>{

}
