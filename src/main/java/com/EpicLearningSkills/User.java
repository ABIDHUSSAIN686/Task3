package com.EpicLearningSkills;

import java.util.Scanner;

public class User extends Bank_System {

    public void  check_Balance(int Account_no) throws Exception {  // This Function is used Check Balance for separate Account
    	setAccountno(Account_no);
        check_Balance1(getAccountno());
        
    }
    
    
    public void make_Deposit1(int  A_no,int Deposit) {
    	setAccountno(A_no);
    	setDeposit(Deposit);
        make_Deposit(getAccountno(),getDeposit());
        
    }
    
    public void make_Withdrawal1(int A_no,int Withdraw){
        setAccountno(A_no);
        setWithdraw(Withdraw);
        make_Withdrawal(getAccountno(),getWithdraw());
       
    }
     
}
