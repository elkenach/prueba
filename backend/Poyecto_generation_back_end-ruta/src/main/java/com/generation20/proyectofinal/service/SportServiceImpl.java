package com.generation20.proyectofinal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation20.proyectofinal.dao.SportRepository;
import com.generation20.proyectofinal.molde.Sport;

@Service
public class SportServiceImpl implements SportService{

	@Autowired
	private SportRepository sportRepository;
	
	@Override
	public List<Sport> getAll() {
		return sportRepository.findAll();
	}
	@Override
	public Sport getById(Integer id) {
		return sportRepository.findById(id).get();
	}
	@Override
	public Sport remove(Integer id) {
		Sport sport = getById(id);
		sport.setVisibility(false);
		return sportRepository.save(sport);
	}
	@Override
	public Sport save(Sport sport) {
		sport.setCreatedAt(new Date());
		sport.setVisibility(true);
		return sportRepository.save(sport);
	}
	@Override
	public Sport update(Integer id, Sport sport) {
		Sport sportDB = getById(id);
		sportDB.setDescription(sport.getDescription());
		sportDB.setPhoto(sport.getPhoto());
		return sportRepository.save(sportDB);
	}
	@Override
	public List<Sport> getByVisibility() {
		return sportRepository.findByVisibility(true);
	}
}
