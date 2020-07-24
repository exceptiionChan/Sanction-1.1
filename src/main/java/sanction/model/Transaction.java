package sanction.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {
	
	private long id;	
	private String transacRef;
	private String date;
    private String payerName;
    private String payerAccount;
    private String payeeName;
    private String payeeAccount;
    private String amount;
    private String status;
    private String unprocessedPayment;
    
    public Transaction() {
    	  
    }
    
    public Transaction(String transacRef, String date, String payerName, String payerAccount, String payeeName,
			String payeeAccount, String amount, String status, String unprocessedPayment) {
		this.transacRef = transacRef;
		this.date = date;
		this.payerName = payerName;
		this.payerAccount = payerAccount;
		this.payeeName = payeeName;
		this.payeeAccount = payeeAccount;
		this.amount = amount;
		this.status = status;
		this.unprocessedPayment =  unprocessedPayment;
	}
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    @Column(name = "transac_ref", nullable = false)
	public String getTransacRef() {
		return transacRef;
	}

	public void setTransacRef(String transacRef) {
		this.transacRef = transacRef;
	}

	@Column(name = "date", nullable = false)
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Column(name = "payer_name", nullable = false)
	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	@Column(name = "payer_account", nullable = false)
	public String getPayerAccount() {
		return payerAccount;
	}

	public void setPayerAccount(String payerAccount) {
		this.payerAccount = payerAccount;
	}

	@Column(name = "payee_name", nullable = false)
	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	@Column(name = "payee_account", nullable = false)
	public String getPayeeAccount() {
		return payeeAccount;
	}

	public void setPayeeAccount(String payeeAccount) {
		this.payeeAccount = payeeAccount;
	}

	@Column(name = "amount", nullable = false)
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Column(name = "status", nullable = false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "unprocessed_payment", nullable = false)
	public String getUnprocessedPayment() {
		return unprocessedPayment;
	}

	public void setUnprocessedPayment(String unprocessedPayment) {
		this.unprocessedPayment = unprocessedPayment;
	}
	
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", transacRef=" + transacRef + ", date=" + date + ", payerName=" + payerName
				+ ", payerAccount=" + payerAccount + ", payeeName=" + payeeName + ", payeeAccount=" + payeeAccount
				+ ", amount=" + amount + ", status=" + status + ", unprocessedPayment=" + unprocessedPayment + "]";
	}
	
	public void validate() {		
			
		if ( checkDateFmt() &&
				checkCurrDate() &&
				checkName(payerName) && 
				checkName(payeeName) &&
				checkNumber(transacRef) &&
				checkNumber(payerAccount) &&
				checkNumber(payeeAccount) &&
				checkAmount()) {
			this.status = "PASS";			
		}
		else {
			this.status = "FAIL";			
		}		
		
	}
	
	private boolean checkDateFmt() {		
		
		if(this.date.matches("[0-9]{2}[0-9]{2}[0-9]{4}"))
		{
			//Initializing a format
			SimpleDateFormat sdf=new SimpleDateFormat("ddMMyyyy");
			sdf.setLenient(false);
			
			//Comparing valueDate with expected format
			try {
				Date valDate=sdf.parse(this.date);
				return true;
			} 
			catch (ParseException e) {				
				return false;
			}
		}		
		return false;
	}
	
	private boolean checkCurrDate() {
		LocalDate localdate=LocalDate.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("ddMMyyyy");
		String d=dtf.format(localdate);
		
		return date.equals(d);
		
	}
	
	private boolean checkName(String name) {
		return name != null && name.chars().allMatch(Character::isLetter) && name.length()<=35;		
	}
	
	private boolean checkNumber(String num) {
		return num != null && num.matches("^[a-zA-Z0-9]*$") && num.length()==12;		
	}
	
	private boolean checkAmount() {	
		//if (this.amount < 0.0) {
		if(this.amount.charAt(0) == '-') {		
			return false;
		}
			
		//String[] amt_div = Float.toString(amount).split("\\.");
		String[] amt_div = this.amount.split("\\.");
			
		if(amt_div[0].length() <= 10 && amt_div[1].length() <= 2) 
			return true;
		return false;
	}
		

 
}
