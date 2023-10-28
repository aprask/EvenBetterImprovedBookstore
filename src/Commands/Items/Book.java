/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands.Items;

/**
 *
 * @author skalg
 */

public class Book {
    private final String itemName;
    private double itemPrice;
    private int pages;
    private int bookID;
    private boolean status;

    /**
     *
     * @param itemName the item's name
     * @param status whether it has been sold
     */
    public Book(String itemName, boolean status)
    {
        this.itemName = itemName;
        this.status = status;
    }

    /**
     *
     * @param itemName the item's name
     * @param itemPrice the item's price
     * @param pages amount of pages
     * @param bookID the ID for the item (ex: 0)
     * @param status whether it has been sold
     */
    public Book(String itemName, double itemPrice, int pages, int bookID, boolean status) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.pages = pages;
        this.bookID = bookID;
        this.status = status;
    }

    /**
     *
     * @return the item's name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     *
     * @return the item's price
     */
    public double getItemPrice() {
        return itemPrice;
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
        return "Name: " + getItemName() + "\nPrice: " + getItemPrice() + "\nPage Count: " + getPages();
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
}

