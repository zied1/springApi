package com.example.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.Entity.Mission;

@Repository("missionrepository")
public interface MissionRepository extends JpaRepository<Mission, Integer>{

}
