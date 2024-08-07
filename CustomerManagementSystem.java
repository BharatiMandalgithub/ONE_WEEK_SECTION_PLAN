/*
 You are a software developer working on a customer management system for a retail company.

The company wants to maintain a list of customers and perform various operations on this list.

Each customer has a unique ID, name, and email. The company needs to perform the following

operations:

1. Add a Customer: Add a new customer to the list.

2. Remove a Customer: Remove a customer from the list using their ID.

3. Search for a Customer: Search for a customer by their ID and return their details.

4. List All Customers: Display all customers in the list.

5. Sort Customers by Name: Sort the customers alphabetically by their name.

6. Sort Customers by ID: Sort the customers numerically by their ID.
  */


package anudip3.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CustomerManagementSystem {
    private List<Customer> customers;
    private Scanner scanner;

    public CustomerManagementSystem() {
        this.customers = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Add a new customer
    public void addCustomer() {
        System.out.println("Enter customer ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter customer name:");
        String name = scanner.nextLine();
        System.out.println("Enter customer email:");
        String email = scanner.nextLine();

        Customer newCustomer = new Customer(id, name, email);
        customers.add(newCustomer);
        System.out.println("Customer added successfully.");
    }

    // Remove a customer by ID
    public void removeCustomer() {
        System.out.println("Enter customer ID to remove:");
        int id = scanner.nextInt();

        boolean removed = customers.removeIf(customer -> customer.getId() == id);
        if (removed) {
            System.out.println("Customer removed successfully.");
        } else {
            System.out.println("Customer with ID " + id + " not found.");
        }
    }

    // Search for a customer by ID
    public void searchCustomerById() {
        System.out.println("Enter customer ID to search:");
        int id = scanner.nextInt();

        Customer customer = searchCustomer(id);
        if (customer != null) {
            System.out.println("Customer found: " + customer);
        } else {
            System.out.println("Customer with ID " + id + " not found.");
        }
    }

    // Helper method to search for a customer
    private Customer searchCustomer(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    // List all customers
    public void listAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers available.");
        } else {
            System.out.println("All Customers:");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    // Sort customers by name
    public void sortCustomersByName() {
        Collections.sort(customers, Comparator.comparing(Customer::getName));
        System.out.println("Customers sorted by name.");
    }

    // Sort customers by ID
    public void sortCustomersById() {
        Collections.sort(customers, Comparator.comparingInt(Customer::getId));
        System.out.println("Customers sorted by ID.");
    }

    // Display menu and handle user input
    public void displayMenu() {
        while (true) {
            System.out.println("\nCustomer Management System Menu:");
            System.out.println("1. Add Customer");
            System.out.println("2. Remove Customer");
            System.out.println("3. Search Customer by ID");
            System.out.println("4. List All Customers");
            System.out.println("5. Sort Customers by Name");
            System.out.println("6. Sort Customers by ID");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    removeCustomer();
                    break;
                case 3:
                    searchCustomerById();
                    break;
                case 4:
                    listAllCustomers();
                    break;
                case 5:
                    sortCustomersByName();
                    listAllCustomers();
                    break;
                case 6:
                    sortCustomersById();
                    listAllCustomers();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        CustomerManagementSystem cms = new CustomerManagementSystem();
        cms.displayMenu();
    }
}
