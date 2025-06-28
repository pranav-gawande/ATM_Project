import java.text.DecimalFormat;
import java.util.*;
class Account_AIML{
    Scanner sc=new Scanner(System.in);
    DecimalFormat DF1 = new DecimalFormat("###,##0.00 'Rupee'");
    private int CN;
    private int PN;

    double CB=2000;
    double SB=4000;


    void set_Customer_Number(int a){
        CN=a;
    }
    void set_PIN_Number(int b){
        PN=b;
    }
    int get_Customer_Number(){
        return CN;
    }
    int get_PIN_Number(){
        return PN;
    }
    void getCurrentBalance(){
        System.out.println("Current Account Balance : "+ DF1.format(CB));
    }
    void getSavingBalance(){
        System.out.println("Saving Account Balance : "+ DF1.format(SB));
    }
    void get_Current_Withdraw_Input(){
        System.out.println("\nCurrent Account Balance : "+ DF1.format(CB));
        System.out.print("Enter the Amount you want to Withdraw : ");
        double amount=sc.nextDouble();
        if((CB-amount)>=0){
            calci_CurrentWithdraw(amount);
            System.out.println("\nTransaction Successful");
            System.out.println("Current Account Balance : "+ DF1.format(CB));
        }else{
            System.out.println("\nInsufficient Balance");
        }
    }
    void get_Saving_Withdraw_Input(){
        System.out.println("\nSaving Account Balance : "+ DF1.format(SB));
        System.out.print("Enter the Amount you want to Withdraw : ");
        double amount=sc.nextDouble();
        if((SB-amount)>=0){
            calci_SavingWithdraw(amount);
            System.out.println("\nTransaction Successful");
            System.out.println("Saving Account Balance : "+ DF1.format(SB));
        }else{
            System.out.println("\nInsufficient Balance");
        }
    }
    void get_Current_Deposit_Input(){
        System.out.println("\nCurrent Account Balance : "+ DF1.format(CB));
        System.out.print("Enter the Amount you want to Deposit : ");
        double amount=sc.nextDouble();
        if((CB+amount)>=0){
            calci_CurrentDeposit(amount);
            System.out.println("\nTransaction Successful");
            System.out.println("Current Account Balance : "+ DF1.format(CB));
        }else{
            System.out.println("\nInsufficient Balance");
        }
    }
    void get_Saving_Deposit_Input(){
        System.out.println("\nSaving Account Balance : "+ DF1.format(SB));
        System.out.print("Enter the Amount you want to Deposit : ");
        double amount=sc.nextDouble();
        if((SB+amount)>=0){
            calci_SavingDeposit(amount);
            System.out.println("\nTransaction Successful");
            System.out.println("Saving Account Balance : "+ DF1.format(SB));
        }else{
            System.out.println("\nInsufficient Balance");
        }
    }
    double calci_CurrentWithdraw(double amount){
        CB=CB-amount;
        return CB;
    }
    double calci_SavingWithdraw(double amount){
        SB=SB-amount;
        return SB;
    }
    double calci_CurrentDeposit(double amount){
        CB=CB+amount;
        return CB;
    }
    double calci_SavingDeposit(double amount){
        SB=SB+amount;
        return SB;
    }
}

class Option_Menu_AIML extends Account_AIML{
    HashMap<Integer,Integer> data = new HashMap();
    Scanner sc=new Scanner(System.in);
    void get_Login(){
       do{
        try{
        data.put(11111, 111);
        data.put(11112, 222);
        data.put(11113, 333);
        data.put(11114, 444);
        data.put(11115, 111);

        System.out.println("Welcome to the ATM");
        System.out.print("\nEnter the Customer Number : "); 
        set_Customer_Number(sc.nextInt());
        System.out.print("Enter the PIN Number : ");
        set_PIN_Number(sc.nextInt());

        int P=get_Customer_Number();
        int Q=get_PIN_Number();

        if(data.containsKey(P) && data.get(P)==Q){
            get_Account_Type();
        }else{
            System.out.println("\nWrong Customer Number or Pin Number");
        }
       }catch(InputMismatchException ime){
        System.out.println("\nPlease Enter only Numbers");
        System.out.println("Characters and Symbols are not allowed");
        sc.next();
        get_Login();
       }
       }while(true);
    }

    void get_Account_Type(){
        System.out.println("\nSelect the Account Type you want to Access");
        System.out.println("\nType 1: Current Account");
        System.out.println("Type 2: Saving Account");
        System.out.println("Type 3: Exit");
        System.out.print("\nChoice: ");

        int ch=sc.nextInt();
        switch (ch) {
            case 1:
                getCurrent();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("\nThank you for visiting");
                System.out.println("Visit Again");
                break;
            default:
                System.out.println("\nInvalid Choice");
                System.out.println("Please Enter the Valid Choice");
                get_Account_Type();
                break;
        }
    }
    void getCurrent(){
        System.out.println("\nCURRENT ACCOUNT");
        System.out.println("\nType 1 : Check Balance");
        System.out.println("Type 2 : Withdraw Money");
        System.out.println("Type 3 : Deposit Money");
        System.out.println("Type 4 : Exit");
        System.out.print("\nChoice : ");
        int ch=sc.nextInt();
        switch(ch){
            case 1:
                getCurrentBalance();
                get_Account_Type();
                break;
            case 2:
                get_Current_Withdraw_Input();
                get_Account_Type();
                break;
            case 3:
                get_Current_Deposit_Input();
                get_Account_Type();
                break;
            case 4:
                System.out.println("\nThank you for visiting");
                System.out.println("Visit Again");
                break;
            default:
                System.out.println("\nInvalid Choice");
                System.out.println("Please Enter the Valid Choice");
                break;
        }
        
    }
    void getSaving(){
        System.out.println("\nSAVING ACCOUNT");
        System.out.println("\nType 1 : Check Balance");
        System.out.println("Type 2 : Withdraw Money");
        System.out.println("Type 3 : Deposit Money");
        System.out.println("Type 4 : Exit");
        System.out.print("\nChoice : ");
        int ch=sc.nextInt();
        switch(ch){
            case 1:
                getSavingBalance();
                get_Account_Type();
                break;
            case 2:
                get_Saving_Withdraw_Input();
                get_Account_Type();
                break;
            case 3:
                get_Saving_Deposit_Input();
                get_Account_Type();
                break;
            case 4:
                System.out.println("\nThank you for visiting");
                System.out.println("Visit Again");
                break;
            default:
                System.out.println("\nInvalid Choice");
                System.out.println("Please Enter the Valid Choice");
                break;
        }
    }
}

public class ATM_AIML extends Option_Menu_AIML{
    public static void main(String[] args){
        Option_Menu_AIML oma = new Option_Menu_AIML();
        oma.get_Login();
    }
}
