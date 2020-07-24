package sanction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import sanction.model.Transaction;
import sanction.repository.TransactionRepository;

@SpringBootApplication
public class TransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionApplication.class, args);
	}

}

@Component
class DemoCommandLineRunner implements CommandLineRunner{

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public void run(String... args) throws Exception {

		TextFileReader reader = new TextFileReader();
		List<Transaction> transactions = reader.getFileTransactions();
		for(Transaction t : transactions)  
			transactionRepository.save(t);

	}
}
