package mvc.model;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import mvc.controller.BCMessage;
import mvc.controller.Book;

public class BookManager extends BookManagerSubject{
    Map<String, Book> books = new LinkedHashMap<String, Book>();

    /**
     * Adds a book to the list of books. If the book already exists, it will not be added.
     * @param book The book to add
     * @return true if the book was added, false if the book already exists
     */
    public boolean addBook(Book book) {
        if (books.containsKey(book.getIsbn())) {
            return false;
        }
        books.put(book.getIsbn(), book);
        notifyObservers(new BCMessage(this, getBooks()));
        return true;
    }

    /**
     * Removes a book from the list of books. If the book does not exist, nothing will happen.
     * @param book The book to remove
     * @return true if the book was removed, false if the book does not exist
     */
    public boolean removeBook(Book book) {
        if (!books.containsKey(book.getIsbn())) {
            return false;
        }
        books.remove(book.getIsbn());

        notifyObservers(new BCMessage(this, getBooks()));
        return true;
    }

    /**
     * Removes a book from the list of books. If the book does not exist, nothing will happen.
     * @param isbn_to_remove The isbn of the book to remove
     * @return true if the book was removed, false if the book does not exist
     */
    public boolean removeBook(String isbn_to_remove) {
        return this.removeBook(new Book("", "", "", isbn_to_remove));
    }

    /**
     * Edits a book in the list of books. If the book does not exist, nothing will happen.
     * @param book The book to edit
     * @return true if the book was edited, false if the book does not exist
     */
    public boolean editBook(String isbn_to_edit, Book book) {
        if (!books.containsKey(isbn_to_edit)) {
            return false;
        }
        this.removeBook(isbn_to_edit);
        books.put(book.getIsbn(), book);

        notifyObservers(new BCMessage(this, getBooks()));
        return true;
    }

    /**
     * Gets collection of books
     * @return collection of books
     */
    public Collection<Book> getBooks() {
        return books.values();
    }
}
