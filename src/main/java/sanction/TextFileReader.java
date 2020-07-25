package sanction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import sanction.model.Transaction;

public class TextFileReader {
	
	public List<Transaction> getFileTransactions() throws IOException {
		
	    // Open text file.
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("Transactions1.txt").getFile());
	    FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);	
	    String line;	 	 
        
	    List<Transaction> transactions = new LinkedList<Transaction>();
        // Read lines from file
	    while((line = reader.readLine()) != null){
	        
	    	Transaction t = new Transaction();													
        
            //Split each transaction fields
            String[] splittedData = line.split("\\s+");
                          
            if(splittedData.length != 4)
            	t.setRawPayment(line);           
            else {
	            t.setTransacRef(splittedData[0].substring(0, 12));
	            t.setDate(splittedData[0].substring(12, 20));
	            t.setPayerName(splittedData[0].substring(20));  
	            t.setPayerAccount(splittedData[1].substring(0, 12));                                                                                                             
	            t.setPayeeName(splittedData[1].substring(12));                              
	            t.setPayeeAccount(splittedData[2]);  
	            t.setAmount(splittedData[3]);          
            }
                                               
            t.validate();
            
            transactions.add(t);            
        }	    
        
	    //Close Resources
	    reader.close();
	    fr.close();
	    
	    return transactions;
    }
}
