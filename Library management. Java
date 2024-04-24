import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
//Defining book
class Book {
    String title;
    String author;
    boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }
}
//Defining user for registration
class User {
    String username;
    List<Book> borrowedBooks;

    public User(String username) {
        this.username = username;
        this.borrowedBooks = new ArrayList<>();
    }
}
//Whole library management system from adding user,taking books,borrowing and returning
public class LibraryManagementSystem1 {
    private Map<String, Book> books;
    private Map<String, User> users;

    public LibraryManagementSystem1() {
        this.books = new HashMap<>();
        this.users = new HashMap<>();
    }
    //Adding book to library
    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        books.put(title, book);
        System.out.println("Book added successfully: " + title);
    }
    //Registering user to library
    public void registerUser(String username) {
        User user = new User(username);
        users.put(username, user);
        System.out.println("User registered successfully: " + username);
    }
    //Borrowing selected book from library
    public void borrowBook(String username, String title) {
        User user = users.get(username);
        Book book = books.get(title);

        if (user != null && book != null && book.available) {
            user.borrowedBooks.add(book);
            book.available = false;
            System.out.println("Book borrowed successfully: " + title);
        } else {
            System.out.println("Book not available for borrowing.");
        }
    }
    //Returning book after reading 
    public void returnBook(String username, String title) {
        User user = users.get(username);
        Book book = books.get(title);

        if (user != null && book != null && !book.available && user.borrowedBooks.contains(book)) {
            user.borrowedBooks.remove(book);
            book.available = true;
            System.out.println("Book returned successfully: " + title);
        } else {
            System.out.println("Invalid return request.");
        }
    }
    //Displaying available books
    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            if (entry.getValue().available) {
                System.out.println(entry.getKey() + " by " + entry.getValue().author);
            }
        }
    }
    //Main function
    public static void main(String[] args) {
        LibraryManagementSystem1 library = new LibraryManagementSystem1();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Register User");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Available Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
      	    //Switch case for options according to our choice
            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    library.registerUser(username);
                    break;

                case 3:
                    System.out.print("Enter username: ");
                    String borrower = scanner.nextLine();
                    System.out.print("Enter book title to borrow: ");
                    String bookToBorrow = scanner.nextLine();
                    library.borrowBook(borrower, bookToBorrow);
                    break;

                case 4:
                    System.out.print("Enter username: ");
                    String returner = scanner.nextLine();
                    System.out.print("Enter book title to return: ");
                    String bookToReturn = scanner.nextLine();
                    library.returnBook(returner, bookToReturn);
                    break;

                case 5:
                    library.displayAvailableBooks();
                    break;

                case 6:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
