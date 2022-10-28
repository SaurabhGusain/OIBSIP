
import java.util.Scanner;


public class ATM {
    
    float balance;
    String username;
    int password;
    String transHistory="";
    int transNo=0;
    Scanner scan=new Scanner(System.in);

        
    public void register()
    {
        System.out.println("-----This is registation of user.-----");
        System.out.print("Enter the username. ");
        this.username=scan.next();
        System.out.print("Enter the password. (password should have only digits): ");
        this.password=scan.nextInt();
        System.out.print("Enter the amount to balance. ");
        this.balance=scan.nextFloat();
        System.out.println("your registation process is done. \n");
    }
    
    public boolean login()
    {
        System.out.println("-----This is login of user.-----");
        while(true)
        {
            System.out.print("Enter the username: ");
            String user = scan.next();
            System.out.print("Enter the password: ");
            int pass = scan.nextInt();
            System.out.println();
            if(user.equals(username)&& pass==password)
            {
                return true;
            }
            else
            {
                System.out.println("please enter correct username and password. \n\n");
            }
        }
    }
    
    public void depositCash(){
        System.out.print("Enter the amount: ");
        int amount=scan.nextInt();
        balance+=amount;
        System.out.println(amount+" deposit in your bank account. ");
        transNo++;
        transHistory=transHistory.concat( transNo +"\t"+amount+" deposit in your bank account. \n");
    }
    
    public void withdrowCash()
    {
        System.out.print("Enter the amount: ");
        int amount = scan.nextInt();
        if(balance<amount)
        {
            System.out.println("Insufficient Balance");
        }
        else
        {
            balance=balance-amount;
            System.out.println(amount+" is withdrow.");
            transNo++;
            transHistory=transHistory.concat(transNo+"\t"+amount+"is withdrow.\n");
        }
    }
    
    public void checkBalance()
    {
        System.out.println("Balance amount: "+balance);
    }
    
    public void transfer()
    {
        System.out.print("Enter the Account Number: ");
        int accno=scan.nextInt();
        System.out.print("Enter the amount to send: ");
        int amount=scan.nextInt();
        balance-=amount;
        System.out.println("Rs "+amount+" transfered to Account Number."+accno);
        transNo++;
        transHistory=transHistory.concat(transNo+"\tRs "+amount+" transfered to Account Number."+accno+"\n");
    }
    
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to ATM.");
        ATM cust=new ATM();
        cust.register();
        if(cust.login())
        {
            while(true)
            {
                System.out.println("\n---Choose the operation you want to perform:---");
                System.out.println("Choose 1 for Withdraw");  
                System.out.println("Choose 2 for Deposit");  
                System.out.println("Choose 3 for Check Balance");
                System.out.println("Choose 4 for Transaction Histroy");
                System.out.println("Choose 5 for Transfer money.");
                System.out.println("Choose 6 for EXIT");
                
                int choice=sc.nextInt();
                switch(choice)
                {
                    case 1: cust.withdrowCash();
                                break;
                    case 2: cust.depositCash();
                                break;
                    case 3: cust.checkBalance();
                                break;
                    case 4: System.out.println("--Transaction History--");
                            System.out.println(cust.transHistory);
                                break;
                    case 5: cust.transfer();
                                break;
                    case 6: System.exit(0);
                                break;
                    default:
                        System.out.println("Invalid choice.");
                    
                }
            }
        }
        
    }
            
}
