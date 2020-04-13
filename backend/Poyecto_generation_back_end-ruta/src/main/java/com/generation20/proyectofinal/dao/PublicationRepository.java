package com.generation20.proyectofinal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation20.proyectofinal.molde.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer>{

	List<Publication> findByVisibility(boolean visibility);
	List<Publication> findAllByIdUser(Integer idUser);
	List<Publication> findByIdUserAndVisibility(Integer id, boolean visibility);
	List<Publication> findAllByIdSport(Integer idSport);
	List<Publication> findByIdSportAndVisibility(Integer id, boolean visibility);
	List<Publication> findAllByIdUserAndIdSport(Integer idUser, Integer idSport);
	List<Publication> findByIdUserAndIdSportAndVisibility(Integer idUser,Integer idSport, boolean visibility);
}
