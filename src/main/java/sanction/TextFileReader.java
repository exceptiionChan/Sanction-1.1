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
            String[] fields = line.split("\\s+");
                   
            //Split at digit-letter boundary         
            String[] payer_Details=fields[0].split("(?<=\\d)(?=\\D)");
            String[] payee_Details=fields[1].split("(?<=\\d)(?=\\D)");
                                       
            t.setTransacRef(fields[2]);
            t.setDate(payer_Details[0].substring(12, 20));  
            t.setPayerName(payer_Details[1]);  
            t.setPayerAccount(payer_Details[0].substring(0, 12));                                                                                                             
            t.setPayeeName(payee_Details[1]);                              
            t.setPayeeAccount(payee_Details[0]);  
            t.setAmount(fields[3]);
            t.setUnprocessedPayment("-");
                                               
            t.validate();    
            
            transactions.add(t);
            
        }	    
        
	    //Close Resources
	    reader.close();
	    fr.close();
	    
	    return transactions;
    }
}

