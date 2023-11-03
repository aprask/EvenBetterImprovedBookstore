package Commands.Items;

import java.util.Objects;

public abstract class Item implements Comparable {
    private String name;
    private double price;
    private int ID;
    private boolean status;
    private final Inventory inventory = new Inventory();
    public Item()
    {

    }

    /**
     *
     * @param itemName retrieve item name
     */
    public Item(String itemName) {
        this.name = itemName;
        this.status = false;
    }

    /**
     *
     * @param itemName retrieve item name
     * @param itemPrice retrieve item price
     */
    public Item(String itemName, double itemPrice)
    {
        this.name = itemName;
        this.price = itemPrice;
        this.status = false;
    }

    /**
     *
     * @param itemName retrieve item name
     * @param itemPrice retrieve item price
     * @param id retrive item id
     */
    public Item(String itemName, double itemPrice, int id) {
        this.name = itemName;
        this.price = itemPrice;
        this.ID = id;
        this.status = false;
    }

    /**
     *
     * @return item name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return item price
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @return item ID
     */
    public int getID() {
        return ID;
    }

    /**
     *
     * @param item retrieve an Item object to compare via price
     * @return boolean whether compared (inner) item is larger (false) or smaller (true)
     */
    @Override
    public boolean compareTo(Item item) {
        return (this.price > item.getPrice());
    }

    /**
     *
     * @return return item name and price
     */
    @Override
    public String toString() {
        return "Item Name: " + getName() + "\nItem Price: " + getPrice();
    }

    /**
     *
     * @return description of item (polymorphic message)
     */
    public String useItem()
    {
        String message = "You can now use: ";
        return message + this.name;
    }

    /**
     *
     * @return status is true when sold
     */
    public boolean isStatus() {
        return status;
    }

    /**
     *
     * @param status sold item = true
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     *
     * @param obj given an object we compare to see if it is equal
     * @return boolean whether the object is equal to the compare object
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
