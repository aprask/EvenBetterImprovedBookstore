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
public class CD extends Item {
    private double cdLength;
    private boolean status;

    /**
     *
     * @param itemName the item's name
     */
    public CD(String itemName)
    {
        super(itemName);
        this.status = false;
    }
    public CD(String itemName, double itemPrice)
    {
        super(itemName, itemPrice);
        this.status = false;
    }

    /**
     *
     * @param itemName the item's name
     * @param itemPrice the item's price
     * @param cdLength the cd's length
     * @param cdID the ID for the item (ex: 0)
     */
    public CD(String itemName, double itemPrice, double cdLength, int cdID) {
        super(itemName,itemPrice,cdID);
        this.cdLength = cdLength;
        this.status = false;
    }

    /**
     *
     * @return return the cd's length
     */
    public double getCdLength() {
        return cdLength;
    }

    /**
     *
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
     *
     * @return return the item's status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     *
     * @param status set the status of the item
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
    @Override
    public boolean compareTo(Item item)
    {
        return super.compareTo(item);
    }

    public String useItem()
    {
        String message = "You can now listen to: ";
        return message + this.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CD cd = (CD) o;
        return Double.compare(cd.cdLength, cdLength) == 0 && status == cd.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cdLength, status);
    }
}
