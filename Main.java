import java.util.Scanner;

public class Main {
    private static BookManager manager = new BookManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("[1] Add book");
            System.out.println("[2] Remove book");
            System.out.println("[3] Update book");
            System.out.println("[4] List books");
            System.out.println("[5] Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    listBooks();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
        scanner.close();
    }

    private static void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        Book book = new Book(title, author, isbn, year);
        manager.addBook(book);
        System.out.println("Book added successfully!");
    }

    private static void removeBook() {
        System.out.print("Enter ISBN to remove: ");
        String isbn = scanner.nextLine();
        manager.removeBook(isbn);
        System.out.println("Book removed successfully!");
    }

    private static void updateBook() {
        System.out.print("Enter ISBN of book to update: ");
        String isbn = scanner.nextLine();

        System.out.print("Enter new title: ");
        String title = scanner.nextLine();
        System.out.print("Enter new author: ");
        String author = scanner.nextLine();
        System.out.print("Enter new ISBN: ");
        String newIsbn = scanner.nextLine();
        System.out.print("Enter new year: ");
        int year = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        Book updatedBook = new Book(title, author, newIsbn, year);
        Book book = manager.updateBook(isbn, updatedBook);
        if (book != null) {
            System.out.println("Book updated successfully!");
        } else {
            System.out.println("Failed to update book. No book found with ISBN " + isbn);
        }
    }

    private static void listBooks() {
        System.out.println("Listing all books:");
        for (Book book : manager.getBooks()) {
            System.out.println(book);
        }
    }
}
