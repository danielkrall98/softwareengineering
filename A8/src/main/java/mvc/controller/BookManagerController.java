package mvc.controller;

import java.util.Collection;

import mvc.Main;
import mvc.model.BookManager;

/**
 * The controller for the BookManager
 * It will mostly be used to call methods on the BookManager directly
 */
public class BookManagerController {
    BookManager bookManager;

    public BookManagerController(String pathToModel) {
        //would load the model from the path in a real application

        //take the model from the main class
        this.bookManager = Main.bookManager;
    }

    public BookManagerController(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    public boolean addBook(String title, String author, String year, String isbn) {
        return bookManager.addBook(new Book(title, author, year, isbn));
    }

    public boolean removeBook(String isbn) {
        return bookManager.removeBook(isbn);
    }

    public boolean editBook(String isbn_to_edit, String title, String author, String year, String isbn) {
        return bookManager.editBook(isbn_to_edit, new Book(title, author, year, isbn));
    }

    public Collection<Book> getBooks() {
        return bookManager.getBooks();
    }

    public void addObserver(BookManagerObserver observer) {
        bookManager.addObserver(observer);
    }

        /**
     * Check if the input from the dialog is valid
     * @param title 
     * @param author
     * @param year
     * @param isbn
     * @return 0 if the input is valid, -1 if one of the fields is empty, -2 if the year is not a number
     */
    public int checkDialogInput(String title, String author, String year, String isbn) {
    // Check if the input is valid
        if (title.isEmpty() || author.isEmpty() || year.isEmpty() || isbn.isEmpty()) {
            return -1;
        }

        // Check if the year is a number
        try {
            Integer.parseInt(year);
        } catch (NumberFormatException e) {
        return -2;
        }

        return 0;
    }
}
