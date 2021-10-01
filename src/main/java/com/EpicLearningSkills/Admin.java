package com.EpicLearningSkills;

import java.util.Scanner;

public class Admin extends Bank_System {


	boolean password(String pass_code)
	{
		if (!pass_code.equals("admin"))
		{
			return false;
		}
		else
		{
		return true;
		}
	}
    void get_approval_of_Account() throws Exception // Admin can open a New Account and close an account
    {
    	Scanner input_command = new Scanner(System.in);
        System.out.println("Welcome Admin, Enter your Personal Password");
        String  confirm_password = "admin";
		String password = "";
		password = input_command.next();
		boolean check=password(password);
        if (check==true) {


            System.out.println("Press 1 to open account");
            System.out.println("Press 2 to close account");
            int option;
            option = input_command.nextInt();

            switch (option) {
                case 1:
                    new_Account();
                    break;
                case 2:
                	
                    System.out.print("Enter Client Account Number :: ");
                    int Account_no = input_command.nextInt();
                    close_Account(Account_no) ;
                    setAccountno(Account_no);
                    close_Account(getAccountno());
                    break;
            }
        } else {
        	//System.out.println("Your identity is not clear ^|^");
        	throw new Exception("Your identity is not clear ^|^"); 
        }

    }
   
    void DisplayAllDeduction_Admin(int Account_no) {    // Display all accounts deductions along with account details

        setAccountno(Account_no);
        DisplayAllDeduction(getAccountno());
    }

    void calculate_interest_Admin(int Account_no) throws Exception {    // Specify the Interest Rate, applicable to all Saving Accounts
        setAccountno(Account_no);
        Calculate_Interest(getAccountno());

    }

    void print_statement_Admin(int Account_no) {    // Display all account details, including the bank owner details
        setAccountno(Account_no);
        printstatement(getAccountno());
    }

    void calculate_Zakat_Admin(int Account_no) {    // Specify the Zakat Rate, applicable to all Checking Accounts
            
            setAccountno(Account_no);
            calculate_Zakat1(getAccountno());
            
        
    }
}
