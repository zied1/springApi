package com.example.project.Controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.Entity.Company;
import com.example.project.Entity.Employe;
import com.example.project.Exceptions.NotFoundException;
import com.example.project.Services.CompanyService;
import com.example.project.Services.EmployeService;

@RestController
public class EmployeController {

	@Autowired
	private EmployeService empService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
    private JavaMailSender javaMailSender;
 	
	
	@GetMapping(path="/employes")
	
	public @ResponseBody Iterable<Employe> getAllEmploye(){
		return empService.getAllEmploye();
	}
	
	@PostMapping(path="/employes/add/{idCompany}")
	public @ResponseBody  void addEmploye(@Valid @RequestBody Employe emp, @PathVariable int idCompany ) {
		Company c = companyService.findCompanyById(idCompany).orElseThrow(() -> new NotFoundException(idCompany,"Company"));		
		empService.addEmploye(emp, c);
	}
	
	@GetMapping(path="/employes/find/{id}")
	public Employe findById(@PathVariable int id) {
		return empService.findById(id).orElseThrow(() -> new NotFoundException(id,"Employe"));
	}
		
		
	
	@PostMapping(path="/employes/delete/{id}")
	public void delete(Employe emp, @PathVariable int id) {
		try {
		 empService.delete(id);}
		catch (Exception e) {
			throw new NotFoundException(id, "Employe");
		}
	}
	
	@PostMapping(path="/employes/update/{id}")
	public void update(@RequestBody Employe emp ,@PathVariable int id) {
		 empService.updateEmploye(emp, id);
	}
	
	@GetMapping(path="/sendmail")
	public  void sendEmail() {
		System.out.println("Sending Mail...");
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("zied0.jawedi@gmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

        System.out.println("Done !");
    }
}
