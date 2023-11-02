/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands.Items;

import java.util.Objects;

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
    @Override
    public boolean compareTo(Item item) {
        return super.compareTo(item);
    }

    @Override
    public void useItem() {
        System.out.println("You can now watch " + this.getName());
    }

/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DVD dvd = (DVD) o;
        return Double.compare(dvd.itemPrice, itemPrice) == 0 && Double.compare(dvd.dvdLength, dvdLength) == 0 && dvdID == dvd.dvdID && status == dvd.status && Objects.equals(itemName, dvd.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), itemName, itemPrice, dvdLength, dvdID, status);
    }
 */
}


