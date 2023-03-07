package mvc.controller;

import java.util.Collection;

public class BCMessage {
    private Object sender;
    private Collection<Book> books;

    public BCMessage(Object sender, Collection<Book> books) {
        this.sender = sender;
        this.books = books;
    }

    public Object getSender() {
        return sender;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    
}
