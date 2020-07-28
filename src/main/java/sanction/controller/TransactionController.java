package sanction.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
//    @GetMapping("/transactions/{id}")
//    public ResponseEntity<Transaction> getTransactionById(@PathVariable(value = "id") Long transactionId)
//        throws ResourceNotFoundException {
//        Transaction transaction = transactionRepository.findById(transactionId)
//          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + transactionId));
//        return ResponseEntity.ok().body(transaction);
//    }
    
    
   @GetMapping("/screen")
   public List<Transaction> screenAll(){
    	sanctionService.screenAll(); 
    	return transactionRepository.findAll();
   }
    

}