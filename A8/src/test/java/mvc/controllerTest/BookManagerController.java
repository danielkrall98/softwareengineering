package mvc.controllerTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mvc.controller.BCMessage;
import mvc.controller.Book;
import mvc.controller.BookManagerController;
import mvc.controller.BookManagerObserver;
import mvc.model.BookManager;

class BookManagerControllerTest {
    private BookManagerController controller;
    private BookManager bookManager;
    private Book book1;
    private Book book2;
    private BookManagerObserver observer;

    @BeforeEach
    void setUp() {
        bookManager = new BookManager() {
            @Override
            public void notifyObservers(BCMessage message) {
            }
        };
        controller = new BookManagerController(bookManager);
        book1 = new Book("Title1", "Author1", "Year1", "ISBN1");
        book2 = new Book("Title2", "Author2", "Year2", "ISBN2");
        observer = new BookManagerObserver() {
            @Override
            public void update(BCMessage message) {}
        };
    }

    @Test
    void testConstructor() {
        assertDoesNotThrow(() -> new BookManagerController(bookManager));
        assertDoesNotThrow(() -> new BookManagerController("bookManager"));
    }

    @Test
    void testAddBook() {
        assertTrue(controller.addBook("Title", "Author", "Year", "ISBN"));
        assertEquals(1, bookManager.getBooks().size());
        assertFalse(controller.addBook("Title", "Author", "Year", "ISBN"));
        assertEquals(1, bookManager.getBooks().size());
    }

    @Test
    void testRemoveBook() {
        assertFalse(controller.removeBook("ISBN"));
        bookManager.addBook(book1);
        assertTrue(controller.removeBook("ISBN1"));
        assertEquals(0, bookManager.getBooks().size());
    }

    @Test
    void testEditBook() {
        assertFalse(controller.editBook("ISBN", "Title", "Author", "Year", "ISBN"));
        bookManager.addBook(book1);
        assertTrue(controller.editBook("ISBN1", "Title", "Author", "Year", "ISBN"));
    }

    @Test
    void testGetBooks() {
        bookManager.addBook(book1);
        bookManager.addBook(book2);
        Collection<Book> books = controller.getBooks();
        assertEquals(2, books.size());
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book2));
    }

    @Test
    void testAddObserver() {
        controller.addObserver(observer);
        assertEquals(1, bookManager.getObservers().size());
        assertTrue(bookManager.getObservers().contains(observer));
    }
}

