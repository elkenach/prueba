package com.generation20.proyectofinal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation20.proyectofinal.dao.SportRepository;
import com.generation20.proyectofinal.dao.UserSportRepository;
import com.generation20.proyectofinal.molde.Sport;
import com.generation20.proyectofinal.molde.UserSport;

@Service
public class UserSportServiceImpl implements UserSportService{

	@Autowired
	private UserSportRepository userSportRepository;
	@Autowired
	private SportRepository sportRepository;
	
	@Override
	public List<UserSport> getAllSportsByIdUser(Integer idUser) {
		return userSportRepository.findAllSportsByIdUser(idUser);
	}
	@Override
	public List<UserSport> getAllUsersByIdSport(Integer idSport) {
		return userSportRepository.findAllUsersByIdSport(idSport);
	}
	@Override
	public UserSport save(UserSport userSport) {
		Sport sport = sportRepository.findById(userSport.getIdSport()).get();
		userSport.setCreatedAt(new Date());
		userSport.setVisibility(true);
		userSport.setNameSport(sport.getName());
		return userSportRepository.save(userSport);
	}
	@Override
	public List<UserSport> getSportsByIdUser(Integer idUser) {
		return userSportRepository.findByIdUserAndVisibility(idUser, true);
	}
	@Override
	public List<UserSport> getUsersByIdSport(Integer idSport) {
		return userSportRepository.findByIdSportAndVisibility(idSport, true);
	}
	@Override
	public UserSport remove(UserSport userSport) {
		UserSport userSportRemove = getByIdUserAndIdSport(userSport.getIdUser(), userSport.getIdSport());
		userSportRemove.setVisibility(false);
		return userSportRepository.save(userSportRemove);
	}
	@Override
	public UserSport getById(Integer id) {
		return userSportRepository.findById(id).get();
	}
	@Override
	public List<UserSport> getAll() {
		return userSportRepository.findAll();
	}
	@Override
	public UserSport getByIdUserAndIdSport(Integer idUser, Integer idSport) {
		return userSportRepository.findByIdUserAndIdSport(idUser, idSport) ;
	}
	@Override
	public UserSport update(UserSport userSport) {
		UserSport userSportVisible = getByIdUserAndIdSport(userSport.getIdUser(),userSport.getIdSport());
		userSportVisible.setVisibility(true);
		return userSportRepository.save(userSportVisible);
	}
}
