package com.generation20.proyectofinal.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation20.proyectofinal.molde.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
	
	List<Event> findByIdUser(Integer idUser);
	List<Event> findByIdSport(Integer idSport);
	List<Event> findByEventDate(Date eventDate);
	List<Event> findByVisibilityAndEventDateBetweenOrderByEventDate(boolean visivility, Date firstDate, Date endDate);
	List<Event> findByVisibility(boolean visivility);
}
