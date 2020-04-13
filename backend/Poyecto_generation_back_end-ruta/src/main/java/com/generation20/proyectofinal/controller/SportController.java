package com.generation20.proyectofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.generation20.proyectofinal.molde.Sport;
import com.generation20.proyectofinal.molde.UserSport;
import com.generation20.proyectofinal.service.SportService;
import com.generation20.proyectofinal.service.UserSportService;

@RestController
@RequestMapping("/v1/sports")
public class SportController {

	@Autowired
	private SportService sportService;
	@Autowired
	private UserSportService userSportService;
	
	@GetMapping
	public ResponseEntity<List<Sport>> getSports(){
		return new ResponseEntity<>(sportService.getByVisibility(), HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Sport>> getAllSport(){
		return new ResponseEntity<>(sportService.getAll(), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Sport> getSportById(@PathVariable ("id") Integer id) {
		return new ResponseEntity<>(sportService.getById(id), HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Sport> createSport(@RequestBody Sport sport) {
		return new ResponseEntity<>(sportService.save(sport), HttpStatus.CREATED);
	}
	@GetMapping("/{id}/users")
	public ResponseEntity<List<UserSport>> getUsersByIdSport(@PathVariable("id") Integer idSport){
		return new ResponseEntity<>(userSportService.getUsersByIdSport(idSport), HttpStatus.OK);
	}
	@PutMapping
	public ResponseEntity<Sport> updateSport(@RequestParam(value = "id") Integer idSport,
							@RequestBody Sport sport) {
		return new ResponseEntity<>(sportService.update(idSport, sport), HttpStatus.CREATED);
	}
	@DeleteMapping
	public ResponseEntity<Sport> removeSport(@RequestParam(value = "id") Integer idSport) {
		return new ResponseEntity<>(sportService.remove(idSport), HttpStatus.OK);
	}
}
