/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts;

/**
 *
 * @author Chamodi
 */
public class Accounts {
        int accountNo;
        String accountName;
        double accountBal;
        void depoiste (double deposite ){
            accountBal=accountBal+ deposite;
        }
        void withdraw(double withdraw ){
            accountBal=accountBal- withdraw;
        }
        double getAccountBal(){
            return accountBal;
        }
        int getAccountNo(){
            return accountNo;
        }
            
        }
class SavingsAccounts extends Accounts{
    double interestRate;
    double interestAmount;
    void setInterestRate(double interestRate){
        this.interestRate=interestRate;
    }
    void calculateInterest(){
        interestAmount=accountBal*interestRate;
        accountBal=accountBal+interestAmount;
    }
    double getInterestAmount(){
        return interestAmount;
    }
    public SavingsAccounts (String accName,int accNo,double accBal ){
        accountName=accName;
        accountNo=accNo;
        accountBal=accBal;
     }
}
class CurrentAccounts extends Accounts{
    double overdraftAmount;
    double interestChargeRate;
    double interestChargeAmount;
    static double maxOverDrawlimit=200000;
  void withdraw(double withdraw){
      if(-(accountBal-withdraw)(=maxOverDrawlimit)){
          accountBal=accountBal-withdraw;
          if(accountBal<0){
              overdraftAmount=-accountBal;
           }
      }else{
      }
  }
    void setInterestChargeRate(double interestChargeRate){
            this.interestChargeRate=interestChargeRate;
}
    void setMaxOverdrawnAmount(double maxOverdrawnAmount){
    this.maxOverdrawnAmount=maxOverdrawnAmount;
}
    void CalculateInterestCharge(){
    
     
            interestChargeAmount=overdraftAmount*interestChargeRate;
            overDra
            accountBal=accountBal-interestChargeAmount;
        
    }
    double getOverdraftAmount(){
        return overdraftAmount;
    }
    double getInterestChargeAmount(){
        return interestChargeAmount;
    }
   }
    /**
     * @param args the command line arguments
     */
class Test{
    public static void main(String[] args) {
        Accounts a=new CurrentAccounts();
        Accounts b=new SavingsAccounts();
       System.out.println("AccountNo=");
       System.out.println("Account Holder=");
        a.getAccountBal();
        a.getAccountNo();
       
        // TODO code application logic here
    }
}
