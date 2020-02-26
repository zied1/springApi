package com.example.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.Entity.Contract;

@Repository("contractrepository")
public interface ContractRepository extends JpaRepository<Contract, Integer>{

}
