package com.example.project.Controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.Entity.*;
import com.example.project.Services.ContractService;
import com.example.project.Services.EmployeService;

@RestController
public class ContractController {

	@Autowired
	private ContractService contractService;
	
	@Autowired
	private EmployeService empService;
	
	@GetMapping(path="/contracts")
	
	public @ResponseBody Iterable<Contract> getAllContract(){
		return contractService.getAllContrat();
	}
	
	@PostMapping(path="/contracts/add/{idEmp}")
	public @ResponseBody  void addContract(@RequestBody Contract contract, @PathVariable int idEmp) {
		Optional<Employe> e = empService.findById(idEmp);
		contractService.addContract(contract, e);
	}
	
	@GetMapping(path="/contracts/find/{id}")
	public Optional<Contract> findContractById(@PathVariable int id) {
		return contractService.findContractById(id);
	}
	
	@DeleteMapping(path="/contracts/delete/{id}")
	public void delete(@PathVariable int id) {
		 contractService.deleteContract(id);
	}

	@PostMapping(path="/contracts/update/{id}")
	public void updateContract(@RequestBody Contract contrat ,@PathVariable int id) {
		contractService.updateContract(contrat, id);
	}

	
	
}
