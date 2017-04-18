package com.javastud.springmvcweb.service;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

	public static final String FILE_PATH = "D:\\upload\\";

	public void saveFile(MultipartFile file) {
		// Save file in drive
		try {
			/*
				FileOutputStream out = new FileOutputStream(FILE_PATH + file.getOriginalFilename());
				out.write(file.getBytes());
				out.close();
			*/

			// OR
			file.transferTo(new File(FILE_PATH + file.getOriginalFilename()));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
