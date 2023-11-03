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
    public Item(String itemName) {
        this.name = itemName;
        this.status = false;
    }
    public Item(String itemName, double itemPrice)
    {
        this.name = itemName;
        this.price = itemPrice;
        this.status = false;
    }

    public Item(String itemName, double itemPrice, int id) {
        this.name = itemName;
        this.price = itemPrice;
        this.ID = id;
        this.status = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    @Override
    public boolean compareTo(Item item) {
        return (this.price > item.getPrice());
    }
    @Override
    public String toString() {
        return "Item Name: " + getName() + "\nItem Price: " + getPrice();
    }
    public String useItem()
    {
        String message = "You can now use: ";
        return message + this.name;
    }
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
