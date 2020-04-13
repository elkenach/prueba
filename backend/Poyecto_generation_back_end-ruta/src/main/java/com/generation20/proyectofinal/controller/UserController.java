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
import org.springframework.web.multipart.MultipartFile;

import com.generation20.proyectofinal.molde.User;
import com.generation20.proyectofinal.molde.UserSport;
import com.generation20.proyectofinal.service.UserService;
import com.generation20.proyectofinal.service.UserSportService;

@RestController
@RequestMapping("/v1/users")
public class UserController {
	
	@Autowired
	private UserService userService; 
	@Autowired
	private UserSportService userSportService;
	
	@GetMapping("/allUsers")
	public ResponseEntity<List<User>> getUsers(){
		return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<User>> getUserVisible(){
		return new ResponseEntity<>(userService.getVisible(), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<User> creatUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
	}
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestParam(value = "id") Integer id, @RequestBody User user) {
		return new ResponseEntity<>(userService.update(id, user), HttpStatus.CREATED);
	}
	@GetMapping("/{id}/sports")
	public ResponseEntity<List<UserSport>> getSportsByIdUser(@PathVariable("id") Integer idUser){
		return new ResponseEntity<>(userSportService.getSportsByIdUser(idUser), HttpStatus.OK);
	}
	@GetMapping("/{id}/allSports")
	public ResponseEntity<List<UserSport>> getAllSportsByIdUser(@PathVariable("id") Integer idUser){
		return new ResponseEntity<>(userSportService.getAllSportsByIdUser(idUser), HttpStatus.OK);
	}
	@DeleteMapping
	public ResponseEntity<User> deleteUser(@RequestParam(value = "id") Integer id) {
		return new ResponseEntity<>(userService.remove(id), HttpStatus.OK);
	}
	@PostMapping("/login")
	public ResponseEntity<Integer> loginUser(@RequestBody User user){
		Integer idUser = userService.verified(user.getEmail(), user.getPassword());
		if(idUser != 0) {
			return new ResponseEntity<>(idUser, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(idUser, HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<User> upload(@PathVariable("id") Integer id,
										@RequestParam("description") String description,
										@RequestParam("file") MultipartFile file){
		return new ResponseEntity<>(userService.upload(id, description, file), HttpStatus.CREATED);
	}
	
}
