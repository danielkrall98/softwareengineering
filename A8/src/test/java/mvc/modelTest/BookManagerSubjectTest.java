package mvc.modelTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mvc.controller.BCMessage;
import mvc.controller.BookManagerObserver;
import mvc.model.BookManagerSubject;

class BookManagerSubjectTest {
    private BookManagerSubject bookManagerSubject;
    private BookManagerObserver observer1;
    private BookManagerObserver observer2;

    @BeforeEach
    void setUp() {
        bookManagerSubject = new BookManagerSubject() {};
        observer1 = new BookManagerObserver() {
            @Override
            public void update(BCMessage message) {}
        };
        
        observer2 = new BookManagerObserver() {
            @Override
            public void update(BCMessage message) {}
        };
    }

    @Test
    void testAddObserver() {
        assertEquals(0, bookManagerSubject.getObservers().size());
        bookManagerSubject.addObserver(observer1);
        assertEquals(1, bookManagerSubject.getObservers().size());
        bookManagerSubject.addObserver(observer2);
        assertEquals(2, bookManagerSubject.getObservers().size());
    }

    @Test
    void testRemoveObserver() {
        bookManagerSubject.addObserver(observer1);
        bookManagerSubject.addObserver(observer2);
        assertEquals(2, bookManagerSubject.getObservers().size());
        bookManagerSubject.removeObserver(observer1);
        assertEquals(1, bookManagerSubject.getObservers().size());
        bookManagerSubject.removeObserver(observer2);
        assertEquals(0, bookManagerSubject.getObservers().size());
    }

    @Test
    void testNotifyObservers() {
        final boolean[] updated = {false};
        BookManagerObserver observer = new BookManagerObserver() {
            @Override
            public void update(BCMessage message) {
                updated[0] = true;
            }
        };
        bookManagerSubject.addObserver(observer);
        assertFalse(updated[0]);
        bookManagerSubject.notifyObservers(new BCMessage(null, null));
        assertTrue(updated[0]);
    }

    @Test
    void testGetObservers() {
        bookManagerSubject.addObserver(observer1);
        bookManagerSubject.addObserver(observer2);
        Collection<BookManagerObserver> observers = bookManagerSubject.getObservers();
        assertEquals(2, observers.size());
        assertTrue(observers.contains(observer1));
        assertTrue(observers.contains(observer2));
    }
}
