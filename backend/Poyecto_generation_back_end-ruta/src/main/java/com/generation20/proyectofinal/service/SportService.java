package com.generation20.proyectofinal.service;

import java.util.List;

import com.generation20.proyectofinal.molde.Sport;

public interface SportService {

	Sport save(Sport sport);
	List<Sport> getAll();
	Sport getById(Integer id);
	Sport update(Integer id, Sport sport);
	Sport remove(Integer idSport);
	List<Sport> getByVisibility();
}
