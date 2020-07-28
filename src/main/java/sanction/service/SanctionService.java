package sanction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sanction.model.Keyword;
import sanction.model.Transaction;
import sanction.repository.KeywordRepository;
import sanction.repository.TransactionRepository;

@Service
public class SanctionService {

	@Autowired
	private DistanceAlgoService algoservice;
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private KeywordRepository keywordRepository;

	public void screenAll(Transaction t) {

		/*
		 * List<Transaction> transactions =
		 * transactionRepository.findByStatus("Valid Pass");
		 * 
		 * for(Transaction t:transactions) {
		 */

		double payeePercent = getPercent(t.getPayeeName());
		double payerPercent = getPercent(t.getPayerName());

		System.out.println("PayeePercent =" + payeePercent);
		System.out.println("PayerPercent =" + payerPercent);

		double max = 0;
		max = payerPercent > payeePercent ? payerPercent : payeePercent;

		System.out.println("Final percent = " + max);

		t.setStatus(decideStatus(max));
		System.out.println(t.getStatus());

	}

	private double getPercent(String name) {

		List<Keyword> keywords = keywordRepository.findAll();
		double max = 0;
		for (Keyword k : keywords) {
			double percent = algoservice.getSimilarity(k.getName(), name.toLowerCase());

			if (max < percent) {
				max = percent;
			}
		}

		return max;
	}

	private String decideStatus(double percent) {

		if (percent <= 0.75) 						// cutoff to pass sanction screening
			return "Screen Pass";

		else if (percent > 0.75 && percent <= 0.85) // region of possible sanction hits
			return "Possible Screen Pass";

		else 										// sanction hit
			return "Screen Fail";
	}

}
