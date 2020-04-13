package com.generation20.proyectofinal.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	String uploadFile(MultipartFile file);
	
}
