package sanction.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sanction.model.Transaction;

@SpringBootTest
class ValidationServiceTest {

	@Autowired
	ValidationService validationService;
	
	@Test
	void testValidate() {
		
		LocalDate currentdate = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy");
		String currD = dtf.format(currentdate);
		
		Transaction t = new Transaction();
		t.setAmount("-9849.0");
		t.setDate(currD);
		t.setPayeeAccount("123456789101");
		t.setPayerAccount("908765432123");
		t.setPayeeName("abc");
		t.setPayerName("xyc");
		t.setTransacRef("567890432123");
		
		validationService.validate(t);
		assertEquals("Validate Fail", t.getStatus());
		
	}
	
	@Test
	void testValidateSuccess() {
		
		LocalDate currentdate = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy");
		String currD = dtf.format(currentdate);
		
		Transaction t = new Transaction();
		t.setAmount("9849.0");
		t.setDate(currD);
		t.setPayeeAccount("123456789101");
		t.setPayerAccount("908765432123");
		t.setPayeeName("abc");
		t.setPayerName("xyc");
		t.setTransacRef("567890432123");
		
		validationService.validate(t);
		assertEquals("Validate Pass", t.getStatus());
		
	}

	@Test
	void testValidateNegative() {
		
		LocalDate currentdate = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy");
		String currD = dtf.format(currentdate);
		
		Transaction t = new Transaction();
		t.setAmount("-9849.0");
		t.setDate(currD);
		t.setPayeeAccount("123456789101");
		t.setPayerAccount("908765432123");
		t.setPayeeName("abc");
		t.setPayerName("xyc");
		t.setTransacRef("567890432123");
		
		validationService.validate(t);
		assertNotEquals("Validate Pass", t.getStatus());
		assertEquals("Validate Fail", t.getStatus());
		
	}

//	@Test
//	void testIsUniqueTransacRef() {
//		fail("Not yet implemented");
//	}

}
