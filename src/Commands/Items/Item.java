package Commands.Items;

import java.util.ArrayList;

public abstract class Item implements Comparable {
    private String name;
    private double price;
    private int ID;
    private final Inventory inventory = new Inventory();
    public Item()
    {

    }

    public Item(String itemName) {
        this.name = itemName;
    }
    public Item(String itemName, double itemPrice)
    {
        this.name = itemName;
        this.price = itemPrice;
    }

    public Item(String itemName, double itemPrice, int id) {
        this.name = itemName;
        this.price = itemPrice;
        this.ID = id;
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
    public String comparePrices(double price1, double price2) {
        if(price1 > price2) return "The first item is more expensive than the second item";
        else if(price1 < price2) return "The second item is more expensive than the first item";
        else return "They are the same price";
    }

    @Override
    public String toString() {
        return "Item Name: " + getName() + "\nItem Price: " + getPrice();
    }
}
