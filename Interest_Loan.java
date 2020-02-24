import java.util.*;
public class Interest_Loan {
	double balance = 1;
	double rate=0;
	Persoanl_Account account = new Persoanl_Account();
	public Interest_Loan() {
		
	}
	
	
	public void askInterest(double balance)
	{   
		this.balance = balance;
		System.out.println("Which plan do you want?(choose from below)");
		System.out.println("a:Time deposit");
		System.out.println("b:Education deposit");
		System.out.println("c:Demand deposit");
		System.out.println("q:Quit");
		Scanner scan = new Scanner(System.in);
		String x = scan.nextLine();
		//if(balance>0)
		//{
		if(x.toLowerCase().equals("a"))
		{
			System.out.println("How long are you saving?(choose from e-h)");
			System.out.println("e:three month");
			System.out.println("f:a year");
			System.out.println("g:two years");
			System.out.println("h:three years");
			String t = scan.nextLine();
			switch(t) {
			case"e":
				rate=0.0135;
				System.out.println("Current time deposit interest rate for three month is: "+ rate);
				balance+=balance*rate*0.25;
				System.out.println("Success,your balance in three month will be: "+balance);
				break;
			case"f":
				rate=0.0155;
				System.out.println("Current time deposit interest rate for a year is: "+ rate);
				balance=balance*(1+rate);
				System.out.println("Success,your balance in a year will be: "+balance);
				break;
			case"g":
				rate=0.0225;
				System.out.println("Current time deposit interest rate for two years is: "+ rate);
				balance=balance*(1+2*rate);
				System.out.println("Success,your balance in two years will be: "+balance);
				break;
			case"h":
				rate=0.0275;
				System.out.println("Current time deposit interest rate for three years is: "+ rate);
				balance=balance*(1+3*rate);
				System.out.println("Success,your balance in three years will be: "+balance);
				break;
			case"q":
				break;
			default:
				System.out.println("Fail,invalid input!");
				break;
			}
		}
		else if((x.toLowerCase().equals("b")))
		{
			    if(balance<=30000)
			    {
				rate=0.05;
				System.out.println("Current interest rate for education deposits deposit is: "+ rate);
				System.out.println("How many years you expected to deposit?(choose from 1-4 years)");
				int year=scan.nextInt();
				if(year>0 && year<5) 
				{
				balance=balance*(1+rate*year);
				System.out.println("Success,your balance in "+year+" years will be: "+balance);
			    }
				else {
					System.out.println("Fail, you can only deposit from one to four years.");
				}
			    }
				
		
				else
				{
					System.out.println("Fail, You can not deposit more than 30000.");
				}
			    }
		
		else if((x.toLowerCase().equals("c")))
			{
			rate=0.003;
			System.out.println("Current demand deposit interest rate is: "+ rate);
			System.out.println("How many years you expected to deposit? How many month?");
			int year = scan.nextInt();
			int month = scan.nextInt();
			if(year>=0 && month>0 && month<12) {
			balance= balance*(1+rate*year+rate*month*1/12);
			System.out.println("Success, your balance in "+year+" years and "+month+ " months will be: "+ balance);
			}
			else
			{
				System.out.println("Fail, invalid input!");
			}
			}
			
		//}
		else
		{
			System.out.println("Your balance is zero!");
		}


	}  // end of the interest
	
    public void loan()
    {
    	double rate = 0;
    	double money = 0;
    	System.out.println("Which plan do you want?(choose from a and b)");
    	System.out.println("a:short term loan");
    	System.out.println("b:long term loan");
    	System.out.println("q:quit");
    	Scanner scan = new Scanner(System.in);
    	String x = scan.nextLine();
    	switch(x) {
    	case "a":
    		rate=0.0435;
    		System.out.println("Current short term rate is: "+ rate);
    		System.out.println("How much money you need to loan: ");
    		money = scan.nextInt();
    		System.out.println("How many months you will need to pay back?");
    		int m = scan.nextInt();
    		if(m>0 && m<12)
    		{
    		money+=money*(rate*m/12);
    		System.out.println("Success,the money you need to pay back in "+m+" months will be "+money);
    		}
    		else
    		{
    			System.out.println("Fail,you can only choose from 1-11 months");
    		}
    		break;
    	case "b":
    		rate=0.048;
    		System.out.println("Current long term rate is: "+ rate);
    		System.out.println("How much money you need to loan: ");
    		money = scan.nextInt();
    		System.out.println("How many years you will need to pay back? How many more month you will need to pay back? ");
    		m = scan.nextInt();
    		int y = scan.nextInt();
    		if(y>=0 && m>=0 && m<12)
    		{
    		money+=money*(rate*y+rate*1/12*m);
    		System.out.println("Success,the money you need to pay back in "+y+" years and "+m+" will be "+money);
    		}
    		else
    		{
    			System.out.println("Fail, invalid input.");
    		}
    		break;
    	case "q":
    		break;
    	default:
    		System.out.println("Fail,invalid input!");
    		break;
    	}
    	

    }
    
    //Budget
   
}
