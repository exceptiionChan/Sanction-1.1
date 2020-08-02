package sanction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import sanction.TextFileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.util.Date;

@Component
public class FileService {
	
	@Autowired
	private TextFileReader textFileReader;

	private long startTransacId;		

	private static final String FILE_DIRECTORY = "E:\\CITI\\";
	private Path filePath;

	public void storeFile(MultipartFile file) throws IOException {	

		filePath = Paths.get(FILE_DIRECTORY + "Unprocessed\\" + file.getOriginalFilename());

		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("Received Filepath = " + filePath);
		
		sendToReader();
	}

	private void sendToReader() throws IOException {
		setStartTransacId(textFileReader.getFileTransactions(filePath.toString()));
	}

	public void archiveFile() {
		
		String newFileName = getNewFileName();
		
		String src = FILE_DIRECTORY + "Unprocessed\\" + filePath.getFileName().toString();
		String dest = FILE_DIRECTORY + "Archived\\" + newFileName;
		
		Path result = null;
		try {
			result = Files.move(Paths.get(src), Paths.get(dest));
		} catch (IOException e) {
			System.out.println("Exception while moving file: " + e.getMessage());
		}
		if (result != null) 
			System.out.println("File moved successfully.");
		else 
			System.out.println("File moving failed.");
		
	}

	private String getNewFileName() {		

		// Date object
		Date date = new Date();
		// getTime() returns current time in milliseconds
		long time = date.getTime();
		// Passed the milliseconds to constructor of Timestamp class
		Timestamp ts = new Timestamp(time);
		
		//Remove extension ".txt"
		String newFilenm = filePath.getFileName().toString();
		newFilenm = newFilenm.substring(0, newFilenm.lastIndexOf("."));
		newFilenm += ts;	
		newFilenm = newFilenm.replace(' ','_');
		newFilenm = newFilenm.replace(':','.');
		newFilenm += ".txt";
		
		return newFilenm;
	}
	
	public long getStartTransacId() {
		return this.startTransacId;
	}

	public void setStartTransacId(long startTransacId) {
		this.startTransacId = startTransacId;
	}
}
