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
    private String rawPayment;       
    
    /*public Transaction() {    	
		this.transacRef = null;
		this.date = null;
		this.payerName = null;
		this.payerAccount = null;
		this.payeeName = null;
		this.payeeAccount = null;
		this.amount = null;
		this.status = null;
		this.rawPayment =  null;
	}*/
 
    @Id
    @GeneratedValue()  //
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    @Column(name = "transac_ref")
	public String getTransacRef() {
		return transacRef;
	}

	public void setTransacRef(String transacRef) {
		this.transacRef = transacRef;
	}

	@Column(name = "date")
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Column(name = "payer_name")
	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	@Column(name = "payer_account")
	public String getPayerAccount() {
		return payerAccount;
	}

	public void setPayerAccount(String payerAccount) {
		this.payerAccount = payerAccount;
	}

	@Column(name = "payee_name")
	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	@Column(name = "payee_account")
	public String getPayeeAccount() {
		return payeeAccount;
	}

	public void setPayeeAccount(String payeeAccount) {
		this.payeeAccount = payeeAccount;
	}

	@Column(name = "amount")
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "raw_payment")
	public String getRawPayment() {
		return rawPayment;
	}

	public void setRawPayment(String rawPayment) {
		this.rawPayment = rawPayment;
	}
	
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", transacRef=" + transacRef + ", date=" + date + ", payerName=" + payerName
				+ ", payerAccount=" + payerAccount + ", payeeName=" + payeeName + ", payeeAccount=" + payeeAccount
				+ ", amount=" + amount + ", status=" + status + ", rawPayment=" + rawPayment + "]";
	}
	
	public void validate() {		
			
		if ( checkNumber(transacRef) &&
				checkDate() &&
				checkName(payerName) && 				
				checkName(payeeName) &&				
				checkNumber(payerAccount) &&
				checkNumber(payeeAccount) &&
				checkAmount()) {
			this.status = "Validate Pass";			
		}
		else {
			this.status = "Validate Fail";			
		}		
		
	}
	
	private boolean checkNumber(String number) {
		return number != null && checkAlphaNumeric(number) && number.length() == 12;
	}
	
	private boolean checkDate() {
		return checkDateFmt() && checkCurrDate();
	}
	
	private boolean checkName(String name) {
		return checkAlphaNumeric(name) && name.length() <= 35;
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
				SimpleDateFormat dbformat = new SimpleDateFormat("dd/MM/yyyy");
				this.date = dbformat.format(valDate);
				return true;
			} 
			catch (ParseException e) {				
				return false;
			}
		}		
		return false;
	}
		
	private boolean checkCurrDate() {
		LocalDate currentdate=LocalDate.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String d=dtf.format(currentdate);
		
		return this.date.equals(d);		
	}
	
	private boolean checkAlphaNumeric(String str) {
		return str != null && str.matches("[a-zA-Z0-9]+");		
	}
		
	private boolean checkAmount() {	
		
		if(this.amount.charAt(0) == '-')		
			return false;		
					
		String[] amt_div = this.amount.split("\\.");
			
		if(amt_div[0].length() <= 10 && amt_div[1].length() <= 2) 
			return true;
		return false;
	}

}
