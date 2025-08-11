package demo;

//3. Create an abstract class BankAccount:

//Fields: accountNumber, balance
//Abstract method calculateInterest()
//Method to print balance
//Subclasses: 
//savingsAccount with 4% interest
//FixedDepositAccount with 6.5% interest

abstract class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    abstract double calculateInterest();

    void printBalance() {
        System.out.println("Account " + accountNumber + " Balance: ₹" + balance);
    }
}

class SavingsAccount extends BankAccount {
    SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    double calculateInterest() {
        return balance * 0.04;
    }
}

class FixedDepositAccount extends BankAccount {
    FixedDepositAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    double calculateInterest() {
        return balance * 0.065;
    }
}

public class lab_prog3 {
    public static void main(String[] args) {
        BankAccount sa = new SavingsAccount("SA123", 100000);
        BankAccount fd = new FixedDepositAccount("FD456", 200000);

        sa.printBalance();
        System.out.println("Savings Interest: ₹" + sa.calculateInterest());

        fd.printBalance();
        System.out.println("FD Interest: ₹" + fd.calculateInterest());
    }
}

