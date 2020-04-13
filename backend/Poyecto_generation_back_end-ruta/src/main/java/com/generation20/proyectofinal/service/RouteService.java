package com.generation20.proyectofinal.service;

import java.util.List;

import com.generation20.proyectofinal.molde.Route;

public interface RouteService {

	Route save(Route route);
	List<Route> getAll();
	Route getById(Integer id);
	Route update(Integer id, Route route);
	Route getByIdEvent(Integer idEvent);
	Route getByIdPublication(Integer idPublication);
}
