// 1. Girish started a new banking service, where he is facing difficulties with the storing of the account details. Help him
// by writing a program to create add, delete, insert list of BankAccounts, each bank account should have following

// details.
// a. Unique Account Id (Integer)
// b. Account Type (Enum : < Saving / Current >)
// c. Account Holder name (String)
// d. Account balance (variable that can store 20k million value)
// 2. Write a program for credit and debit using multithreading.
// 3. Write custom exceptions for all the above programs.


import java.util.ArrayList;
import java.util.Scanner;


class BankException extends Exception {
	public BankException(String s){
		super(s);
	}
}
class BankAccount{
	
	int accountID;
	public enum accountType{
		SAVING,
		CURRENT
	};
	accountType type;
	String holderName;
	long balance;

	BankAccount(int accountID,accountType type,String holderName,long balance){
		this.accountID=accountID;
		this.type=type;
		this.holderName=holderName;
		this.balance=balance;
	}

	void display(){
		System.out.println("Details of :"+this.accountID+"\n"+this.type+"\t"+this.holderName+"\t"+this.balance);
	}
	void debit(BankAccount acc,long money){
		try{
			if(acc.balance<money){
				throw new BankException("BankError: Insufficient funds");
			}
			acc.balance=acc.balance-money;
		}
		catch(BankException e){
			System.out.println(e.getMessage());
		}
	}


	void credit(BankAccount acc,long money){
		acc.balance=acc.balance+money;
	}
}
class DebitThread extends Thread{
	BankAccount acc;
	long money;
	DebitThread(BankAccount acc,long money){
		this.acc=acc;
		this.money=money;
	}
	public void run(){
		
		this.acc.debit(acc,money);
		try{
			Thread.sleep(2000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
class CreditThread extends Thread{
	BankAccount acc;
	long money;
	CreditThread(BankAccount acc,long money){
		this.acc=acc;
		this.money=money;
	}
	public void run(){
		
		this.acc.credit(acc,money);
		try{
			Thread.sleep(2000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
class Bank{
	public static ArrayList<BankAccount> accounts = new ArrayList<BankAccount>(100);
	void addAccount(BankAccount acc){
		try{
			for (BankAccount bankAccount : accounts) {
				if(bankAccount.accountID == acc.accountID){
					throw new BankException("BankError: Invalid ID");
				}
			}
			accounts.add(acc);
		}
		catch(BankException e){
			System.out.println(e.getMessage());
		}

	}

	int isaccountExist(int accID){
		int index=-1;
		for(int i=0;i<accounts.size();i++){
			if(accounts.get(i).accountID == accID){
				index=i;
			}
		}
		// try{
		// 	if(index==-1){
		// 		throw new BankException("BankError: Account not found");
		// 	}
		// }
		// catch(BankException e){
		// 	System.out.println(e.getMessage());
		// }
		return index;
	}

	void deleteAccount(int accID){
		try{
			if(isaccountExist(accID)==-1){
				throw new BankException("BankError: Delete unsuccessful");
			}
			System.out.println(accID+" id associated account deleted successfully");
			accounts.remove(isaccountExist(accID));
			
		}
		catch(BankException e){
			System.out.println(e.getMessage());
		}
	}

	void showDatabase(){
		System.out.println("TS DATABASE----");
		for (BankAccount bankAccount : accounts) {
			bankAccount.display();
		}
	}
	public static void main(String a[]){
		Scanner input=new Scanner(System.in);

		Bank TSbank = new Bank();

		DebitThread Dthread;
		CreditThread Cthread;

		//Create
		BankAccount.accountType t1=BankAccount.accountType.SAVING;
		BankAccount a1 = new BankAccount(180698,t1,"Sunil",1000);
		BankAccount.accountType t2=BankAccount.accountType.CURRENT;
		BankAccount a2 = new BankAccount(180189,t2,"Siva",2000);
		BankAccount.accountType t3=BankAccount.accountType.CURRENT;
		BankAccount a3 = new BankAccount(180696,t2,"Sunny",3000);
		
		

		//add or insert
		TSbank.addAccount(a1);
		TSbank.addAccount(a2);
		TSbank.addAccount(a3);

		TSbank.showDatabase();

		//delete
		System.out.print("Your TS bank id which you wanna delete:");
		int delAccID = input.nextInt();
		TSbank.deleteAccount(delAccID);


		System.out.print("Your TS Bank account ID: ");
		int sender=TSbank.isaccountExist(input.nextInt());
		System.out.print("The receipent TS bank account ID: ");
		int receipent=TSbank.isaccountExist(input.nextInt());
		System.out.print("Amount to be transferred: ");
		long money=input.nextInt();
		

		//Debit
		try{
			if(sender==-1 || receipent==-1){
				throw new BankException("BankError: Either of the accounts not exist");
			}
			BankAccount s=Bank.accounts.get(sender);
			BankAccount r=Bank.accounts.get(receipent);
			System.out.println("@Sender\nBefore Debit");
			s.display();
			Dthread = new DebitThread(s,money);
			Dthread.start();
			System.out.println("After Debit of "+money);
			s.display();


			//Credit
			System.out.println("@Receiver\nBefore Credit");
			r.display();
			Cthread = new CreditThread(r, money);
			Cthread.start();
			System.out.println("After credit of "+money);
			r.display();
		}
		catch(BankException e){
			System.out.println(e.getMessage());
		}

		TSbank.showDatabase();

	}
}