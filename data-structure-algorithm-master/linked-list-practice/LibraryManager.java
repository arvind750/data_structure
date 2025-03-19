class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class LibraryManagement {
    private Book head;
    private Book tail;
    private int bookCount = 0;

    public void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        bookCount++;
    }

    public void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        bookCount++;
    }

    public void addAtPosition(String title, String author, String genre, int bookId, boolean isAvailable, int position) {
        if (position <= 1) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        Book temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(title, author, genre, bookId, isAvailable);
        } else {
            newBook.next = temp.next;
            newBook.prev = temp;
            temp.next.prev = newBook;
            temp.next = newBook;
            bookCount++;
        }
    }

    public void removeBook(int bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        Book temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book not found.");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        bookCount--;
        System.out.println("Book with ID " + bookId + " removed.");
    }

    public void searchByTitle(String title) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println("Found: " + temp.title + " by " + temp.author + " | Genre: " + temp.genre + " | Available: " + temp.isAvailable);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No book found with title: " + title);
    }

    public void searchByAuthor(String author) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println("Found: " + temp.title + " by " + temp.author + " | Genre: " + temp.genre + " | Available: " + temp.isAvailable);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No books found by author: " + author);
    }

    public void updateAvailability(int bookId, boolean newAvailability) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = newAvailability;
                System.out.println("Availability updated for Book ID: " + bookId);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("No books in library.");
            return;
        }
        System.out.println("\nBooks (Forward Order):");
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.author + " | " + temp.genre + " | ID: " + temp.bookId + " | Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        if (tail == null) {
            System.out.println("No books in library.");
            return;
        }
        System.out.println("\nBooks (Reverse Order):");
        Book temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.author + " | " + temp.genre + " | ID: " + temp.bookId + " | Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    public void countBooks() {
        System.out.println("Total number of books in library: " + bookCount);
    }
}

public class LibraryManager {
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();

        library.addAtEnd("1984", "George Orwell", "Dystopian", 101, true);
        library.addAtBeginning("To Kill a Mockingbird", "Harper Lee", "Classic", 102, false);
        library.addAtEnd("The Great Gatsby", "F. Scott Fitzgerald", "Classic", 103, true);
        library.addAtPosition("Moby Dick", "Herman Melville", "Adventure", 104, true, 2);

        library.displayForward();
        library.displayReverse();

        System.out.println("\nSearching for books:");
        library.searchByTitle("1984");
        library.searchByAuthor("Harper Lee");

        System.out.println("\nUpdating book availability:");
        library.updateAvailability(102, true);

        System.out.println("\nRemoving a book:");
        library.removeBook(104);

        library.displayForward();
        library.countBooks();
    }
}
