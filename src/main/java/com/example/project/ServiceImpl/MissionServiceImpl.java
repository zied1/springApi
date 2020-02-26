package com.example.project.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Entity.Employe;
import com.example.project.Entity.Mission;
import com.example.project.Repository.MissionRepository;
import com.example.project.Services.MissionService;

@Service
public class MissionServiceImpl implements MissionService{
	
	@Autowired
	private MissionRepository missionRep;

	@Override
	public Iterable<Mission> getAllMission() {
		return missionRep.findAll();
	}

	@Override
	public void addMission(Mission mission, Optional<Employe> emp) {
		mission.setemp(emp.get());
		missionRep.save(mission);
		
	}

	@Override
	public void updateMission(Mission mission, int id,  Optional<Employe> emp) {
		Mission m = findMissionById(id).get();
		m.setemp(emp.get());
		m.setDescription(mission.getDescription());
		missionRep.save(m);
		
	}

	@Override
	public void deleteMission(int id) {
		missionRep.deleteById(id);
		
	}

	@Override
	public Optional<Mission> findMissionById(int id) {
		
		return missionRep.findById(id);
	}

}
