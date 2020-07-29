package sanction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class TransactionApplication {
	public static void main(String[] args) {
		SpringApplication.run(TransactionApplication.class, args);
	}
}

@Component
class DemoCommandLineRunner implements CommandLineRunner{

	@Autowired
	TextFileReader reader;
	@Override
	public void run(String... args) throws Exception {
		reader.getFileTransactions();
	}
}
