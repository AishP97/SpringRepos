
public class Account {
	private String accountNumber;
	private String accountHolderName;
	private String accounType;
	private double balance;
	
	public Account(String accountNumber,String accountHolderName,String accounType,double balance) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.accounType = accounType;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccounType() {
		return accounType;
	}

	public void setAccounType(String accounType) {
		this.accounType = accounType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
}
