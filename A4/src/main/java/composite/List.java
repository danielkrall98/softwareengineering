package composite;

import java.util.ArrayList;

/** Represents list that contains cds and books*/
public class List extends Item {
    private ArrayList<Item> items;

    public List(String name) {  
        setName(name);
        items = new ArrayList<>();    
    }

    /** @return the sum of all prices in this list. */
    public double getPrice() {
        int sum = 0;

        for (Item i : items) { sum += i.getPrice(); }
        return sum;
    }

    @Override
    public boolean setPrice(double price){ return false; }

    /** @return items in this list*/
    @Override
    public ArrayList<Item> getItems() { return this.items; }

    /** Adds an item to items list */
    public void addItems(Item item) { items.add(item); }

    // @Override
    // public Item findItem(String name){
    //     Item item = null;

    //     for(Item i : getItems()){
    //         item = i.findItem(name);

    //         if(item != null)
    //             return item;
    //     }

    //     return item;
    // }
}