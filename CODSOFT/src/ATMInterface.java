//TASK 3: ATM INTERFACE
import java.util.Scanner;

// Class representing a bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! Your new balance is: $" + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! Your new balance is: $" + balance);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
        return false;
    }
}

// Class representing the ATM
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("\n--- ATM Menu ---");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    public void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public void withdraw(double amount) {
        account.withdraw(amount);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        do {
            displayMenu();
            try {
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = Double.parseDouble(scanner.nextLine());
                        deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = Double.parseDouble(scanner.nextLine());
                        withdraw(withdrawalAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        } while (option != 4);

        scanner.close();
    }
}

public class ATMInterface {
	public static void main(String[] args) {
        BankAccount account = new BankAccount(500.00); //initial balaNce of 500$
        ATM atm = new ATM(account);
        atm.run();
}

}
