package com.javastud.springmvcweb.controller;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class FileUploadController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "fileUpload";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile file, Model model) throws IOException {
		byte[] bytes;

		if (!file.isEmpty()) {
			bytes = file.getBytes();
			
			//Write in file.
			FileOutputStream out = new FileOutputStream( "D:\\temp\\"+ file.getOriginalFilename() );
			out.write(bytes);
			out.close();
		}

		System.out.println( "Received File:" + file.getOriginalFilename() );
		
		model.addAttribute("successMsg", "File upload Success: "+ file.getOriginalFilename());
		return "fileUpload";
	}
}
