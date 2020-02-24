import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class Budget {
    
    public String category;
    public Double amount;
    Filesystem create = new Filesystem();
    public double expense, balance, earnings, interest,price;
  
    static HashMap<String, Double> categories = new HashMap<String, Double>();
    
    public void addCat()
    {
        // Add keys and values (Category, amount)
        categories.put(category,amount);
        for (String i : categories.keySet()) 
        {
            System.out.println("category: " + i + " value: " + categories.get(i));
        }
    }
    
    //displays categories and expenses
    public void display()
    {
        for (String i : categories.keySet()) 
        {
            System.out.println("category: " + i + " value: $" + categories.get(i) + " Percent of total expenses: " + categories.get(i) / expenditure() * 100 + "%");
        }
    }
    
    //total expenses
    public double expenditure()
    {
        expense=0;
        for (double i: categories.values()) 
        {
            expense += i;
        }
        return expense;
    }
    
    //main method
    public void mai() throws IOException
    {
        char input;
        Scanner scan = new Scanner(System.in);
        Budget budget = new Budget();
        
        do 
        {
            System.out.println("Which operation do you want?");
            System.out.println("a:add category");
            System.out.println("b:remove category");
            System.out.println("c:check cost");
            System.out.println("d:display balance");
            System.out.println("e:display categories");
            
            input = scan.next().charAt(0);
            switch(input) 
            {
                case 'a': //add category
                    System.out.print("Enter category\n");
                    budget.category = scan.next();                  
                    System.out.println("Enter the cost");
                    budget.amount=Double.parseDouble(scan.next());
                    budget.addCat();
                    break;
                case 'b': //remove category
                    System.out.println("enter catergory to remove");
                    budget.category=scan.next();
                    budget.categories.remove(budget.category);
                    break;
                case 'c': //check cost
                    System.out.println("$" + budget.expenditure());
                    break;
                case 'd': //display balance
                	System.out.println("Please enter your account number: ");
    		    	int a = scan.nextInt();
                	File file8 = new File(a + ".txt");  		    	
                    System.out.println(Double.valueOf(budget.create.readBalance(file8)) - expenditure());
                    break;    
                case 'e'://display categories
                    budget.display();
                    break;
            } 
        } while(input!='0');
    }
}
