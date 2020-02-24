import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;


public class Persoanl_Account {
     // Users Accounts 
//	Check if the account exists()
//	Create new accounts and set up password()
//	Delete account
//	Password security
//	Encryption
//	Decryption
	int accounts = 0;    
	String passwords = "";
	double balance = 1;  
	Scanner in = new Scanner(System.in);	
	Filesystem create = new Filesystem();  
	HashMap<Integer,String> AccPassword = new HashMap<Integer,String>(); // This is the account and password database	
	HashMap<Integer,Double> AccBalance = new HashMap<Integer,Double>();  // This is the account and balance database
	
     public Persoanl_Account() 
     {
		this.accounts = accounts;
		this.passwords = passwords;
		this.balance = balance;
	        
     }    
     
	
	public boolean Accountexists(int accountNumber)
	{    
		  File tmpDir = new File(accountNumber + ".txt");
	      boolean exists = tmpDir.exists();
	    	
	         	
	      	return exists;
		
	}
	public boolean PasswordMatch(int accountnumber, String password) throws IOException
	{   
		boolean match = false;
		File passfile = new File(accountnumber + ".txt");
		if (password.equals(create.readPassword(passfile)))
		{
			match = true;
		}
		else
			match = false;
		
		return match;
	}
	public void createNewAccount(int accountNumber, String passWord) throws IOException
	{    	
	     boolean exists = false;
	     
	     File tmpDir = new File(accountNumber + ".txt");
	     boolean accexists = tmpDir.exists();
	      
	     if (accexists == true)
	    	 exists = true;
	     
	     if (exists == false)
	     { 
	    	 create.makefile(accountNumber, passWord);
			 
	     }
	     else
	     {
	    	 System.out.println("This account is already exists!");
	     }
	    	
		
		
	}
	 
	
	
	


	public void deleteAccount(int accountNumber, String passWord) throws IOException
	{  
			
		File tmpDir = new File(accountNumber + ".txt");
	    boolean accexists = tmpDir.exists();
	    if (accexists == true)
	    {   
	    	if (create.readBalance(tmpDir).charAt(0) != 0)
	    	{
	    		System.out.println("Your account still has balance!");
	    	}
	    	else
	    	{
	    		tmpDir.delete();
	    	}
	    }
	     
	}
	
	
	

	
	public void changePassword(int accountNumber, String oldPassWord, String newPassWord) throws IOException 
	{
		boolean exists = false;
		boolean passexists = false;
		File tmpDir = new File(accountNumber + ".txt");
	     
		if (Accountexists(accountNumber) == true)
	    	 exists = true;
		
	    if (exists == true)
	    {   
	    	if (create.readPassword(tmpDir).equals(oldPassWord))
	    	{
	    		create.replaceLine(tmpDir, oldPassWord, newPassWord);
	    	}
	    	
    		
	    }
	     
	  
	}
	
	public void print(int accountNumber) throws IOException
	{   
		File file6 = new File(accountNumber + ".txt");
		System.out.println(create.readAccountNum(file6) + "\n" + create.readPassword(file6) + "\n" + create.readBalance(file6));
		
		
	}
	
	
	  // Encrypt and decrypt the password
	 public byte[] encrypt(byte[] cleartext, String key)
	   {
		  byte[] toReturn = new byte[cleartext.length];
		  byte[] keyBytes = key.getBytes();
		  for (int i = 0; i < cleartext.length; i++)
		  {
			 toReturn[i] = (byte) (cleartext[i] ^ keyBytes[i % keyBytes.length]);
		  }
		  return toReturn;
	   }

	
	 public byte[] decrypt(byte[] cleartext, String key)
	   {
		  byte[] toReturn = new byte[cleartext.length];
		  byte[] keyBytes = key.getBytes();
		  for (int i = 0; i < cleartext.length; i++)
		  {
			 toReturn[i] = (byte) (cleartext[i] ^ keyBytes[i % keyBytes.length]);
		  }
		  return toReturn;
	   }

	
	
	
	
	
}
