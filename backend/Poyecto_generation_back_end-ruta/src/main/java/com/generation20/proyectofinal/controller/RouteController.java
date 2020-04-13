package com.generation20.proyectofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.generation20.proyectofinal.molde.Route;
import com.generation20.proyectofinal.service.RouteService;

@RestController
@RequestMapping("v1/routes")
public class RouteController {

	@Autowired
	private RouteService routeService;

	@GetMapping
	public ResponseEntity<Route> getById(@RequestParam(value = "id") Integer id){
		return new ResponseEntity<>(routeService.getById(id), HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Route>> getAll(){
		return new ResponseEntity<>(routeService.getAll(), HttpStatus.OK);
	}
	@GetMapping("/publication")
	public ResponseEntity<Route> getByIdPublication(@RequestParam(value = "idPublication") Integer idPublication){
		return new ResponseEntity<>(routeService.getByIdPublication(idPublication), HttpStatus.OK);
	}
	@GetMapping("/event")
	public ResponseEntity<Route> getByIdEvent(@RequestParam(value = "idEvent") Integer idEvent){
		return new ResponseEntity<>(routeService.getByIdEvent(idEvent), HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Route> createRoute(@RequestParam(value = "route") String jsonRoute){
		Route route = null;
		try {
			route = new ObjectMapper().readValue(jsonRoute, Route.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(routeService.save(route), HttpStatus.CREATED);
	}
	
}
