package mvc.model;

import java.util.ArrayList;
import java.util.Collection;

import mvc.controller.BCMessage;
import mvc.controller.BookManagerObserver;

public abstract class BookManagerSubject {
    Collection<BookManagerObserver> observers = new ArrayList<BookManagerObserver>();

    /**
     * Adds an observer to the list of observers
     * @param observer The observer to add
     */
    public void addObserver(BookManagerObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer from the list of observers
     * @param observer The observer to remove
     */
    public void removeObserver(BookManagerObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all observers that the state of the bookManager has changed
     * @param message The message containing the new state of the bookManager
     */
    public void notifyObservers(BCMessage message) {
        for (BookManagerObserver observer : observers) {
            observer.update(message);
        }
    }

    public Collection<BookManagerObserver> getObservers() {
        return observers;
    }
}
