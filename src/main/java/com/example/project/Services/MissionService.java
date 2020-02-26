package com.example.project.Services;

import java.util.Optional;


import com.example.project.Entity.Employe;
import com.example.project.Entity.Mission;

public interface MissionService {

	public Iterable<Mission> getAllMission();
	
	public void addMission(Mission mission, Optional<Employe> emp);
	
	public  void updateMission(Mission mission, int id, Optional<Employe> emp);
	
	public void deleteMission(int id);
	
	public Optional<Mission> findMissionById (int id);

	
}
