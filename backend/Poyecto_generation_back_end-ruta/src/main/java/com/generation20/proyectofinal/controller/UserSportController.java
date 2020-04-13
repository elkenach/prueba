package com.generation20.proyectofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation20.proyectofinal.molde.UserSport;
import com.generation20.proyectofinal.service.UserSportService;

@RestController
@RequestMapping("/v1/userSport")
public class UserSportController {

	@Autowired
	private UserSportService userSportService;
	
	@GetMapping
	public ResponseEntity<List<UserSport>> getAllUserSport(){
		return new ResponseEntity<>(userSportService.getAll(), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<UserSport> getUserSportById(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(userSportService.getById(id), HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<UserSport> createRelationUserSport(@RequestBody UserSport userSport) {
		
		if(userSportService.getByIdUserAndIdSport(userSport.getIdUser(), userSport.getIdSport()) == null) {
			return new ResponseEntity<>(userSportService.save(userSport), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(userSportService.update(userSport), HttpStatus.CREATED);
		}
	}
	@DeleteMapping
	public ResponseEntity<UserSport> deleteUserSport(@RequestBody UserSport userSport) {
		return new ResponseEntity<>(userSportService.remove(userSport), HttpStatus.OK);
	}
}
