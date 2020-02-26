package com.example.project.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Entity.Contract;
import com.example.project.Entity.Employe;
import com.example.project.Repository.ContractRepository;
import com.example.project.Services.ContractService;

@Service("contractservice")
public class ContractServiceImpl implements ContractService{
	
	@Autowired
	private ContractRepository contractRep;

	@Override
	public Iterable<Contract> getAllContrat() {
		
		return contractRep.findAll();
	}

	@Override
	public void addContract(Contract contrat, Optional<Employe> emp) {
		contrat.setemp(emp.get());
		contractRep.save(contrat);
		
	}

	@Override
	public void updateContract(Contract contract, int id) {
		Contract c = findContractById(id).get();
		c.setDuration(contract.getDuration());
		c.setType(contract.getDuration());
		c.setemp(c.getemp());
		contractRep.save(c);
		
		
	}

	@Override
	public void deleteContract(int id) {
		contractRep.deleteById(id);
		
	}

	@Override
	public Optional<Contract> findContractById(int id) {
		return contractRep.findById(id);
	}

}
