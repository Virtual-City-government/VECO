// This class is all the operating features of Our bank system
import java.io.*;
import java.util.*;
public class Operations_Features {
      Persoanl_Account account = new Persoanl_Account();
	  // These are different for each account
	  Filesystem file = new Filesystem();

	  // This is shared by all accounts, so it's static
	  private static int lastAccountNumber = 0;

	  // This is a constructor
	  public Operations_Features() {
	
	   
	  }

	  
	  //Deposit 	
	  public void deposit(int accountNum, double depositAmount) throws IOException
	  { 
		File file1 = new File(accountNum + ".txt");
		double newBalance = Double.valueOf(file.readBalance(file1)) + depositAmount;
	    file.replaceLine(file1, file.readBalance(file1), "" + newBalance);
	   
	  }

	  
	  // Withdraw 
	  public void withdraw(int accountNum, double withdrawAmount) throws NumberFormatException, IOException
	  {
		  File file2 = new File(accountNum + ".txt");
	     if (withdrawAmount > Double.valueOf(file.readBalance(file2))){    
	      System.out.println("Insufficient Funds!!!");
	      
	     }
	          else {
	        	  
	        	  
	      		double newBalance2 = Double.valueOf(file.readBalance(file2)) - withdrawAmount;
	      	    file.replaceLine(file2, file.readBalance(file2), "" + newBalance2);
	     
	    }
	}
	  
	  //Transfer 
	  public void transferTo(int youaccountnum, double amount, int otheraccountNum) throws NumberFormatException, IOException 
	  {   
		  File file3 = new File(youaccountnum + ".txt");
		  File file4 = new File(otheraccountNum + ".txt");
		  
	      if (amount < Double.valueOf(file.readBalance(file3))) {
	    	  withdraw(youaccountnum,amount);
	    	  deposit(otheraccountNum,amount);
	    	 
	    	  
	          System.out.println("\nTransfer successful. Transfered: $" + amount + " from " + youaccountnum + " to " + otheraccountNum);
	      } 
	      else if (amount > Double.valueOf(file.readBalance(file3))) {
	          System.out.println("\nTransfer failed, not enough balance!");
	      }
	  }  


}


	
	

	  


