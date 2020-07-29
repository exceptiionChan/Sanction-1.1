package sanction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import sanction.exception.ResourceNotFoundException;
import sanction.model.Transaction;
import sanction.repository.TransactionRepository;
import sanction.service.SanctionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private SanctionService sanctionService;

    
    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() {    	              
        return transactionRepository.findAll();
    }
    
   @GetMapping("/screen")   
   public List<Transaction> screenAll(){
	   
	   List<Transaction> transactions = transactionRepository.findByStatus("Validate Pass");
		for (Transaction t : transactions) {
			sanctionService.screen(t);
			transactionRepository.save(t);
		} 
    	return transactionRepository.findAll();
   }
   
   @GetMapping("/screen/{id}")   
   public String screenTransaction(@PathVariable(value = "id") Long transactionId)
		   throws ResourceNotFoundException {
	   
	   Transaction transaction = transactionRepository.findById(transactionId)
			   .orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id :: " + transactionId));
	   
		sanctionService.screen(transaction);
		transactionRepository.save(transaction);
		return transaction.getStatus();
   }
    

}