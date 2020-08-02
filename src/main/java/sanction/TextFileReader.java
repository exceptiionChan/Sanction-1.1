package sanction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sanction.model.Transaction;
import sanction.repository.TransactionRepository;
import sanction.service.FileService;
import sanction.service.ValidationService;

@Component
public class TextFileReader {
	@Autowired
	private ValidationService ts;

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private FileService fileService;

	public long getFileTransactions(String filePath) throws IOException {
		
		File file = new File(filePath);
	    FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);	
	    String line;	 	 
        boolean isFirstTransac = true;        
	    long firstTransacId = 0;
	    
	    // Read lines from file
	    while((line = reader.readLine()) != null){
	        
	    	if(line.isEmpty())
	    		continue;
	    	
	    	Transaction t = new Transaction();													
        
            //Split each transaction fields
            String[] splittedData = line.split("\\s+");
                          
            if(splittedData.length != 4)
            	t.setRawPayment(line);           
            else {
            	try {
		            t.setTransacRef(splittedData[0].substring(0, 12));
		            t.setDate(splittedData[0].substring(12, 20));
		            t.setPayerName(splittedData[0].substring(20));  
		            t.setPayerAccount(splittedData[1].substring(0, 12));                                                                                                             
		            t.setPayeeName(splittedData[1].substring(12));                              
		            t.setPayeeAccount(splittedData[2]);  
		            t.setAmount(splittedData[3]);   
            	}
            	catch(Exception e) {
            		t.setRawPayment(line);
            	}
            }
            
                                
            
            ts.validate(t);             
            transactionRepository.save(t);  
            
            if(isFirstTransac) {
            	firstTransacId = t.getId();
            	isFirstTransac = false;
            }   
            
        }	    	    		 			  
	    
	    //Close Resources
	    reader.close();
	    fr.close();
	    	    
	    fileService.archiveFile();
	    
	    return firstTransacId;
	    	  
    }
}

