package Commands.Items;
/**
 *
 * @author skalg
 */
public class CD extends Item {
    private double cdLength;
    private boolean status;

    /**
     * @param itemName the item's name
     */
    public CD(String itemName) {
        super(itemName);
        this.status = false;
    }

    /**
     * @param itemName  receive an item's name
     * @param itemPrice receive an item's price
     */
    public CD(String itemName, double itemPrice) {
        super(itemName, itemPrice);
        this.status = false;
    }

    /**
     * @param itemName  the item's name
     * @param itemPrice the item's price
     * @param cdLength  the cd's length
     * @param cdID      the ID for the item (ex: 0)
     */
    public CD(String itemName, double itemPrice, double cdLength, int cdID) {
        super(itemName, itemPrice, cdID);
        this.cdLength = cdLength;
        this.status = false;
    }

    /**
     * @return return the cd's length
     */
    public double getCdLength() {
        return cdLength;
    }

    /**
     * @return the details of the item
     */
    @Override
    public String toString() {
        return super.toString() + "Length: " + getCdLength();
    }

    @Override
    public int getID() {
        return super.getID();
    }

    /**
     * @return return the item's status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status set the status of the item
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return return a polymorphic message
     */
    @Override
    public String useItem() {
        String message = "You can now listen to: ";
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