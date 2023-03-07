package mvc.controllerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mvc.controller.Book;

class BookTest {
    private Book book;

    @Test
    void testConstructor() {
        book = new Book("Title", "Author", "Year", "ISBN");
        assertEquals("Title", book.getTitle());
        assertEquals("Author", book.getAuthor());
        assertEquals("Year", book.getYear());
        assertEquals("ISBN", book.getIsbn());
    }

    @Test
    void testSetters() {
        book = new Book("", "", "", "");
        book.setTitle("Title");
        book.setAuthor("Author");
        book.setYear("Year");
        book.setIsbn("ISBN");
        assertEquals("Title", book.getTitle());
        assertEquals("Author", book.getAuthor());
        assertEquals("Year", book.getYear());
        assertEquals("ISBN", book.getIsbn());
    }

    @Test
    void testToString() {
        book = new Book("Title", "Author", "Year", "ISBN");
        assertEquals("Book [title=Title, author=Author, year=Year, isbn=ISBN]", book.toString());
    }
}