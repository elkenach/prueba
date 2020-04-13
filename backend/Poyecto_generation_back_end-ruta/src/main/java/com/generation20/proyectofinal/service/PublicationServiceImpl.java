package com.generation20.proyectofinal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.generation20.proyectofinal.dao.PublicationRepository;
import com.generation20.proyectofinal.dao.SportRepository;
import com.generation20.proyectofinal.dao.UserRepository;
import com.generation20.proyectofinal.molde.Publication;
import com.generation20.proyectofinal.molde.Sport;
import com.generation20.proyectofinal.molde.User;

@Service
public class PublicationServiceImpl implements PublicationService{

	@Autowired
	private PublicationRepository publicationRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SportRepository sportRepository;
	@Autowired
	private StorageService storageService;
	
	@Override
	public List<Publication> getAll() {
		return publicationRepository.findAll();
	}
	@Override
	public List<Publication> getAllByIdSport(Integer idSport) {
		return publicationRepository.findAllByIdSport(idSport);
	}
	@Override
	public List<Publication> getAllByIdUser(Integer idUser) {
		return publicationRepository.findAllByIdUser(idUser);
	}
	@Override
	public List<Publication> getAllByIdUserAndIdSport(Integer idUser, Integer idSport) {
		return publicationRepository.findAllByIdUserAndIdSport(idUser, idSport);
	}
	@Override
	public Publication save(Publication publication, MultipartFile file) {
		User user = userRepository.findById(publication.getIdUser()).get();
		Sport sport = sportRepository.findById(publication.getIdSport()).get();
		publication.setPhoto(storageService.uploadFile(file));
		publication.setCreatedAt(new Date());
		publication.setVisibility(true);
		publication.setNameAuthor(user.getUserName());
		publication.setNameSport(sport.getName());
		return publicationRepository.save(publication);
	}
	@Override
	public Publication update(Integer id, Publication publication) {
		Publication publicationDB = getById(id);
		publicationDB.setLink(publication.getLink());
		publicationDB.setPhoto(publication.getPhoto());
		publicationDB.setText(publication.getText());
		return publicationRepository.save(publicationDB);
	}
	@Override
	public Publication getById(Integer id) {
		return publicationRepository.findById(id).get();
	}
	@Override
	public Publication delete(Integer id) {
		Publication publication = getById(id);
		publication.setVisibility(false);
		return publicationRepository.save(publication);
	}
	@Override
	public List<Publication> getByIdSportAndVisibiliy(Integer idSport) {
		return publicationRepository.findByIdSportAndVisibility(idSport, true) ;
	}
	@Override
	public List<Publication> getByIdUserAndIdSportAndVisibility(Integer idUser, Integer idSport) {
		return publicationRepository.findByIdUserAndIdSportAndVisibility(idUser, idSport, true);
	}
	@Override
	public List<Publication> getByIdUserAndVisibility(Integer idUser) {
		return publicationRepository.findByIdUserAndVisibility(idUser, true);
	}
	@Override
	public List<Publication> getByVisibility() {
		return publicationRepository.findByVisibility(true);
	}
}
