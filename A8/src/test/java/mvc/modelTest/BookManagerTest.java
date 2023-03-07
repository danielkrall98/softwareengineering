// add your test code here
// you may change the name of this file and also add other test classes in this folder
package mvc.modelTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import mvc.controller.Book;
import mvc.model.BookManager;

class BookManagerTest {
    private BookManager bookManager;
    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() {
        bookManager = new BookManager();
        book1 = new Book("Title1", "Author1", "Year1", "1111");
        book2 = new Book("Title2", "Author2", "Year2", "2222");
    }

    @Test
    void testAddBook() {
        assertTrue(bookManager.addBook(book1));
        assertEquals(1, bookManager.getBooks().size());
        assertTrue(bookManager.addBook(book2));
        assertEquals(2, bookManager.getBooks().size());
        assertFalse(bookManager.addBook(book1));
        assertEquals(2, bookManager.getBooks().size());
    }

    @Test
    void testRemoveBook() {
        assertFalse(bookManager.removeBook(book1));
        bookManager.addBook(book1);
        assertTrue(bookManager.removeBook(book1));
        assertEquals(0, bookManager.getBooks().size());
        bookManager.addBook(book1);
        bookManager.addBook(book2);
        assertTrue(bookManager.removeBook("1111"));
        assertEquals(1, bookManager.getBooks().size());
    }

    @Test
    void testEditBook() {
        assertFalse(bookManager.editBook("1111", book1));
        bookManager.addBook(book1);
        Book editedBook = new Book("EditedTitle", "EditedAuthor", "EditedYear", "1111");
        assertTrue(bookManager.editBook("1111", editedBook));
        assertEquals("EditedTitle", bookManager.getBooks().stream().filter(b -> b.getIsbn().equals("1111")).findFirst().get().getTitle());
        assertEquals("EditedAuthor", bookManager.getBooks().stream().filter(b -> b.getIsbn().equals("1111")).findFirst().get().getAuthor());
        assertEquals("EditedYear", bookManager.getBooks().stream().filter(b -> b.getIsbn().equals("1111")).findFirst().get().getYear());
    }

    @Test
    void testGetBooks() {
        assertEquals(0, bookManager.getBooks().size());
        bookManager.addBook(book1);
        assertEquals(1, bookManager.getBooks().size());
        bookManager.addBook(book2);
        assertEquals(2, bookManager.getBooks().size());
    }
}
