package com.EpicLearningSkills;

import static org.junit.Assert.*;

import org.junit.Test;

public class TEST_CASES {

	@Test
	public void true_test() {// true case 
		Admin test=new Admin();
		boolean output= test.password("admin");
		assertEquals(true,output);
	}
	@Test
	public void false_test() {// false case
		Admin test=new Admin();
		boolean output= test.password("user");
		assertEquals(false,output);
	}
	@Test
	public void Account_Number_Duplication1() { // true case 
		File_Handling test=new File_Handling();
		String A_no = String.valueOf(123456789);
		boolean check;
		check=test.Return_boolean_MatchingInFile("AccountNO.txt", A_no);
		
		assertEquals(true,check);
	}
	@Test
	public void Account_Number_Duplication2() { // false case 
		File_Handling test=new File_Handling();
		String A_no = String.valueOf(123789456);
		boolean check;
		check=test.Return_boolean_MatchingInFile("AccountNO.txt", A_no);
		
		assertEquals(false,check);
	}
	@Test
	public void CNIC_Duplication1() { // true case
		File_Handling test=new File_Handling();
		String CNIC_no = "3730158815021";
		boolean check;
		check=test.Return_boolean_MatchingInFile("CNIC.txt", CNIC_no);
		assertEquals(true,check);
	}
	@Test
	public void CNIC_Duplication2() { // false case 
		File_Handling test=new File_Handling();
		String CNIC_no = "3730158815022";
		boolean check;
		check=test.Return_boolean_MatchingInFile("CNIC.txt", CNIC_no);
		assertEquals(false,check);
	}	
	
	@Test
	public void Account_Number_Does_Exist() { // True case
		int counter ;
		File_Handling test=new File_Handling();
		counter= test.Return_Count_MatchingLine("AccountNO.txt", "123456789");
		String accountno = test.Return_Balance("AccountNO.txt", counter);
		assertEquals("123456789",accountno);
	}
	@Test
	public void CNIC_Does_Exist() { //True case
		int counter ;
		File_Handling test=new File_Handling();
		counter= test.Return_Count_MatchingLine("CNIC.txt", "3730158815021");
		String accountno = test.Return_Balance("CNIC.txt", counter);
		assertEquals("3730158815021",accountno);
	}
	@Test
	public void File_Created() { // True case
		File_Handling test=new File_Handling();
		int check=test.CreateFile("CNIC.txt");
		assertEquals(1,check);
	}
	
	@Test
	public void Check_Balance() throws Exception {//true test case
		Bank_System test= new Bank_System();
		String amount=test.check_Balance1(123456789);
		assertEquals("20050",amount);
	}
	
	@Test(expected = Exception.class)
	public void Check_Balance_1() throws Exception{//true test case
		Bank_System test= new Bank_System();
		test.check_Balance1(145789565);		
	}

	@Test
	public void Check_Zakaat() {//true test case
		Bank_System test= new Bank_System();
		double amount=test.calculate_Zakat1(123456789);
		boolean check=false;
		if (amount==501.25)
		{
			check=true;
		}
		else 
		{
			check=false;
		}
		System.out.println(check);
		assertEquals(true,check);
	}
	
	@Test
	public void Check_Interest_true() throws Exception {//true test case
		
		Bank_System test= new Bank_System();
		boolean amount=test.Calculate_Interest(123456789);
		assertEquals(true,amount);
	}
	@Test(expected = Exception.class)
	public void Check_Interest_false() throws Exception {// false test case
		
		Bank_System test= new Bank_System();
		test.Calculate_Interest(123789456);
	}
	  
	@Test
	public void Check_Deduction() {//true test case
		
		Bank_System test= new Bank_System();
		boolean check= test.DisplayAllDeduction(456123456);
		assertEquals(true,check);
	}
	@Test
	public void Check_Deduction1() {// false test case
		
		Bank_System test= new Bank_System();
		boolean check= test.DisplayAllDeduction(1111111);
		assertEquals(false,check);
	}
	@Test
	public void Print_Statment() {// false test case
		
		Bank_System test= new Bank_System();
		boolean check= test.printstatement(1111111);
		assertEquals(false,check);
	}
	@Test
	public void Print_Statment1() {//true test case
		
		Bank_System test= new Bank_System();
		boolean check= test.printstatement(456123456);
		assertEquals(true,check);
	}
	@Test
	public void make_Deposit_Test() {//true test case
		
		Bank_System test= new Bank_System();
		test.setAccountno(456123456);
		test.setDeposit(5000);
		boolean check= test.make_Deposit(test.getAccountno(), test.getDeposit());
		assertEquals(true,check);
	}
	@Test
	public void make_Deposit_Test1() {// false test case
		
		Bank_System test= new Bank_System();
		test.setAccountno(456123478);
		test.setDeposit(5000);
		boolean check= test.make_Deposit(test.getAccountno(), test.getDeposit());
		assertEquals(false,check);
	}
	
	@Test
	public void make_Withdraw_Test() {//true test case
		
		Bank_System test= new Bank_System();
		test.setAccountno(456123456);
		test.setWithdraw(5000);
		boolean check= test.make_Withdrawal(test.getAccountno(), test.getWithdraw());
		assertEquals(true,check);
	}
	@Test
	public void make_Withdraw_Test1() {// false test case
		
		Bank_System test= new Bank_System();
		test.setAccountno(456123478);
		test.setWithdraw(5000);
		boolean check= test.make_Withdrawal(test.getAccountno(), test.getWithdraw());
		assertEquals(false,check);
	}
	@Test
	public void make_Withdraw_Test2() {// false test case
		
		Bank_System test= new Bank_System();
		test.setAccountno(456123456);
		test.setWithdraw(800000);
		boolean check= test.make_Withdrawal(test.getAccountno(), test.getWithdraw());
		assertEquals(false,check);
	}
	
	@Test
	public void transferAmount() throws Exception {//true test case
		
		
		Bank_System test=new Bank_System();
		Bank_System test1=new Bank_System();
		test.setAccountno(999999999);
		test1.setAccountno(888888888);
		boolean check3= test.Transfer_Amount1(test.getAccountno(),test1.getAccountno(),200);
		assertEquals(true,check3);
	}
	@Test
	public void transferAmount1(){// false test case
		
		
		Bank_System test=new Bank_System();
		Bank_System test1=new Bank_System();
		test.setAccountno(523654789);
		test1.setAccountno(888888888);
		test.Transfer_Amount1(test.getAccountno(),test1.getAccountno(),200);
	}
	@Test
	public void transferAmount2() {// false test case
		
		
		Bank_System test=new Bank_System();
		Bank_System test1=new Bank_System();
		test.setAccountno(999999999);
		test1.setAccountno(523654789);
        test.Transfer_Amount1(test.getAccountno(),test1.getAccountno(),200);
	}
	
	@Test
public void openAccount() {//true test case
		
		Bank_System test= new Bank_System();
		Bank_System obj=new Bank_System("Mehmood","Amjad","3730569945121","checking",333333333,1056,890000);
		boolean check=obj.new_Account();
		assertEquals(true,check);
	}
	@Test
	public void closeAccount() {//true test case
		
		Bank_System test= new Bank_System();
		test.setAccountno(333333333);
		boolean check= test.close_Account(test.getAccountno());
		assertEquals(true,check);
	}
	@Test
	public void closeAccount1() {// false test case
		
		Bank_System test= new Bank_System();
		test.setAccountno(333333322);
		boolean check= test.close_Account(test.getAccountno());
		assertEquals(false,check);
	}
		

	
}
