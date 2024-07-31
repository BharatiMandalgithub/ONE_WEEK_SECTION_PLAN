/*
 You need to design a simple banking system where customers can open accounts, deposit money, and withdraw money, Each cusomer has a name and 
 a unique account number. Each account tracks the balance and the customer associated with it.
 Requirements:
 customer Class: 
 Attributes: name, account number.   
 Methods: getAccountNumber, getName.   
 Account class:  
 Attributes: account number, 
 balance, customer.    
 Methods: deposit,withdraw,getBalance, getCustomer
 */


package anudip.com;

/**
 * Represents a customer in the banking system.
 */
public class Customer {
    private String name;
    private long accountNumber;

    /**
     * Constructor to initialize the customer with a name and account number.
     * 
     * @param name The name of the customer.
     * @param accountNumber The unique account number of the customer.
     */
    public Customer(String name, long accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    /**
     * Gets the account number of the customer.
     * 
     * @return The account number.
     */
    public long getAccountNumber() {
        return accountNumber;
    }

    /**
     * Gets the name of the customer.
     * 
     * @return The name of the customer.
     */
    public String getName() {
        return name;
    }
}


