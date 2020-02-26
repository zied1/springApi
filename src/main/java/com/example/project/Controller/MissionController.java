package com.example.project.Controller;

import java.util.ArrayList;
import java.util.List;
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
import com.example.project.Services.EmployeService;
import com.example.project.Services.MissionService;

@RestController
public class MissionController {

	@Autowired
	private MissionService missionService;
	
	@Autowired
	private EmployeService empService;
	
	
	@GetMapping(path="/missions")
	
	public @ResponseBody Iterable<Mission> getAllMission(){
		return missionService.getAllMission();
	}
	
	@PostMapping(path="/missions/add/{idEmp}")
	public @ResponseBody  void addMission(@RequestBody Mission mission, @PathVariable int idEmp) {
		Optional <Employe> emp = empService.findById(idEmp);
		missionService.addMission(mission, emp);
		
	}
	
	@GetMapping(path="/missions/find/{id}")
	public Optional<Mission> findMissionById(@PathVariable int id) {
		return missionService.findMissionById(id);
	}
	
	@DeleteMapping(path="/missions/delete/{id}")
	public void deleteMission(@PathVariable int id) {
		 missionService.deleteMission(id);
	}
	
	@PostMapping(path="/employes/{idEmp}/missions/update/{id}")
	public void updateMission(@RequestBody Mission mission ,@PathVariable int id, @PathVariable int idEmp) {
		Optional<Employe> e =empService.findById(idEmp);
		missionService.updateMission(mission, id, e);
	}
	
}
