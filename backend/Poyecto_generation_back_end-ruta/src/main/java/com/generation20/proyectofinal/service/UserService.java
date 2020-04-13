package com.generation20.proyectofinal.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.generation20.proyectofinal.molde.User;

public interface UserService {

	User save(User user);
	List<User> getAll();
	User getById(Integer id);
	User update(Integer id, User user);
	User remove(Integer id);
	List<User> getVisible();	
	Integer verified(String email, String password);
	User upload(Integer id, String description, MultipartFile file);
}
