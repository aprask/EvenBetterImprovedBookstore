package Commands.Items;

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
    public boolean compareTo(Item item) { // TODO NullPointerException
        return !(this.price > item.getPrice());
    }

    @Override
    public String toString() {
        return "Item Name: " + getName() + "\nItem Price: " + getPrice();
    }
}
