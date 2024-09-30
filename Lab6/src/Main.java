
import Entity.CurrentAccount;
import Entity.SavingsAccount;

public class Main {
    public static void main(String[] args) {
        double ibal, damt, wamt;


        ibal = 1000.00;
        SavingsAccount savingsAccount = new SavingsAccount("SA001", ibal);
        System.out.println("Savings A/C: Initial Balance: $" + ibal);


        damt = 1600.00;
        savingsAccount.deposit(damt);
        wamt = 500.00;
        savingsAccount.withdraw(wamt);


        System.out.println();


        ibal = 5000.00;
        CurrentAccount currentAccount = new CurrentAccount("CA001", ibal);
        System.out.println("Current A/C: Initial Balance: $" + ibal);


        damt = 2500.00;
        currentAccount.deposit(1000.00);
        currentAccount.withdraw(3000.00);


        wamt = 6000.00;
        System.out.println("\nTry to withdraw: $" + wamt);
        savingsAccount.withdraw(wamt);
    }
}