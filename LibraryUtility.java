/*
 You are a software developer tasked with creating a small utility for a library system. 
The library wants to maintain a list of book titles and perform various operations on this list. 
Each title is stored as a string in an array. The library wants to be able to do the following:

1. Add a Book Title: Add a new book title to the list.
2. Remove a Book Title: Remove a specific book title from the list.
3. Search for a Book Title: Search for a book title and return its index if found.
4. List All Book Titles: Display all the book titles in the list.
5. Sort Book Titles: Sort the book titles alphabetically.
 */


package anudip1.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Utility class for managing a list of book titles in a library system.
 */
public class LibraryUtility {
    private List<String> bookTitles;

    /**
     * Constructor initializes an empty list of book titles.
     */
    public LibraryUtility() {
        this.bookTitles = new ArrayList<>();
    }

    /**
     * Adds a new book title to the list.
     * 
     * @param title the title of the book to be added
     * @throws IllegalArgumentException if the title is null or empty
     */
    public void addBookTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid title. Cannot be null or empty.");
        }
        bookTitles.add(title);
    }

    /**
     * Removes a specific book title from the list.
     * 
     * @param title the title of the book to be removed
     * @throws IllegalArgumentException if the title is null
     */
    public void removeBookTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null.");
        }
        if (bookTitles.contains(title)) {
            bookTitles.remove(title);
        } else {
            System.out.println("Title not found.");
        }
    }

    /**
     * Searches for a book title and returns its index if found.
     * 
     * @param title the title of the book to search for
     * @return the index of the book title if found, otherwise -1
     * @throws IllegalArgumentException if the title is null
     */
    public int searchBookTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null.");
        }
        return bookTitles.indexOf(title);
    }

    /**
     * Displays all book titles in the list.
     */
    public void listAllBookTitles() {
        if (bookTitles.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("Book Titles:");
            for (String title : bookTitles) {
                System.out.println(title);
            }
        }
    }

    /**
     * Sorts the book titles alphabetically.
     */
    public void sortBookTitles() {
        Collections.sort(bookTitles);
    }

    /**
     * Main method to demonstrate the functionality of the LibraryUtility class.
     */
    public static void main(String[] args) {
        LibraryUtility library = new LibraryUtility();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nLibrary Utility Menu:");
            System.out.println("1. Add Book Title");
            System.out.println("2. Remove Book Title");
            System.out.println("3. Search for Book Title");
            System.out.println("4. List All Book Titles");
            System.out.println("5. Sort Book Titles");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the book title to add: ");
                    String addTitle = scanner.nextLine();
                    try {
                        library.addBookTitle(addTitle);
                        System.out.println("'" + addTitle + "' has been added.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter the book title to remove: ");
                    String removeTitle = scanner.nextLine();
                    try {
                        library.removeBookTitle(removeTitle);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Enter the book title to search for: ");
                    String searchTitle = scanner.nextLine();
                    try {
                        int index = library.searchBookTitle(searchTitle);
                        if (index != -1) {
                            System.out.println("'" + searchTitle + "' found at index " + index + ".");
                        } else {
                            System.out.println("'" + searchTitle + "' not found.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    library.listAllBookTitles();
                    break;
                case 5:
                    library.sortBookTitles();
                    System.out.println("Book titles have been sorted.");
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }
        }

        scanner.close();
    }
}
