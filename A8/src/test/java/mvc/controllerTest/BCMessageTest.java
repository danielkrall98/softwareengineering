package mvc.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mvc.controller.BCMessage;
import mvc.controller.Book;

class BCMessageTest {
    private ArrayList<Book> books;
    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() throws Exception {
        books = new ArrayList<Book>();
        book1 = new Book("Title1", "Author1", "Year1", "ISBN1");
        book2 = new Book("Title2", "Author2", "Year2", "ISBN2");
        
        books.add(book1);
        books.add(book2);
    }

    @Test
    void testConstructorAndGetter() {
        BCMessage message = new BCMessage(this, books);
        assertSame(this, message.getSender());
        assertSame(books, message.getBooks());

        assertEquals(2, message.getBooks().size());
        assertTrue(message.getBooks().contains(book1));
        assertTrue(message.getBooks().contains(book2));
    }
}
