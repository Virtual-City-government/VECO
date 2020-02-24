import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class Filesystem {
    static Persoanl_Account account = new Persoanl_Account();
    static int accnum = 0; static String passw = " "; static double balance = 0.0; 
	public void makefile(int acc, String pass) throws IOException
	 {
			     
		    FileWriter fileWriter = new FileWriter(acc + ".txt");
		    PrintWriter printWriter = new PrintWriter(fileWriter);
		    printWriter.print(acc + "\n" + new String(account.encrypt(pass.getBytes(), "ABD453"))+ "\n0000000000.000");
		    
		    
		    printWriter.close();
		
		
		        
		      
		        
		       
		        System.out.println("DONE");
	           System.out.println("Your account has successfully been created!\n");
	           System.out.printf("data is saved in file");
	 }
	
	public void writeFile(File file, double balance) throws IOException
	{   
		
		FileWriter fr = new FileWriter(file, true);
		BufferedWriter br = new BufferedWriter(fr);
		PrintWriter pr = new PrintWriter(br);
		pr.println(balance);
		pr.close();
		br.close();
		fr.close();
		
	 
		
	}
//	 public static void main(String[] args) throws IOException {
//			
//		 Scanner in = new Scanner(System.in);
//			System.out.println("Enter your New account number: \n");
//		    accnum = in.nextInt();
//		    System.out.println("Enter your New password\nYou can enter either character,number or sign,but don't use space: \n");
//		    passw = in.next();
//		    account.createNewAccount(accnum, passw);
//		    makefile(accnum,passw);
//		    File file = new File(accnum + ".txt");
//		    System.out.println(readAccountNum(file));
//		    System.out.println(readPassword(file));
//		    System.out.println("Enter your New balance: \n");
//		    balance = in.nextDouble();
//		    writeFile(file, balance);
//		    System.out.println(readBalance(file));
//		    replaceLine(file, ""+balance, "4000");
//		    
//			}
	
	public String readAccountNum(File file) throws IOException {
		String accnum = "";
		String password = "";
		FileInputStream fis = new FileInputStream(file);
	 
		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	 
		String line = null;
	        accnum = br.readLine(); 		
	 
		br.close();
		return accnum;
	}
	
	
	public String readPassword(File file) throws IOException {
		String password = "";
		String accnum = "";
		FileInputStream fis = new FileInputStream(file);
	 
		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	 
		String line = null;
	        accnum = br.readLine(); 	
	        password = br.readLine(); 

	 
		br.close();
		return new String(account.decrypt(password.getBytes(),"ABD453"));
	}
	
	
	public String readBalance(File file) throws IOException {
		String password = "";
		String accnum = "";
		String balance = "";
		FileInputStream fis = new FileInputStream(file);
	 
		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	 
		String line = null;
	        accnum = br.readLine(); 
	        password = br.readLine();
	        balance = br.readLine();
	 
		br.close();
		return balance;
	}
	
	public void replaceLine(File file1, String oldLine, String newLine) throws IOException {
		try {
	        // input the file content to the StringBuffer "input"
	        BufferedReader ok = new BufferedReader(new FileReader(file1));
	        StringBuffer inputBuffer = new StringBuffer();
	        String line;

	        while ((line = ok.readLine()) != null) {
	            inputBuffer.append(line);
	            inputBuffer.append('\n');
	        }
	        ok.close();
	        String inputStr = inputBuffer.toString();

	 
 	        inputStr = inputStr.replace(oldLine, newLine); 
	            	      	
	        // write the new string with the replaced line OVER the same file
	        FileOutputStream fileOut = new FileOutputStream(file1);
	        fileOut.write(inputStr.getBytes());
	        fileOut.close();

	    } catch (Exception e) {
	        System.out.println("Problem reading file.");
	    }
	}
	
	
	
	
	


}
