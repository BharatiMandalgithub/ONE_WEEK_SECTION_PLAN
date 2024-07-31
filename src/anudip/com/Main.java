package anudip.com;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * Main class for managing the banking system operations.
 */
public class Main {
    private static final Map<Long, Account> accounts = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Open a New Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> openAccount();
                    case 2 -> depositMoney();
                    case 3 -> withdrawMoney();
                    case 4 -> checkBalance();
                    case 5 -> exit = true;
                    default -> System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the buffer
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
        scanner.close();
    }

    /**
     * Opens a new bank account with the provided customer details.
     */
    private static void openAccount() {
        try {
            System.out.print("Enter customer name: ");
            String name = scanner.nextLine();

            if (!isValidName(name)) {
                System.out.println("Invalid name. Name cannot be empty or contain invalid characters.");
                return;
            }

            System.out.print("Enter 16-digit account number: ");
            long accountNumber = scanner.nextLong();
            scanner.nextLine(); // Consume newline

            if (!isValidAccountNumber(accountNumber)) {
                System.out.println("Invalid account number. It must be 16 digits.");
                return;
            }

            if (accounts.containsKey(accountNumber)) {
                System.out.println("Account with this number already exists.");
                return;
            }

            Customer customer = new Customer(name, accountNumber);
            Account account = new Account(accountNumber, customer);
            accounts.put(accountNumber, account);

            System.out.println("Account successfully created for " + name + " with account number " + accountNumber);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Account number should be a 16-digit number.");
            scanner.nextLine(); // Clear the buffer
        }
    }

    /**
     * Deposits money into an existing account.
     */
    private static void depositMoney() {
        try {
            System.out.print("Enter 16-digit account number: ");
            long accountNumber = scanner.nextLong();

            if (!isValidAccountNumber(accountNumber)) {
                System.out.println("Invalid account number. It must be 16 digits.");
                return;
            }

            Account account = accounts.get(accountNumber);
            if (account != null) {
                System.out.print("Enter deposit amount: ");
                double amount = scanner.nextDouble();
                account.deposit(amount);
            } else {
                System.out.println("Account not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
            scanner.nextLine(); // Clear the buffer
        }
    }

    /**
     * Withdraws money from an existing account.
     */
    private static void withdrawMoney() {
        try {
            System.out.print("Enter 16-digit account number: ");
            long accountNumber = scanner.nextLong();

            if (!isValidAccountNumber(accountNumber)) {
                System.out.println("Invalid account number. It must be 16 digits.");
                return;
            }

            Account account = accounts.get(accountNumber);
            if (account != null) {
                System.out.print("Enter withdrawal amount: ");
                double amount = scanner.nextDouble();
                account.withdraw(amount);
            } else {
                System.out.println("Account not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
            scanner.nextLine(); // Clear the buffer
        }
    }

    /**
     * Checks the balance of an existing account.
     */
    private static void checkBalance() {
        try {
            System.out.print("Enter 16-digit account number: ");
            long accountNumber = scanner.nextLong();

            if (!isValidAccountNumber(accountNumber)) {
                System.out.println("Invalid account number. It must be 16 digits.");
                return;
            }

            Account account = accounts.get(accountNumber);
            if (account != null) {
                System.out.println("The balance for account " + accountNumber + " is $" + account.getBalance());
            } else {
                System.out.println("Account not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
            scanner.nextLine(); // Clear the buffer
        }
    }

    /**
     * Validates if the account number is exactly 16 digits.
     * 
     * @param accountNumber The account number to be validated.
     * @return true if the account number is valid; false otherwise.
     */
    private static boolean isValidAccountNumber(long accountNumber) {
        return String.valueOf(accountNumber).length() == 16;
    }

    /**
     * Validates if the name is non-empty and contains only valid characters (alphabetic and spaces).
     * 
     * @param name The name to be validated.
     * @return true if the name is valid; false otherwise.
     */
    private static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty() && name.matches("[a-zA-Z ]+");
    }
}

