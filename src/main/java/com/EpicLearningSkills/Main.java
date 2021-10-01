package com.EpicLearningSkills;


import java.util.Scanner;
/*
// This is our Main Class
public class Main {

    public static void main(String[] args) {

        int user_input, admin_input;
        boolean quit = false;
        Bank_System obj = new Bank_System();
        User obj2 = new User();
        Admin obj1 = new Admin();
		Scanner input_command = new Scanner(System.in);
        System.out.println("\nHello Welcome to Private Zamana Limited Bank");
        // Here Starts our Menu
        do {
            System.out.println("Do you want to access as Admin or user");
            System.out.println("Press 1 for Admin and Press 2 for user");
            System.out.println("Press 0 to LOGOUT");
            admin_input = input_command.nextInt();
            switch (admin_input) {
                case 1:

                    System.out.println("Welcome Admin, Enter your Personal Password");
                    String password = "", confirm_password = "admin";
                    password = input_command.next();
                    if (obj1.password(password)==true) {

                        boolean check1=false;
                        do{
                        System.out.println("Congratulations you have successfully login as Admin");
                        System.out.println("Press 1 to open new Account and close Account");
                        System.out.println("Press 2 to Print the Statement of your Bank Account");
                        System.out.println("Press 3 to Calculate the Zakat");
                        System.out.println("Press 4 to Display all the deduction on your Bank Account");
                        System.out.println("Press 5 to Calculate interest on Saving Accounts");
                        System.out.println("Press 0 to Exit!!!!!!!!\n\n");
                        System.out.println("Please input your choice");
                        user_input = input_command.nextInt();
                        switch (user_input) {
                            case 1:
                                obj1.get_approval_of_Account();
                                break;
                            case 2:
                           
                                System.out.print("Enter your Account Number :: ");
                                int Account_no = input_command.nextInt();
                                obj1.print_statement_Admin(Account_no);
                                break;
                            case 3:
                            	
                                System.out.print("Enter your Account Number :: ");
                                Account_no = input_command.nextInt();
                                obj1.calculate_Zakat_Admin(Account_no);
                                break;
                            case 4:
                                System.out.print("Enter your Account Number :: ");
                                 Account_no = input_command.nextInt();
                                
                                obj1.DisplayAllDeduction_Admin(Account_no);
                                break;
                            case 5:
                                 System.out.print("Enter your Account Number :: ");
                                  Account_no = input_command.nextInt();
                                obj1.calculate_interest_Admin(Account_no);
                                break;
                            case 0:
                                obj.Deposit_check = false;
                                obj.Withdrawcheck = false;
                                check1=true;
                                break;
                        }
                        }while(!check1);
                        System.out.println("You are logout from Admin\n\n");

                    } else {
                        System.out.println("Your identity is not clear ^|^\n\\n");
                    }
                    break;
                case 2:
                    boolean check2=false;
                    do{
                    System.out.println("Congratulations you have successfully login as user");
                    System.out.println("Press 1 to Enter the Amount you want to deposit in your Bank Account ");
                    System.out.println("Press 2 to Enter the Amount you want to withdraw from your Bank Account");
                    System.out.println("Press 3 to Enter the Account number to check the Balance of your Account");
                    System.out.println("Press 4 to Enter the Account number in which you want to transfer the Money");
                    System.out.println("Press 0 to Exit!!!!!!!!\n\n");
                    System.out.println("Please input your choice");
                    user_input = input_command.nextInt();
                    switch (user_input) {
                        case 1:
                            obj.Deposit_check = false;
                            obj.Withdrawcheck = false;
                            System.out.print("Enter your Account Number :: ");
                            int Account_no = input_command.nextInt();
                            System.out.print("Enter Amount you want to deposit :: ");
                            int Deposit = input_command.nextInt();
                            obj2.make_Deposit1(Account_no,Deposit);
                            break;
                        case 2:
                        	
                        	System.out.print("Enter your Account Number :: ");
                             Account_no = input_command.nextInt();
                            System.out.print("Enter Amount you want to Withdraw :: ");
                            int Withdraw = input_command.nextInt();
                            obj2.make_Withdrawal1(Account_no,Withdraw);
                            break;
                        case 3:
                        	
                            System.out.print("Enter your Account Number :: ");
                             Account_no = input_command.nextInt();   
                            obj2.check_Balance(Account_no);
                            break;

                          
                        case 4:
                        	
                           obj.Transfer_Amount();
                            break;
                        case 0:
                            obj.Deposit_check = false;
                            obj.Withdrawcheck = false;
                            check2=true;
                            break;
                    }
                    }while(!check2);
                    System.out.println("You are logout from User\n\n");
                    break;
                case 0:
                    quit = true;
                    break;
            }

        } while (!quit);
        System.out.println("Thanks for visiting us!");

    }
}*/
