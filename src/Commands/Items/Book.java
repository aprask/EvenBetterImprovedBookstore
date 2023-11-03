package Commands.Items;

import java.util.Objects;

/**
 *
 * @author skalg
 */

public class Book extends Item {
    private int pages;
    private boolean status;

    /**
     *
     * @param itemName receive a book name
     */
    public Book(String itemName)
    {
        super(itemName);
        this.status = false;
    }

    /**
     *
     * @param itemName receive a book name
     * @param itemPrice receive a book price
     */
    public Book(String itemName, double itemPrice)
    {
        super(itemName, itemPrice);
        this.status = false;
    }
    /**
     *
     * @param itemName the item's name
     * @param itemPrice the item's price
     * @param pages amount of pages
     * @param bookID the ID for the item (ex: 0)
     */
    public Book(String itemName, double itemPrice, int pages, int bookID) {
        super(itemName,itemPrice,bookID);
        this.pages = pages;
        this.status = false;
    }

    /**
     *
     * @return the item's page count
     */
    public int getPages() {
        return pages;
    }

    /**
     *
     * @return the details of the item
     */
    @Override
    public String toString() {
        return super.toString() + "Pages: " + getPages();
    }

    /**
     *
     * @return the ID
     */
    @Override
    public int getID() {
        return super.getID();
    }
    /**
     *
     * @return return the book's status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     *
     * @param status set the book's status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     *
     * @param item Item object
     * @return boolean, is the compared object more expensive
     */
    @Override
    public boolean compareTo(Item item) {
        return super.compareTo(item);
    }

    /**
     *
     * @return return a polymorphic message
     */
    @Override
    public String useItem()
    {
        String message = "You can now read: ";
        return message + getName();
    }


    /**
     *
     * @param o recieve an object
     * @return whether the object is equal to the compared object
     */
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}

