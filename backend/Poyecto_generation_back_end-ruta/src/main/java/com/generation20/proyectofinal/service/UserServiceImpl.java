package com.generation20.proyectofinal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.generation20.proyectofinal.dao.UserRepository;
import com.generation20.proyectofinal.molde.User;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private StorageService storageService;
	
	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}
	@Override
	public List<User> getVisible() {
		return userRepository.findByVisibility(true);
	}
	@Override
	public User remove(Integer id) {
		User userRemove = getById(id);
		userRemove.setVisibility(false);
		return userRepository.save(userRemove);
	}
	@Override
	public User getById(Integer id) {
		return userRepository.findById(id).get();
	}
	@Override
	public User save(User user) {
		String password = user.getPassword();
		String hashPass = BCrypt.withDefaults().hashToString(12, password.toCharArray());
		user.setPassword(hashPass);
		user.setVisibility(true);
		user.setCreatedAt(new Date());
		return userRepository.save(user);
	}
	@Override
	public User update(Integer id, User user) {
		User userDB = getById(id);
		userDB.setName(user.getName());
		userDB.setLastName(user.getLastName());
		userDB.setDescription(user.getDescription());
		userDB.setProfilePic(user.getProfilePic());
		return userRepository.save(userDB);
	}
	@Override
	public Integer verified(String email, String password) {
		User user = userRepository.findByEmail(email);
		if(user!=null){
			BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
			if(result.verified) {
				return user.getId();
			}else {
				return 0;
			}
		}else {
			return 0;
		}
	}
	@Override
	public User upload(Integer id, String description, MultipartFile file) {
		User user = getById(id);
		user.setProfilePic(storageService.uploadFile(file));
		user.setDescription(description);
		return userRepository.save(user);
	}
}
