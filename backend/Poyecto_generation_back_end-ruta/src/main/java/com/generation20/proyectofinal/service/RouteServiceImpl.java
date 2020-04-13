package com.generation20.proyectofinal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation20.proyectofinal.dao.RouteRepository;
import com.generation20.proyectofinal.molde.Coordinate;
import com.generation20.proyectofinal.molde.Route;

@Service
public class RouteServiceImpl implements RouteService{

	@Autowired
	private RouteRepository routeRepository;
	
	@Override
	public List<Route> getAll() {
		return routeRepository.findAll();
	}
	@Override
	public Route getById(Integer id) {
		return routeRepository.findById(id).get();
	}
	@Override
	public Route save(Route route) {
		Route routeSave = routeRepository.save(route);
		List<Coordinate> coordinates = route.getCoordinate();
		for (Coordinate coordinate : coordinates) {
			coordinate.setIdRoute(routeSave.getId());
			coordinate.setCreatedAt(new Date());
			coordinate.setnumberPoint(coordinates.indexOf(coordinate)+1);
		}
		route.setCreatedAt(new Date());
		return routeRepository.save(route);
	}
	@Override
	public Route update(Integer id, Route route) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Route getByIdEvent(Integer idEvent) {
		return routeRepository.findByIdEvent(idEvent);
	}
	@Override
	public Route getByIdPublication(Integer idPublication) {
		return routeRepository.findByIdPublication(idPublication);
	}
}
