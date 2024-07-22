import java.util.Scanner;

public class ATM_Interface {

    static class BankAccount {
        private double balance;

        public BankAccount(double balance) {
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return true;
            }
            return false;
        }
    }

    static class ATM {
        private BankAccount account;

        public ATM(BankAccount account) {
            this.account = account;
        }

        public void withdraw(double amount) {
            if (account.withdraw(amount)) {
                System.out.printf("Withdrew ₹%.2f. New balance: ₹%.2f.%n", amount, account.getBalance());
            } else {
                System.out.println("Insufficient funds or invalid amount.");
            }
        }

        public void deposit(double amount) {
            if (amount > 0) {
                account.deposit(amount);
                System.out.printf("Deposited ₹%.2f. New balance: ₹%.2f.%n", amount, account.getBalance());
            } else {
                System.out.println("Invalid amount. Please enter a positive number.");
            }
        }

        public void checkBalance() {
            System.out.printf("Current balance: ₹%.2f.%n", account.getBalance());
        }
    }

    public static void atmInterface(ATM atm) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.print("Choose an option (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Exiting ATM. Have a nice day!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // Initialize account with ₹1000
        ATM atm = new ATM(account);
        atmInterface(atm);
    }
}
