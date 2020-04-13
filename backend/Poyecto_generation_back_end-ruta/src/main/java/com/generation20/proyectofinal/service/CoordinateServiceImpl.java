package com.generation20.proyectofinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation20.proyectofinal.dao.CoordinateRepository;
import com.generation20.proyectofinal.molde.Coordinate;

@Service
public class CoordinateServiceImpl implements CoordinateService {

	@Autowired
	private CoordinateRepository coordinateRepository;
	
	@Override
	public void deleted(Integer idRoute) {
		coordinateRepository.deleteAllById(idRoute);
	}
	@Override
	public List<Coordinate> getAllByIdRoute(Integer idRoute) {
		return coordinateRepository.findAllByIdRoute(idRoute);
	}
	@Override
	public Coordinate save(Coordinate coordinate) {
		return coordinateRepository.save(coordinate);
	}
}
