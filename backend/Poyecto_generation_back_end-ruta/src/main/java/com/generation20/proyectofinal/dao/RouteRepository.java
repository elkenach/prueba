package com.generation20.proyectofinal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation20.proyectofinal.molde.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer>{

	Route findByIdPublication(Integer idPublication);
	Route findByIdEvent(Integer idEvent);
}
