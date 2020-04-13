package com.generation20.proyectofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.generation20.proyectofinal.molde.Publication;
import com.generation20.proyectofinal.service.PublicationService;

@RestController
@RequestMapping("/v1/publications")
public class PublicationController {

	@Autowired
	private PublicationService publicationService;
	
	@PostMapping
	public ResponseEntity<Publication> createPublication(
			@RequestParam("publication") String publicationJson,
			@RequestParam("file") MultipartFile file) {
		Publication publication = null;
		try {
			publication = new ObjectMapper().readValue(publicationJson, Publication.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(publicationService.save(publication,file), HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Publication>> getAllPublication(){
		return new ResponseEntity<>(publicationService.getAll(), HttpStatus.OK);
	}
	@GetMapping("/by")
	public ResponseEntity<Publication> getByIdPublication(@RequestParam(value = "id") Integer id){
		return new ResponseEntity<>(publicationService.getById(id), HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<Publication>> getPublication(){
		return new ResponseEntity<>(publicationService.getByVisibility(), HttpStatus.OK);
	}
	@GetMapping("/user")
	public ResponseEntity<List<Publication>> getPublicationsByIdUser(@RequestParam(value = "idUser") Integer idUser){
		return new ResponseEntity<>(publicationService.getByIdUserAndVisibility(idUser), HttpStatus.OK);
	}
	@GetMapping("/user/all")
	public ResponseEntity<List<Publication>> getAllPublicationsByIdUser(@RequestParam(value = "idUser") Integer idUser){
		return new ResponseEntity<>(publicationService.getAllByIdUser(idUser), HttpStatus.OK);
	}
	@GetMapping("/sport")
	public ResponseEntity<List<Publication>> getPublicationByIdSport(@RequestParam(value = "idSport") Integer idSport){
		return new ResponseEntity<>(publicationService.getByIdSportAndVisibiliy(idSport), HttpStatus.OK);
	}
	@GetMapping("/sport/all")
	public ResponseEntity<List<Publication>> getAllPublicationByIdSport(@RequestParam(value = "idSport") Integer idSport){
		return new ResponseEntity<>(publicationService.getAllByIdSport(idSport), HttpStatus.OK);
	}
	@GetMapping("/userAndSport/all")
	public ResponseEntity<List<Publication>> getAllPublicationsByIdUserAndIdSport(
			@RequestParam(value = "idUser") Integer idUser,
			@RequestParam(value = "idsport")Integer idSport){
		return new ResponseEntity<>(publicationService.getAllByIdUserAndIdSport(idUser, idSport), HttpStatus.OK);
	}
	@GetMapping("/userAndSport")
	public ResponseEntity<List<Publication>> getPublicationsByIdUserAndIdSport(
			@RequestParam(value = "idUser") Integer idUser,
			@RequestParam(value = "idsport")Integer idSport){
		return new ResponseEntity<>(publicationService.getByIdUserAndIdSportAndVisibility(idUser, idSport), HttpStatus.OK);
	}
	@PutMapping
	public ResponseEntity<Publication> update(@RequestParam(value = "id") Integer idUserSport,
							@RequestBody Publication publication) {
		return new ResponseEntity<>(publicationService.update(idUserSport, publication), HttpStatus.CREATED);
	}
	@DeleteMapping
	public ResponseEntity<Publication> delete(@RequestParam(value = "id") Integer idUserSport) {
		return new ResponseEntity<>(publicationService.delete(idUserSport), HttpStatus.OK);
	}
}
