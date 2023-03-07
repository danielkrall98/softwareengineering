package composite;

import java.util.ArrayList;

/** Abstract Parent object*/
public abstract class Item {
    protected String name;
    protected double price;

    
    /** Return children if there can exist any */
    public ArrayList<Item> getItems() { return new ArrayList<Item>(); }
    
    // /** Return children if there can exist any */
    // public Item findItem(String name) { return this.name.equals(name) ? this : null; }       //implementation with out empty list
    
    /** Sets name of item */
    public void setName(String name){ this.name = name; }

    /** @return the name of item*/
    public String getName(){ return name; }

    /**
     * Set the price of a item
     * @param price
     * @return true if price was set succesfully, false otherwise
     */
    abstract public boolean setPrice(double price);

    /** @return the price of this item */
    abstract public double getPrice();

    
}