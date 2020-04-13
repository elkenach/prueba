package com.generation20.proyectofinal.service;

import java.util.List;

import com.generation20.proyectofinal.molde.UserSport;

public interface UserSportService {

	UserSport save(UserSport userSport);
	List<UserSport> getSportsByIdUser(Integer idUser);
	List<UserSport> getUsersByIdSport(Integer idSport);
	List<UserSport> getAllSportsByIdUser(Integer idUser);
	List<UserSport> getAllUsersByIdSport(Integer idSport);
	UserSport remove(UserSport userSport);
	UserSport getById(Integer id);
	List<UserSport> getAll();
	UserSport getByIdUserAndIdSport(Integer idUser, Integer idSport);
	UserSport update(UserSport userSport);
}
