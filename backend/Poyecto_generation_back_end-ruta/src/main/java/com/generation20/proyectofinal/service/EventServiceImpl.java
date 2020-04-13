package com.generation20.proyectofinal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.generation20.proyectofinal.dao.EventRepository;
import com.generation20.proyectofinal.dao.SportRepository;
import com.generation20.proyectofinal.dao.UserRepository;
import com.generation20.proyectofinal.molde.Event;
import com.generation20.proyectofinal.molde.Route;
import com.generation20.proyectofinal.molde.Sport;
import com.generation20.proyectofinal.molde.User;

@Service
public class EventServiceImpl implements EventService{
	
	@Autowired
	private EventRepository eventRepository;
	@Autowired 
	private UserRepository userRepository;
	@Autowired
	private SportRepository sportRepository;
	@Autowired
	private StorageService storageService;
	@Autowired
	private RouteService routeService;

	
	@Override
	public List<Event> getAll() {
		return eventRepository.findAll();
	}
	@Override
	public List<Event> getAllByEventDate(Date eventDate) {
		return eventRepository.findByEventDate(eventDate);
	}
	@Override
	public List<Event> getAllByIdSport(Integer idSport) {
		return eventRepository.findByIdSport(idSport);
	}
	@Override
	public List<Event> getAllByIdUser(Integer idUser) {
		return eventRepository.findByIdUser(idUser);
	}
	@Override
	public Event save(Event event, MultipartFile file) {
		User user = userRepository.findById(event.getIdUser()).get();
		Sport sport = sportRepository.findById(event.getIdSport()).get();
		event.setNameAuthor(user.getUserName());
		event.setNameSport(sport.getName());
		event.setPhoto(storageService.uploadFile(file));
		Event eventSave =eventRepository.save(event);
		List<Route> routes = event.getRoute();
		for (Route route : routes) {
			route.setIdEvent(eventSave.getId());
			routeService.save(route);
		}
		event.setCreatedAt(new Date());
		event.setVisibility(true);
		return eventRepository.save(event);
	}
	@Override
	public Event getById(Integer id) {
		return eventRepository.findById(id).get();
	}
	@Override
	public Event update(Integer id, Event event) {
		Event eventDB = getById(id);
		eventDB.setDescription(event.getDescription());
		eventDB.setEventDate(event.getEventDate());
		eventDB.setEventTime(event.getEventTime());
		eventDB.setLink(event.getLink());
		eventDB.setPhoto(event.getPhoto());
		return eventRepository.save(eventDB);
	}
	@Override
	public List<Event> getByEventDateBetween(Date firstDate, Date endDate) {
		return eventRepository.findByVisibilityAndEventDateBetweenOrderByEventDate(true, firstDate, endDate);
	}
	@Override
	public Event remove(Integer id) {
		Event eventDB = getById(id);
		eventDB.setVisibility(false);
		return eventRepository.save(eventDB);
	}
	@Override
	public List<Event> getByVisibility() {
		return eventRepository.findByVisibility(true);
	}
}
