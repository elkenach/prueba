package com.generation20.proyectofinal.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.generation20.proyectofinal.molde.Publication;

public interface PublicationService {

	Publication save(Publication publication, MultipartFile file);
	List<Publication> getAll();
	List<Publication> getByVisibility();
	List<Publication> getAllByIdUser(Integer idUser);
	List<Publication> getByIdUserAndVisibility(Integer idUser);
	List<Publication> getAllByIdSport(Integer idSport);
	List<Publication> getByIdSportAndVisibiliy(Integer idSport);
	List<Publication> getAllByIdUserAndIdSport(Integer idUser, Integer idSport);
	List<Publication> getByIdUserAndIdSportAndVisibility(Integer idUser, Integer idSport);
	Publication update(Integer id, Publication publication);
	Publication getById(Integer id);
	Publication delete(Integer id);
}
