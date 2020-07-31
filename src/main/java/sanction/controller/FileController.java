package sanction.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;

import sanction.service.FileService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FileController {
 
	private final FileService fileService;
 
	@Autowired
	public FileController(FileService fileService) {
		this.fileService = fileService;
	}
 
	@PostMapping(value = "/upload")
	@ResponseStatus(HttpStatus.OK)
	public void handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println("File Entered Controller");
		fileService.storeFile(file);
	}
 
}