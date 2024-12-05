import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bank {
	
	double assignedVar = 0.0;
	private static Connection con = null;
	
	public void createAccount(Account account) throws SQLException, ClassNotFoundException {
		
		String query = "INSERT INTO ACCOUNTS (accountnumber, accountholdername,accountype, balance) VALUES (?, ?, ?, ?)";
		con = DatabaseConnectivity.getConnection();
		PreparedStatement stmt = con.prepareStatement(query);
		
		stmt.setString(1, account.getAccountNumber());
		stmt.setString(2, account.getAccountHolderName());
		stmt.setString(3, account.getAccounType());
		stmt.setDouble(4, account.getBalance());
		
		int insertset = stmt.executeUpdate();
		if(insertset > 0) {
			System.out.println("Account created successfully");
		}else {
			System.out.println("Count not create Account, Check your details");
		}	
	}
	
	public void getAccount(String accountNumber) throws SQLException, ClassNotFoundException {
		String query1 = "SELECT * FROM ACCOUNTS WHERE accountnumber = ?";
		con = DatabaseConnectivity.getConnection();
		PreparedStatement stmt1 = con.prepareStatement(query1);
		
		stmt1.setString(1, accountNumber);
		ResultSet rs = stmt1.executeQuery();
		if(rs.next()) {
		
			String accnum = rs.getString("accountNumber");
			String accholdername = rs.getString("accountHolderName");
			String acctype = rs.getString("accountype");
			double bal = rs.getDouble("balance");
			assignedVar = bal;
			
			System.out.println("Account Number : " + accnum);
			System.out.println("Account Holder Name : " + accholdername);
			System.out.println("Account Type : " + acctype);
			System.out.println("Account Balance : $" + bal);

		}
		else {
			System.out.println("Account not found ! Please enter a valid Account Number");
		}
	}
	
	
	public void deposit(String accountNumber, double depositAmount) throws SQLException, ClassNotFoundException {
		
		double existBal = getBalance(accountNumber);
		double newbalance = existBal + depositAmount;
		
		String query2 = "UPDATE ACCOUNTS SET balance = ? WHERE accountnumber = ?";
		con = DatabaseConnectivity.getConnection();
		PreparedStatement stmt2 = con.prepareStatement(query2);
		
		stmt2.setDouble(1, newbalance);
		stmt2.setString(2, accountNumber);
		
		int rowsAffected = stmt2.executeUpdate();
		if(rowsAffected > 0) {
			System.out.println("Amount deposited Successfully ! New Balance is : " + newbalance);
		}else {
			System.out.println("Account not found ! Please try entering a calid account number");
		}
		
		
	}
	
	public void withdraw(String accountNumber, double withdrawAmount) throws SQLException, ClassNotFoundException {	
		
		double existBal = getBalance(accountNumber);
		if(existBal < withdrawAmount) {
			System.out.println("Insufficient balance");
		}
		else {
			double newBalance = existBal - withdrawAmount;
			
			String query3 = "UPDATE ACCOUNTS SET balance = ? WHERE accountnumber = ?";
			con = DatabaseConnectivity.getConnection();	
			PreparedStatement stmt3 = con.prepareStatement(query3);
			
			stmt3.setDouble(1, newBalance);
			stmt3.setString(2, accountNumber);
			
			stmt3.executeUpdate();
			System.out.println("Withdraw successful ! New Balance is : " +newBalance);		
		}
	}

		
		public void deleteAccount(String accountNumber) throws SQLException, ClassNotFoundException {
			String query4 = "DELETE FROM ACCOUNTS WHERE accountnumber = ?";
			con = DatabaseConnectivity.getConnection();
			PreparedStatement stmt4 = con.prepareStatement(query4);
			
			stmt4.setString(1,accountNumber);
			
			stmt4.executeUpdate();
			System.out.println("Account Deleted Successfully !");
			
		}
		
		public double getBalance(String accountNumber) throws ClassNotFoundException, SQLException {
			double bal = 0.0;
			String sql = "SELECT BALANCE FROM ACCOUNTS WHERE accountnumber = ?";
			con = DatabaseConnectivity.getConnection();
			PreparedStatement stmt5 = con.prepareStatement(sql);
			
			stmt5.setString(1, accountNumber);
			ResultSet rss = stmt5.executeQuery()	;
			if(rss.next()) {
				 bal = rss.getDouble("BALANCE");
			}
			return bal;
		}
		
		public void accountValidations(String accountNumber ) {
			
			if(accountNumber == null || accountNumber.isEmpty()) {
				System.out.println("Account Number cannot be Empty! Please provide your Account Number");
			}
			if(accountNumber.length() > 20) {
				System.out.println("Account Number has to be within 20 digits ! Please enter a valid Account Number");
			}
			if(accountNumber.startsWith("-")) {
				System.out.println("Account Number value cannot be negative ! Please Enter a valid Account Number");
			}
			for(char c : accountNumber.toCharArray()) {
				if(!Character.isDigit(c)) {
					System.out.println("Account number should be numeric only ! Please enter a valid Account Number");
				}
			}
		}
		
		public void accountHolderNameValidations(String accountHolderName) {
			if(accountHolderName == null || accountHolderName.isEmpty()) {
				System.out.println("Account Holder Name cannot be Empty! Please provide your Account Holder Name");
			}
			
			for(char ch : accountHolderName.toCharArray()) {
				if(Character.isLetterOrDigit(ch)) {
					System.out.println("Invalid Name ! Please enter a valid Account Number");
				}
			}
			
			for(char c : accountHolderName.toCharArray()) {
				if(Character.isDigit(c)) {
					System.out.println("Account number should be numeric only ! Please enter a valid Account Number");
				}
			}
		}
		
		public void accounTypeValidations(String accounType) {
			if(!(accounType.equalsIgnoreCase("savings") || accounType.equalsIgnoreCase("current"))){
				System.out.println("Please enter a valid Account Type");
			}
		}
		
		public void amountValidations(double amount) {
			if(amount == 0.0) {
				System.out.println("Deposit Amount cannot be 0 ! Please enter valid deposit amount");
			}
			
			if(amount < 0) {
				 System.out.println("Invalid deposit Amount ! Please enter a valid deposit amount");
			 }
		}
}
	



