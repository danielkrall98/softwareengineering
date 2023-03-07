package composite;

/**
 * Represents a book with name, price and isbn
 **/
public class Book extends Item {
    private int isbn;

    public Book(String name, double price, int isbn) {
        setName(name);
        setPrice(price);
        setISBN(isbn);
    }

    @Override
    public double getPrice() { return price; }

    @Override
    public boolean setPrice(double price){ 
        if(price <= 0)
            return false;

        this.price = price; 
        return true;
    }

    /**
     * Sets isbn number
     * @param isbn number
     */
    public void setISBN( int isbn ) { this.isbn = isbn; }

    /**
     * @return isbn number
     */
    public int getISBN() { return this.isbn; }
}
