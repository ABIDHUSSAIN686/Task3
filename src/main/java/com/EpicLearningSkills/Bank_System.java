package com.EpicLearningSkills;


import java.util.Scanner;

public class Bank_System extends File_Handling implements Saving_Accounts {

	private String Firstname, Lastname, CNIC, Account_type;
	private int Account_no, Pin_code, Deposit_Ammounted,Withdraw_Ammounted,Balance, Modified_Balance;
	boolean Deposit_check, Withdrawcheck;

	Bank_System()// Default Constructor
	{
		Firstname="";
		Lastname="";
		CNIC="";
		Account_type="";
		Account_no=0;
		Pin_code=0;
		Deposit_Ammounted=0;
		Withdraw_Ammounted=0;
		Balance=0;
		Modified_Balance=0;
		Deposit_check = false;
		Withdrawcheck = false;
	}

	Bank_System(String f_name,String L_name,String Cnc,String Acc_type,int Acc_no,int P_code,int Deposit)// Parameterized  Constructor
	{
		Firstname=f_name;
		Lastname=L_name;
		CNIC=Cnc;
		Account_type=Acc_type;
		Account_no=Acc_no;
		Pin_code=P_code;
		Deposit_Ammounted=Deposit;

	}
	
	//Getters and Setters
	void setFirstName(String f_name)
	{
		Firstname=f_name;	
	}
	String getFirstName()
	{
		return Firstname;
	}
	void setLastName(String L_name)
	{
		Lastname=L_name;
	}
	String getLastName()
	{
		return Lastname;
	}
	void setCnic(String Cnc)
	{
		CNIC=Cnc;
	}
	String getCnic()
	{
		return CNIC;
	}
	void setAccounttype(String Acc_type)
	{
		Account_type=Acc_type;
	}
	String getAccounttype()
	{
		return Account_type;
	}


	void setPincode(int P_code)
	{
		Pin_code=P_code;
	}
	int getPincode()
	{
		return Pin_code;
	}

	void setAccountno(int Acc_no)
	{
		Account_no=Acc_no;
	}
	int getAccountno()
	{
		return Account_no;
	}
	void setDeposit(int Deposit)
	{
		Deposit_Ammounted=Deposit;
	}
	int getDeposit()
	{
		return Deposit_Ammounted;
	}
	void setWithdraw(int withdraw)
	{
		Withdraw_Ammounted=withdraw;
	}
	int getWithdraw()
	{
		return Withdraw_Ammounted;
	}




	public boolean new_Account() {  // This Function is used to create the new Account
		Balance = 0;
		boolean check=false;
		//Scanner input_command = new Scanner(System.in);
		//System.out.print("Enter your Account Number :: ");
		//Account_no = input_command.nextInt();

		String A_no = String.valueOf(getAccountno());
		if (Return_boolean_MatchingInFile("AccountNO.txt", A_no) == false) {

			//            System.out.print("Enter your First Name :: ");
			//            Firstname = input_command.next();
			//            System.out.print("Enter your Last Name :: ");
			//            Lastname = input_command.next();
			//            System.out.print("Enter your CNIC number :: ");
			//            CNIC = input_command.next();
			//            System.out.print("Enter your Account Type. Press 1 or 2 \n");
			//            System.out.println("1) Saving");
			//            System.out.println("2) Checking");
			//            int menu;
			//            menu = input_command.nextInt();
			//            switch (menu) {
			//                case 1:
			//                    Account_type = "saving";
			//                    break;
			//                case 2:
			//                    Account_type = "checking";
			//                    break;
			//            }
			//            System.out.print("Enter your Pin_Code :: ");
			//            Pin_code = input_command.nextInt();
			//
			//            System.out.print("Deposit minimum 1000 Rupees in Bank Account :: ");
			//            Deposit_Ammounted = input_command.nextInt();
			//            char check;
			//            System.out.print("Do you want to check Balance? Press Y/N ");
			//            check = input_command.next().charAt(0);
			//            if (check == 'Y' || check == 'y') {
			System.out.println("Your Balance is " + Deposit_Ammounted + "\n\n");
			//            }

			System.out.println("Thanks for Trusting us!!! Do not forgot pin code");
			generating_files();
			if (generating_files() == 1) {
				data_write();
			}
			check=true;

		} else {
			System.out.println("Account Already exists\n\n");
			check=false;
		}
		return check;
	}



	public int generating_files() {  // This Function is called when we have to generate the files.
		int check;
		check = CreateFile("Name.txt");
		CreateFile("CNIC.txt");
		CreateFile("AccountNO.txt");
		CreateFile("AccountType.txt");
		CreateFile("Pin_Code.txt");
		CreateFile("Balance.txt");
		return check;
	}

	public void data_write() {   // This function is called when we have to input the Data of separate person
		WriteToFile("Name.txt",  getFirstName()  + " " + getLastName() + "\n");
		WriteToFile("CNIC.txt", getCnic() + "\n");
		String A_no = String.valueOf(getAccountno());
		WriteToFile("AccountNO.txt", A_no + "\n");
		WriteToFile("AccountType.txt",getAccounttype() + "\n");
		String p_code = String.valueOf( getPincode());
		WriteToFile("Pin_Code.txt", p_code + "\n");
		String b_value = String.valueOf(getDeposit());
		WriteToFile("Balance.txt", b_value + "\n");

	}

	public boolean close_Account(int Acc_no) {// This Function is used to close the existing Account

		String A_no = String.valueOf(Acc_no);
		int counter = 0;
		boolean check=false;
		String old_balance, name, CNIC, Account_no, account_type, pin_code;
		if (Return_boolean_MatchingInFile("AccountNO.txt", A_no) == true || Deposit_check == true) {

			// already amount existed.
			// delete all the information from files.
			counter = Return_Count_MatchingLine("AccountNO.txt", A_no);
			old_balance = Return_Balance("Balance.txt", counter);
			name = Return_Balance("Name.txt", counter);
			CNIC = Return_Balance("CNIC.txt", counter);
			Account_no = Return_Balance("AccountNO.txt", counter);
			account_type = Return_Balance("AccountType.txt", counter);
			System.out.println(account_type);
			pin_code = Return_Balance("Pin_Code.txt", counter);

			System.out.println(name+" have balance " + old_balance);
			System.out.println("Withdraw your amount from the account");
			int index = 0;
			User obj2 = new User();  
			obj2.make_Withdrawal1(Integer.parseInt(A_no),Integer.parseInt(old_balance));
			System.out.println("Dear "+name+" having Account number "+A_no+". You have successfully withdraw amount "+old_balance);
			modifyFile("Balance.txt", counter, old_balance, "-");
			modifyFile("AccountNO.txt", counter, Account_no, "-");
			modifyFile("Name.txt", counter, name, "-");
			modifyFile("AccountType.txt", counter, account_type, "-");
			modifyFile("Pin_Code.txt", counter, pin_code, "-");
			modifyFile("CNIC.txt", counter, CNIC, "-");

			check=true;
		} else {
			System.out.println("Your Account does not exist.You have 0 Balance in the Account\n\n");
			check=false;
		}
		return check;
	}
	public boolean make_Withdrawal(int Acc_no,int Withdraw){ // This Function is used to Withdraw the Amount


		char check;
		int counter = 0;
		String oldbalance, value, balance;
		boolean check1=false;
		String A_no = String.valueOf(Acc_no);
		if (Return_boolean_MatchingInFile("AccountNO.txt", A_no) == true || Deposit_check == true) {


			Withdrawcheck = true;
			counter = Return_Count_MatchingLine("AccountNO.txt", A_no);

			if (Withdraw < Integer.parseInt(Return_Balance("Balance.txt", counter))) {
				oldbalance = Return_Balance("Balance.txt", counter);
				int i = Integer.parseInt(oldbalance);
				i = i - Withdraw;
				Balance = i;

				String old_balan = String.valueOf(oldbalance);
				balance = String.valueOf(Balance);
				modifyFile("Balance.txt", counter, old_balan, balance);


				Balance = i;

				System.out.println("Your Balance is " + Balance + "\n\n");
				check1=true;
			} else {
				System.out.println("Your Withdraw Amount Exceeds Balance Limit.\n\n");
				check1=false;
			}


		} else {
			System.out.println("Your Account does not exist.You have 0 Balance in the Account\n\n");
			check1=false;
		}
		return check1;
	}

	public boolean make_Deposit(int  Acc_no,int Deposit) { // This Function is used to Deposit the Amount

		Deposit_check = true;
		char check;
		int counter = 0;
		boolean check1=false;
		String oldbalance, value, balance;
		String A_no = String.valueOf(Acc_no);
		if (Return_boolean_MatchingInFile("AccountNO.txt", A_no) == true) {
			counter = Return_Count_MatchingLine("AccountNO.txt", A_no);
			oldbalance = Return_Balance("Balance.txt", counter);
			int i = Integer.parseInt(oldbalance);
			Deposit = Deposit + i;
			String old_balan = String.valueOf(oldbalance);
			balance = String.valueOf(Deposit);
			modifyFile("Balance.txt", counter, old_balan, balance);

			System.out.println("Your Balance is " + balance + "\n\n");
			check1=true;
		} else {
			System.out.println("Create your Account First\n\n");
			check1=false;
		}
		return check1;
	}

	public boolean printstatement(int Acc_no) {  // This Function is used to print the Bank Statement

		int counter = 0;
		String name, cnic, accounttype, balance;
		boolean check=false;
		String A_no = String.valueOf(Acc_no);
		if (Return_boolean_MatchingInFile("AccountNO.txt", A_no) == true) {
			counter = Return_Count_MatchingLine("AccountNO.txt", A_no);

			name = Return_Balance("Name.txt", counter);
			cnic = Return_Balance("CNIC.txt", counter);
			accounttype = Return_Balance("AccountType.txt", counter);
			balance = Return_Balance("Balance.txt", counter);

			System.out.println("Your Accountno is " + Account_no);
			System.out.println("Your Name  is " + name);
			System.out.println("Your CNIC is " + cnic);
			System.out.println("Your AccountType is " + accounttype);
			System.out.println("Your Balance is " + balance + "\n\n");
			check=true;
		} else {
			System.out.println("Sorry, you do not have account. Create your account First\n");
			check=false;
		}
		return check;
	}

	public boolean DisplayAllDeduction(int Acc_no) {  // This Function is used to Display all Deduction on Bank Account

		double CheckZakat;
		double CheckTax;
		int counter = 0;
		double zakatpercent = 0.025;
		boolean check=false;
		String oldbalance, accounttype;
		String A_no = String.valueOf(Acc_no);
		if (Return_boolean_MatchingInFile("AccountNO.txt", A_no) == true) {
			counter = Return_Count_MatchingLine("AccountNO.txt", A_no);
			accounttype = Return_Balance("AccountType.txt", counter);
			oldbalance = Return_Balance("Balance.txt", counter);
			if (accounttype.equals("saving")) {
				int i = Integer.parseInt(oldbalance);
				CheckZakat = i * zakatpercent;
				System.out.println("Your Account Type is " + accounttype + ".");
				System.out.println(" And amount of Deduction on Account is " + CheckZakat + "\n\n");
			} else if (accounttype.equals("checking")) {
				int j = Integer.parseInt(oldbalance);
				CheckTax = j * zakatpercent;
				CheckTax = CheckTax + j * 0.25;
				System.out.println("Your Account Type   is " + accounttype + ".");
				System.out.println("And amount of Deduction on Account is " + CheckTax + ". As per 10% policy of Bank plus Zakat\n\n");
			}
			check=true;
		} else {
			System.out.println("Sorry, you do not have account. Create your account First\n");
			check=false;
		}
		return check;
	}



	public boolean Transfer_Amount1(int Account_no,int secondAccount,int Deposit) { // This function is used to transfer amount in others Account 

		String  balance1;
		int counter1;
		// This Function is used to Transfer Amount in the Bank Account
		String balance2;
		int balance,counter2;
		boolean check=false;
		Scanner input_command = new Scanner(System.in);
		//System.out.print("Enter your Account Number :: ");
		//int Account_no = input_command.nextInt();
		String A_no1 = String.valueOf(Account_no);
		if (Return_boolean_MatchingInFile("AccountNO.txt", A_no1) == true) {
			//System.out.print("Enter Account you want to Transfer\n");
			//secondAccount = input_command.next();
			String A_no2 = String.valueOf(secondAccount);
			if (Return_boolean_MatchingInFile("AccountNO.txt", A_no2) == true) {

				counter1 = Return_Count_MatchingLine("AccountNO.txt", A_no1);
				balance1 = Return_Balance("Balance.txt", counter1);
				System.out.println("Your Balance is " + balance1);
				// System.out.print("Enter Amount you want to Transfer :: ");
				// Deposit = input_command.nextInt();
				if (Deposit < Integer.parseInt(balance1)) {

					balance = Deposit;
					counter2 = Return_Count_MatchingLine("AccountNO.txt", A_no2);
					balance2 = Return_Balance("Balance.txt", counter2);
					int i = Integer.parseInt(balance2);
					Deposit = Deposit + i;
					String old_balan = String.valueOf(balance2);
					modifyFile("Balance.txt", counter2, old_balan, String.valueOf(Deposit));
					int j = Integer.parseInt(balance1);
					j = j - balance;
					String old_balan1 = String.valueOf(balance1);
					modifyFile("Balance.txt", counter1, old_balan1, String.valueOf(j));
				} else {
					System.out.println("Your Withdraw Amount exceed the Balance\n");
					
				}

				check=true;

			} else {
				System.out.println("Sorry, the account in which you want to transfer does not exist\n");
				check=false;
			}
		} else {
			System.out.println("Sorry, you do not have account. Create your account First\n");
			check=false;
			
		}
return check;
	}



	public String  check_Balance1(int Acc_no) throws Exception// This function is used to check the balance in Account
	{
		int counter = 0;
		String oldbalance="";
		String A_no = String.valueOf(Acc_no);
		if (Return_boolean_MatchingInFile("AccountNO.txt", A_no) == true) {
			counter = Return_Count_MatchingLine("AccountNO.txt", A_no);
			oldbalance = Return_Balance("Balance.txt", counter);
			System.out.println("Your Balance is " + oldbalance + "\n\n");
		} else {
			throw new Exception("Sorry, you do not have account. Create your account First"); 
			//System.out.println("Sorry, you do not have account. Create your account First\n");
		}

		return oldbalance;
	}
	public double calculate_Zakat1(int Acc_no)// This function is used to calculate the zakaat.
	{
		int counter = 0;
		double zakatpercent = 0.025;
		String oldbalance, accounttype = "", balance;
		double CheckZakat=0.0;
		String A_no = String.valueOf(Acc_no);
		if (Return_boolean_MatchingInFile("AccountNO.txt", A_no) == true) {
			counter = Return_Count_MatchingLine("AccountNO.txt", A_no);
			accounttype = Return_Balance("AccountType.txt", counter);
			if (accounttype.equals("saving")) {
				balance = Return_Balance("Balance.txt", counter);
				int j = Integer.parseInt(balance);
				if (j > 20000) {
					counter = Return_Count_MatchingLine("AccountNO.txt", A_no);
					oldbalance = Return_Balance("Balance.txt", counter);
					int i = Integer.parseInt(oldbalance);
					CheckZakat = i * zakatpercent;
					System.out.println("Your Zakat  is " + CheckZakat + "\n\n");
				} else {
					System.out.println("Your Balance is less than 20000 \n\n");
				}

			} else {
				System.out.println("Your Account is Current Account. And Zakat Policy does not Hold\n\n");
			}
		} else {
			System.out.println("Sorry, you do not have account. Create your account First\n");
		}
		return CheckZakat;
	}
	public boolean Calculate_Interest(int Acc_no) throws Exception// This function is used to calculate the interest
	{
		int counter = 0;
		String oldbalance;
		double final_amount = 0.0;
		boolean check=false;
		String A_no = String.valueOf(Acc_no);
		if (Return_boolean_MatchingInFile("AccountNO.txt", A_no) == true) {
			counter = Return_Count_MatchingLine("AccountNO.txt", A_no);
			oldbalance = Return_Balance("Balance.txt", counter);
			System.out.println("Your Balance is " + oldbalance + "\n\n");

			int j= Integer.parseInt(oldbalance);

			double interest_rate = j * 0.25;
			System.out.println("Your interest on your Balance is  " + interest_rate);

			final_amount = interest_rate + j;
			System.out.println("So, total Amount after interest is " + final_amount + "\n\n");

			check=true;
		} else {
			//System.out.println("Sorry, you do not have account. Create your account First\n");
			check=false;
			throw new Exception("Sorry, you do not have account. Create your account First"); 
		}

		return check;
	}
}

