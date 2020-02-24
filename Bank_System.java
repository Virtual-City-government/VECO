import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class Bank_System {
  public static void main(String[] args) throws IOException {
//	  First print the Welcome and information sheets
//	  Ask user to login in account. If the user doesn’t have one, jump to creating account page. 
//	  Successfully login, print different functions and choices: Transfer / Deposit / Withdraw / Loan / Interests / Acquire information / Manage Account / Quit / Play Music
      Persoanl_Account account = new Persoanl_Account(); // Personal account object
      Operations_Features features = new Operations_Features();
      Interest_Loan interest = new Interest_Loan();
      Budget bg = new Budget();
      Filesystem create = new Filesystem(); 
     
	  Scanner in = new Scanner(System.in);	
	  double balance = 0;
		String choice = "";	
		String login = "";
		// The Information Guide
		System.out.println("Welcome to our Bank !\n\nWe are here to provide you the best and the most personalized financial services!");
		System.out.println("-----------------------------------\t\t\t-----------------------------------\r\n\t\t\t----------------------------------------\r\n");
		
		
		do {
			System.out.println("\nCommand Options\r\n" + 
			"-----------------------------------\r\n" + 
			"a: Login to my account\r\n" + 
			"b: Create a new account\r\n"+
			"q: quit\r\n");
			
			choice = in.next();
			switch (choice)          
			{
		    case "a": 
		      System.out.println("Enter your account number: \n");
		      int oldaccnum = in.nextInt();
		      
		    //check file database 
		      
		      
		      if (account.Accountexists(oldaccnum) == true) // check if the account exists
		      {
		      System.out.println("Enter your password: \n");
		      String oldpassw = in.next();
		     
		        if (account.PasswordMatch(oldaccnum, oldpassw) == true)
		        {
		    	  System.out.println("Welcome to your personal account!");	    	 
		    	  System.out.println("Please enter 'q' to continue\n");
		    	  login = in.next();
   
		    	
		        }
		      
		      }
		      else
		      {
		    	  System.out.println("Sorry it looks like you have not create this account\n");
		      }
              
			
						
			 break;
			 
		    case "b": 
		       System.out.println("Enter your New account number: \n");
		       int accnum = in.nextInt();
		       System.out.println("Enter your New password\nYou can enter either character,number or sign,but don't use space: \n");
		       String passw = in.next();
		       account.createNewAccount(accnum, passw);
		    
		       
		    break;
		    
		    case "q":
		    	break;
		    	
		    default: System.out.println("Sorry you might enter the wrong code...\n"); break;
			}
			
		}while (!choice.equals("q") && !login.equals("q")); 
		
	    // Operations after logging in
		double depositAmount = 0.0;
		double WithdrawAmount = 0.0;
		int youraccount = 0;
		int otheraccount = 0;
		if(login.equals("q"))
		{
			
		String choose = "";
		do {
			
			informationSheet();
			choose = in.next();
			switch (choose)          
			{
		    case "a":
		    	System.out.println("Please specify your account: \n");
		        youraccount = in.nextInt();
		        
		    	System.out.println("Please specify the account that you are transfer to: \n");
	            otheraccount = in.nextInt();
	            
	            System.out.println("Please specify the amount of money that you want to transfer: \n");
		        depositAmount = in.nextDouble();
	            features.transferTo(youraccount, depositAmount, otheraccount);
		    	break;
		    	
		    case "b": 
		    	System.out.println("Please specify your account: \n");
		        youraccount = in.nextInt();
		    	System.out.println("Please specify the amount of money that you want to deposit: \n");
		        depositAmount = in.nextDouble();	
		        features.deposit(youraccount, depositAmount);
		        
		    	
		    	break;
		    	
		    case "c": 
		    	System.out.println("Please specify your account: \n");
		        youraccount = in.nextInt();
		    	System.out.println("Please specify the amount of money that you want to withdraw: \n");
		    	WithdrawAmount = in.nextDouble();		        		    			        	        	        
		    	features.withdraw(youraccount, WithdrawAmount);
		    	break;
		    	
		    case "d": interest.loan();
		    	break;
		    	
		    case "e": 	    	
		    	System.out.println("Please enter your account number: ");
		    	int a = in.nextInt();
		    	File file8 = new File(a + ".txt");
		    	interest.askInterest(Double.valueOf(create.readBalance(file8)));
		    	break;
		    	
		    case "f": bg.mai();
		    	break;
		    	
		    case "g":  System.out.println("Please enter your account number: ");
		        int i = in.nextInt();
		    	account.print(i);
		    	
		    	break;
		    	
		    case "m": System.out.println("Please enter the operations that you want to do:\n ----'d' for delete your account\n ----'c' for change your password");
			          String o = in.next();
			         switch(o)
			  		{
			         
			  		case "d":
			  			System.out.println("Please enter your account number: ");
				        int ii = in.nextInt();
			  			File file7 = new File(ii + ".txt");
                        account.deleteAccount(ii,create.readPassword(file7));
			  			
			  			break;
			  			
			  		case "c": 
			  			System.out.println("Please enter your account number: ");
				        int ac = in.nextInt();
				        System.out.println("Please enter your old password: ");
				        String oldp = in.next();
				        System.out.println("Please enter your new password: ");
				        String newp = in.next();			      
			  			account.changePassword(ac, oldp, newp);
			  			
			  			break;
			  		}
		    	
		    default:
		    	break;
			}
			
			
		}while(!choose.equals("h"));
		}
		
		
		
		
		
		
  }
  //Transfer / Deposit / Withdraw / Loan / Interests / Acquire information / Manage Account / Quit /
  public static void informationSheet()
  {
	  System.out.println("\nPlease select the operation that you would like to do:\r\n" + 
				"-----------------------------------\r\n" + 
				"a: Transfer\r\n" + 
				"b: Deposit\r\n"+ 
				"c: Withdraw\r\n" +
				"d: Loan\r\n" +
				"e: Interests\r\n" +
				"f: Budget\r\n" +
				"g: Acquire information\r\n" +
				"m: Manage Account\r\n" +
				"h: Quit\r\n");
  }
}

