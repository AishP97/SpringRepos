import java.sql.SQLException;
import java.util.Scanner;

public class BankingSystem {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Bank bk = new Bank();
		Scanner sc = new Scanner(System.in);
	while(true) {	
		System.out.println("Welcome to TD Bank");
		System.out.println("1. Create an Account");
		System.out.println("2. View Account");
		System.out.println("3. Deposit");
		System.out.println("4. Withdraw");
		System.out.println("5. Delete Account");
		System.out.println("6. Exit");
		
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			
			System.out.println("Enter your Account Number :");				
			String accountNumber = sc.next();
			
			while(bk.accountValidations(accountNumber)) {
				System.out.println("Enter Account Holder Name :");				
				sc.nextLine();				
				String accountHolderName = sc.nextLine();	
				//bk.accountHolderNameValidations(accountHolderName);
				
				System.out.println("Enter your Account Type:");				
				String accounType = sc.next();	
				//bk.accounTypeValidations(accounType);
				
				System.out.println("Enter amount to Deposit");				
				double deposit = sc.nextDouble();	
			
				bk.createAccount(new Account(accountNumber,accountHolderName,accounType,deposit));			
				break;
			}
		
			
			
		case 2:
			System.out.println("Enter your Account Number :");
			String accnumber = sc.next();
			//bk.accountValidations(accnumber);
			bk.getAccount(accnumber);
			break;
		
		case 3:
			System.out.println("Enter your Account Number :");
			String accnumberD = sc.next();
			//bk.accountValidations(accnumberD);
			System.out.println("Enter the Amount you want to deposit :");
			double Damount = sc.nextDouble();
			//bk.amountValidations(Damount);
			
			bk.deposit(accnumberD, Damount);
			break;
			
		case 4:
			System.out.println("Enter your Account Number :");
			String accnumberW = sc.next();
			//bk.accountValidations(accnumberW);
			System.out.println("Enter the Amount you want to withdraw :");
			double Wamount = sc.nextDouble();
			//bk.amountValidations(Wamount);
			
			bk.withdraw(accnumberW, Wamount);
			break;
			
		case 5:
			System.out.println("Enter your Account Number :");
			String delAccNum = sc.next();
			//bk.accountValidations(delAccNum);
			bk.deleteAccount(delAccNum);
			break;
			
		case 6:
			System.out.println("GoodBye !");
			sc.close();
			return;
			
		default:
			System.out.println("Invalid option! Try again.");
		}
		
	}
	
}
}
