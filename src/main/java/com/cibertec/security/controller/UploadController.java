package com.cibertec.security.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload/menu")
public class UploadController {
	

	@PostMapping
	public ResponseEntity<String> subirImagen(@RequestParam("file") MultipartFile file) {
	    try {
	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	        Path uploadPath = Paths.get("src/main/resources/static/img/menu");

	        if (!Files.exists(uploadPath)) {
	            Files.createDirectories(uploadPath);
	        }

	        Path filePath = uploadPath.resolve(fileName);
	        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

	        // Devuelve texto plano
	        return ResponseEntity.ok()
	            .contentType(MediaType.TEXT_PLAIN)
	            .body("/img/menu/" + fileName);
	    } catch (IOException e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	            .body("Error al subir imagen");
	    }
	}

}
