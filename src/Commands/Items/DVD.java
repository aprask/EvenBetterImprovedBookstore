/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands.Items;

/**
 *
 * @author skalg
 */ 
public class DVD extends Item{
    private String itemName;
    private double itemPrice;
    private double dvdLength;
    private int dvdID;
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
     * @return return the item's name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     *
     * @return return the item's price
     */
    public double getItemPrice() {
        return itemPrice;
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
     * @return the details of the item
     */
    @Override
    public String toString() {
        return super.toString() + "Length: " + getDvdLength();
    }
    /**
     *
     * @return return the dvd's ID
     */
    public int getDvdID() {
        return dvdID;
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
}


