package com.generation20.proyectofinal.service;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.generation20.proyectofinal.molde.Event;

public interface EventService {

	Event save(Event event, MultipartFile file);
	Event update(Integer id, Event event);
	List<Event> getAll();
	Event getById(Integer id);
	List<Event> getAllByIdUser(Integer idUser);
	List<Event> getAllByIdSport(Integer idSport);
	List<Event> getAllByEventDate(Date eventDate);
	List<Event> getByEventDateBetween(Date firstDate, Date endDate);
	List<Event> getByVisibility();
	Event remove(Integer id);
}
