/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands.Items;

/**
 *
 * @author skalg
 */

public class Book extends Item {
    private String itemName;
    private double itemPrice;
    private int pages;
    private int bookID;
    private boolean status;
    public Book(String itemName)
    {
        super(itemName);
        this.status = false;
    }
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
     * @return return the book's ID
     */
    public int getBookID() {
        return bookID;
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
    @Override
    public boolean compareTo(Item item) {
        return super.compareTo(item);
    }
}

