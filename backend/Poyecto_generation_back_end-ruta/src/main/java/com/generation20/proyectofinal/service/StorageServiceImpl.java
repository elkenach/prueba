package com.generation20.proyectofinal.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Acl.Role;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;

@Service
public class StorageServiceImpl implements StorageService {

	@Autowired
	private Storage storage;
	
	@SuppressWarnings("deprecation")
	@Override
	public String uploadFile(MultipartFile file) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String stringDateFormat = dateFormat.format(new Date());
		String fileType = file.getContentType().toString().substring(6);
		String fileName = stringDateFormat + "." + fileType;
		BlobInfo blobInfo = BlobInfo.newBuilder("proyecto_generation", fileName)
				.setAcl(new ArrayList<>(Arrays.asList(Acl.of(User.ofAllUsers(), Role.READER)))).build();
		try {
			BlobInfo createdBlobInfo = storage.create(blobInfo, file.getInputStream());
			return createdBlobInfo.getMediaLink();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "https://www.pensandoenweb.es/wp-content/uploads/2013/07/error_500.png";
	}
}
