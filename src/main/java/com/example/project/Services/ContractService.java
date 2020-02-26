package com.example.project.Services;

import java.util.Optional;

import com.example.project.Entity.*;


public interface ContractService {

	public  Iterable<Contract> getAllContrat();
	
	public  void addContract(Contract contrat, Optional<Employe> emp);
	
	public  void updateContract(Contract contrat, int id);
	
	public  void deleteContract(int id);
	
	public  Optional<Contract> findContractById (int id);
}
