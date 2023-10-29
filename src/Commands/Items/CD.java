/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands.Items;

/**
 *
 * @author skalg
 */
public class CD extends Item {
    private String itemName;
    private double itemPrice;
    private double cdLength;
    private int cdID;
    private boolean status;

    /**
     *
     * @param itemName the item's name
     * @param status the item's status
     */
    public CD(String itemName, boolean status)
    {
        super(itemName);
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

    /**
     *
     * @return return the cd's ID
     */
    public int getCdID() {
        return cdID;
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
}
