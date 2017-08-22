package com.javastud.springmvcweb.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.javastud.springmvcweb.service.FileStorageService;

@Controller
public class FileUploadDownloadController {

	@Autowired
	private FileStorageService fileStorageService;

	@GetMapping("/upload")
	public ModelAndView uploadGET(){
		ModelAndView mv = new ModelAndView("fileUpload");
		return mv;
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadPOST(@RequestParam("file") MultipartFile files[], Model model)
			throws UnsupportedEncodingException {

		List<String> fileNames = new ArrayList<>();

		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				
				// Save file in drive
				fileStorageService.saveFile(file);

				fileNames.add(URLEncoder.encode(file.getOriginalFilename(), "UTF-8"));
			}
		}
		model.addAttribute("successMsg", "File Upload success, No of files: " + fileNames.size());
		model.addAttribute("fileNames", fileNames);

		return "fileUpload";
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void download(@RequestParam("file") String fileName, HttpServletResponse response) throws IOException {

		if (!StringUtils.isEmpty(fileName)) {

			fileName = URLDecoder.decode(fileName, "UTF-8");

			File imagePath = new File(FileStorageService.FILE_PATH + fileName);
			if (imagePath.exists()) {

				String ext = FilenameUtils.getExtension(fileName);

				// Set Header
				if (ext.equals("png") || ext.equals("jpg") || ext.equals("jpeg")) {
					response.setContentType("image/" + ext);
				} else if (ext.equals("pdf")) {
					response.setContentType("application/" + ext);
				}
				response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

				// Copy file stream and write in response writer or outputstream
				FileCopyUtils.copy(new FileInputStream(imagePath), response.getOutputStream());
				
				//OR
				/*
					PrintWriter out = response.getWriter();
					FileInputStream fin = new FileInputStream(imagePath);
	
					int i = 0;
					while ((i = fin.read()) != -1) {
						out.write(i);
					}
					fin.close();
					out.close();
				*/

			}

		}

	}

}
