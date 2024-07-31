package anudip.com;

/**
 * Represents a bank account associated with a customer.
 */
public class Account {
    private long accountNumber;
    private double balance;
    private Customer customer;

    /**
     * Constructor to initialize the account with an account number and associated customer.
     * 
     * @param accountNumber The unique account number of the account.
     * @param customer The customer associated with this account.
     */
    public Account(long accountNumber, Customer customer) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = 0.0;
    }

    /**
     * Deposits a specified amount into the account.
     * 
     * @param amount The amount to be deposited. Must be positive.
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " into account " + accountNumber);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    /**
     * Withdraws a specified amount from the account.
     * 
     * @param amount The amount to be withdrawn. Must be positive.
     */
    public void withdraw(double amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Withdrawal amount must be positive.");
            }
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrew $" + amount + " from account " + accountNumber);
            } else {
                throw new InsufficientFundsException("Insufficient balance for withdrawal.");
            }
        } catch (IllegalArgumentException | InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Gets the current balance of the account.
     * 
     * @return The current balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Gets the customer associated with this account.
     * 
     * @return The customer.
     */
    public Customer getCustomer() {
        return customer;
    }
}

/**
 * Custom exception class for handling insufficient funds scenarios.
 */
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

