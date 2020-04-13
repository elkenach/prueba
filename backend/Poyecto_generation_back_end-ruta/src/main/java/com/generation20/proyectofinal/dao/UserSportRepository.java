package com.generation20.proyectofinal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation20.proyectofinal.molde.UserSport;

@Repository
public interface UserSportRepository extends JpaRepository<UserSport, Integer>{
	
	List<UserSport> findByIdUserAndVisibility(Integer idUser, boolean Visibility);
	List<UserSport> findByIdSportAndVisibility(Integer idSport, boolean Visibility);
	List<UserSport> findAllUsersByIdSport(Integer idSport);
 	List<UserSport> findAllSportsByIdUser(Integer idUser);
 	UserSport findByIdUserAndIdSport(Integer idUser, Integer idSport);
}
