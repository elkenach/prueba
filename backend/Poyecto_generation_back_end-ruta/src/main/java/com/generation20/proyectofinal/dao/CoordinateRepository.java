package com.generation20.proyectofinal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation20.proyectofinal.molde.Coordinate;

@Repository
public interface CoordinateRepository extends JpaRepository<Coordinate, Integer>{

	List<Coordinate> findAllByIdRoute(Integer idRoute);
	void deleteAllById(Integer id);
}
