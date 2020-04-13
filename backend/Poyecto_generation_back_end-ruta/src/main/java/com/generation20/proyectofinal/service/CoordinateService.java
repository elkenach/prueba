package com.generation20.proyectofinal.service;

import java.util.List;

import com.generation20.proyectofinal.molde.Coordinate;

public interface CoordinateService {

	Coordinate save(Coordinate coordinate);
	List<Coordinate> getAllByIdRoute(Integer idRoute);
	void deleted(Integer idRoute);
}
