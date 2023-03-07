package composite;

/** Represents a CD name and price*/
public class CD extends Item {
    public CD(String names, double price) {
        setName(names);
        setPrice(price);
    }

    /** {@inheritDoc} */
    @Override
    public double getPrice() { return this.price; }

    @Override
    public boolean setPrice(double price){ 
        if(price <= 0)
            return false;

        this.price = price; 
        return true;
    }
}
