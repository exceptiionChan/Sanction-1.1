package sanction.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import sanction.model.Transaction;

class SanctionServiceTest {

	@Autowired
	SanctionService sanctionService;
	
//	@Test
//	void testScreen() {
//		LocalDate currentdate = LocalDate.now();
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		String currD = dtf.format(currentdate);
//		
//		Transaction t = new Transaction();
//		t.setAmount("9849.0");
//		t.setDate(currD);
//		t.setPayeeAccount("123456789101");
//		t.setPayerAccount("908765432123");
//		t.setPayeeName("amal al sadah");
//		t.setPayerName("amalAl");
//		t.setTransacRef("567890432123");
//		t.setStatus("Validate Pass");
//		
//		sanctionService.screen(t);
//		
//		assertEquals("Screen Fail", t.getStatus());
//		
//	}
//	
//	@Test
//	void testScreenPass() {
//		LocalDate currentdate = LocalDate.now();
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		String currD = dtf.format(currentdate);
//		
//		Transaction t = new Transaction();
//		t.setAmount("9849.0");
//		t.setDate(currD);
//		t.setPayeeAccount("123456789101");
//		t.setPayerAccount("908765432123");
//		t.setPayeeName("Shalmalee");
//		t.setPayerName("Chhanam");
//		t.setTransacRef("567890432123");
//		t.setStatus("Validate Pass");
//		
//		sanctionService.screen(t);
//		
//		assertEquals("Screen Pass", t.getStatus());
//		
//	}
//	
//	@Test
//	void testScreenFail() {
//		LocalDate currentdate = LocalDate.now();
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		String currD = dtf.format(currentdate);
//		
//		Transaction t = new Transaction();
//		t.setAmount("9849.0");
//		t.setDate(currD);
//		t.setPayeeAccount("123456789101");
//		t.setPayerAccount("908765432123");
//		t.setPayeeName("Shalmalee");
//		t.setPayerName("Chhanam");
//		t.setTransacRef("567890432123");
//		t.setStatus("Validate Pass");
//		
//		sanctionService.screen(t);
//		
//		assertNotEquals("Screen Fail", t.getStatus());
//		
//	}
//	
//	@Test
//	void testPossibleScreenFail() {
//		LocalDate currentdate = LocalDate.now();
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		String currD = dtf.format(currentdate);
//		
//		Transaction t = new Transaction();
//		t.setAmount("9849.0");
//		t.setDate(currD);
//		t.setPayeeAccount("123456789101");
//		t.setPayerAccount("908765432123");
//		t.setPayeeName("Shalmalee");
//		t.setPayerName("OdamaBinLadin");
//		t.setTransacRef("567890432123");
//		t.setStatus("Validate Pass");
//		
//		sanctionService.screen(t);
//		
//		assertNotEquals("Possible Screen Fail", t.getStatus());
//		
//	}

	
}
