package sanction.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sanction.model.Transaction;
import sanction.repository.TransactionRepository;

@Service
public class ValidationService {

	@Autowired
	private TransactionRepository transactionRepository;

	public void validate(Transaction t) {

		boolean isValid = true;
		
		System.out.println(t.toString());
		if (t.getTransacRef() == null || !checkNumber(t.getTransacRef())) {
			isValid = false;
			System.out.println("Transaction Ref not aplanumeric");
		}

		if (t.getDate() == null || !checkDateFmt(t.getDate())) {
			isValid = false;
			System.out.println("Date Format");
		} else {
			try {
				t.setDate(formatDate(t.getDate()));
			} catch (ParseException e) {
			}
		}

		try {
			if (t.getDate() == null || !isCurrDate(t.getDate())) {
				isValid = false;
				System.out.println("Date not Current");
			}
		} catch (ParseException e) {
		}

		if (t.getPayerName() == null || !checkName(t.getPayerName())) {
			isValid = false;
			System.out.println("Payer Name");
		}

		if (t.getPayeeName() == null || !checkName(t.getPayeeName())) {
			isValid = false;
			System.out.println("Payee Name");
		}

		if (t.getPayerAccount() == null || !checkNumber(t.getPayerAccount())) {
			isValid = false;
			System.out.println("Payer Account");
		}

		if (t.getPayeeAccount() == null || !checkNumber(t.getPayeeAccount())) {
			isValid = false;
			System.out.println("Payee Account");
		}

		if (t.getAmount() == null || !checkAmount(t.getAmount())) {
			isValid = false;
			System.out.println("Amount");
		}

		if (t.getTransacRef() == null || !isUniqueTransacRef(t.getTransacRef())) {
			isValid = false;
			System.out.println("Not unique Reference");
		}

		if (isValid)
			t.setStatus("Validate Pass");

		else
			t.setStatus("Validate Fail");

	}

	public boolean isUniqueTransacRef(String transacRef) {
		List<Transaction> results = transactionRepository.findByTransacRef(transacRef);
		return results.size() == 0;
	}

	private boolean checkNumber(String number) {
		return number != null && checkAlphaNumeric(number) && number.length() == 12;
	}

	private boolean checkName(String name) {
		return checkAlphaNumeric(name) && name.length() <= 35;
	}

	private boolean checkDateFmt(String date) {

		if (date.matches("[0-9]{2}[0-9]{2}[0-9]{4}")) {
			try {
				formatDate(date);
				return true;
			} catch (ParseException e) {
				return false;
			}
		}
		return false;
	}

	private String formatDate(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		sdf.setLenient(false);

		Date valDate = sdf.parse(date);
		SimpleDateFormat dbformat = new SimpleDateFormat("dd/MM/yyyy");
		date = dbformat.format(valDate);

		return date;
	}

	private boolean isCurrDate(String date) throws ParseException {
		LocalDate currentdate = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String d = dtf.format(currentdate);

		return formatDate(date).equals(d);
	}

	private boolean checkAlphaNumeric(String str) {
		return str != null && str.matches("[a-zA-Z0-9]+");
	}

	private boolean checkAmount(String amount) {
		if (amount.charAt(0) == '-')
			return false;

		String[] amt_div = amount.split("\\.");

		if (amt_div[0].length() <= 10 && amt_div[1].length() <= 2)
			return true;
		return false;
	}

}
