package Commands.Items;

/**
 *
 * @author skalg
 */ 
public class DVD extends Item{
    private double dvdLength;
    private boolean status;

    /**
     *
     * @param itemName the item's name
     */
    public DVD(String itemName)
    {
        super(itemName);
        this.status = false;
    }

    /**
     *
     * @param itemName retrieve an item's name
     * @param itemPrice retrieve an item's price
     */
    public DVD(String itemName, double itemPrice)
    {
        super(itemName, itemPrice);
        this.status = false;
    }

    /**
     *
     * @param itemName the item's name
     * @param itemPrice the item's price
     * @param dvdLength the cd's length
     * @param dvdID the ID for the item (ex: 0)
     */
    public DVD(String itemName, double itemPrice, double dvdLength, int dvdID) {
        super(itemName,itemPrice,dvdID);
        this.dvdLength = dvdLength;
        this.status = false;
    }

    /**
     *
     * @return return the dvd's length
     */
    public double getDvdLength() {
        return dvdLength;
    }

    /**
     *
     * @return the item ID
     */
    @Override
    public int getID() {
        return super.getID();
    }

    /**
     *
     * @return the details of the item
     */
    @Override
    public String toString() {
        return super.toString() + "Length: " + getDvdLength();
    }

    /**
     *
     * @return return the item's status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     *
     * @param status the item's status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return return a polymorphic message
     */
    @Override
    public String useItem()
    {
        String message = "You can now watch: ";
        return message + getName();
    }
    /**
     * @param item Item object
     * @return boolean, is the compared object more expensive
     */
    @Override
    public boolean compareTo(Item item) {
        return super.compareTo(item);
    }
    /**
     * @param o receive an object
     * @return whether the object is equal to the compared object
     */
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}


