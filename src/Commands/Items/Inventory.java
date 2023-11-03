package Commands.Items;
import java.util.*;
/**
 *
 * @author skalg
 */
    public class Inventory implements BookStoreSpecification
{
    public ArrayList<Item> inStockItems = new ArrayList<>();
    protected static int selectionID;
    private final Scanner scan = new Scanner(System.in);
    public Inventory() {

    }
    public void initializeItems() {
            inStockItems.addAll(Arrays.asList(
                    new Book("Narnia", 15.99, 300, 0),
                    new Book("The Lord of the Rings", 5.00, 1000, 1),
                    new Book("Animal Farm", 5.00, 250, 2),
                    new Book("The Iliad", 40.25, 8000, 3),
                    new Book("1984", 10.50, 95, 4)));
            inStockItems.addAll(Arrays.asList(
                    new CD("Thriller", 8.95, 250, 5),
                    new CD("Hotel California", 6.95, 100, 6),
                    new CD("Back in Black", 5.50, 150, 7),
                    new CD("The Planets", 150.75, 5000, 8),
                    new CD("Ride of the Valkyries", 250.25, 250, 9)));
            inStockItems.addAll(Arrays.asList(
                    new DVD("Star Wars", 9.15, 600, 10),
                    new DVD("The Terminator", 10.55, 550, 11),
                    new DVD("Star Trek", 10.75, 1000, 12),
                    new DVD("The Godfather", 25.25, 1025, 13),
                    new DVD("The Sopranos", 12.55, 1202, 14)));
            System.out.println("Total Cost of Inventory: $" + this.inventoryValue());
    }
    public void availableItems()
    {
        for (Item inStockItem : inStockItems) {
            if (inStockItem.getClass().equals(CD.class)) {
                System.out.println("\nCD: ");
                System.out.println("Name: " + inStockItem.getName());
                System.out.println("Price: $" + inStockItem.getPrice());
                System.out.println("ID: " + inStockItem.getID());
            } else if (inStockItem.getClass().equals(Book.class)) {
                System.out.println("\nBook: ");
                System.out.println("Name: " + inStockItem.getName());
                System.out.println("Price: $" + inStockItem.getPrice());
                System.out.println("ID: " + inStockItem.getID());
            } else if (inStockItem.getClass().equals(DVD.class)) {
                System.out.println("\nDVD: ");
                System.out.println("Name: " + inStockItem.getName());
                System.out.println("Price: $" + inStockItem.getPrice());
                System.out.println("ID: " + inStockItem.getID());
            }
        }
    }
    public void availableItems(int itemType)
    {
        for (Item inStockItem : inStockItems) {
            if (itemType == 1 && inStockItem.getClass().equals(CD.class)) {
                System.out.println("\nCD: ");
                System.out.println("Name: " + inStockItem.getName());
                System.out.println("Price: $" + inStockItem.getPrice());
                System.out.println("ID: " + inStockItem.getID());
            } else if (itemType == 2 && inStockItem.getClass().equals(Book.class)) {
                System.out.println("\nBook: ");
                System.out.println("Name: " + inStockItem.getName());
                System.out.println("Price: $" + inStockItem.getPrice());
                System.out.println("ID: " + inStockItem.getID());
            } else if (itemType == 3 && inStockItem.getClass().equals(DVD.class)) {
                System.out.println("\nDVD: ");
                System.out.println("Name: " + inStockItem.getName());
                System.out.println("Price: $" + inStockItem.getPrice());
                System.out.println("ID: " + inStockItem.getID());
            }
        }
    }
    /**
     * @return return the ID selected
     */
    public int getSelectionID() {
        return selectionID;
    }

    /**
     * @param selectionID set the selection ID
     */
    public void setSelectionID(int selectionID) {
        Inventory.selectionID = selectionID;
    }

    @Override
    public void restockProduct(int itemType, int amount) {
        if (itemType == 1) {
            while(amount > 0)
            {
                System.out.println("Enter item name: ");
                String itemName = scan.next();
                System.out.println("Enter item price: ");
                double itemPrice = scan.nextDouble();
                System.out.println("Enter item ID: ");
                int itemID = scan.nextInt();
                System.out.println("Enter CD Length: ");
                double cdLength = scan.nextDouble();
                inStockItems.add(new CD(itemName,itemPrice,cdLength,itemID));
                amount--;
            }
        }
        else if (itemType == 2) {
            while(amount > 0)
            {
                System.out.println("Enter item name: ");
                String itemName = scan.next();
                System.out.println("Enter item price: ");
                double itemPrice = scan.nextDouble();
                System.out.println("Enter item ID: ");
                int itemID = scan.nextInt();
                System.out.println("Enter Page Count: ");
                int pages = scan.nextInt();
                inStockItems.add(new Book(itemName,itemPrice,pages,itemID));
                amount--;
            }
        } else if (itemType == 3) {
            while(amount > 0)
            {
                System.out.println("Enter item name: ");
                String itemName = scan.next();
                System.out.println("Enter item price: ");
                double itemPrice = scan.nextDouble();
                System.out.println("Enter item ID: ");
                int itemID = scan.nextInt();
                System.out.println("Enter CD Length");
                double dvdLength = scan.nextDouble();
                inStockItems.add(new DVD(itemName,itemPrice,dvdLength,itemID));
                amount--;
            }
        }
        System.out.println("Current Inventory:");
        availableItems();
    }

    public void handleRestock() {
        System.out.println("SOLD PRODUCTS: ");
        soldProduct();
        System.out.println("\nSelect product type to restock: ");
        System.out.println("1=CD\n2=Book\n3=DVD");
        int productType = scan.nextInt();
        System.out.println("How much of this product (quantity) would you like to add to the shelf? ");
        int quantityOfProduct = scan.nextInt();
        restockProduct(productType, quantityOfProduct);
    }

    public void soldProduct() {
        for (Item inStockItem : inStockItems) {
            if (inStockItem.getClass().equals(CD.class) && inStockItem.isStatus()) {
                System.out.println("\nCD: ");
                System.out.println("\tName: " + inStockItem.getName());
                System.out.println("\tID: " + inStockItem.getID());
            } else if (inStockItem.getClass().equals(Book.class) && inStockItem.isStatus()) {
                System.out.println("\nBook: ");
                System.out.println("\tName: " + inStockItem.getName());
                System.out.println("\tID: " + inStockItem.getID());
            } else if (inStockItem.getClass().equals(DVD.class) && inStockItem.isStatus()) {
                System.out.println("\nDVD: ");
                System.out.println("\tName: " + inStockItem.getName());
                System.out.println("\tID: " + inStockItem.getID());
            }
        }
    }
    public void compareItems()
    {
        System.out.println();
        for (Item stockItem : inStockItems) {
            System.out.println("------------------------------------------------------");
            System.out.println("Name: " + stockItem.getName());
            System.out.println("ID: " + stockItem.getID());
            System.out.println("------------------------------------------------------");
        }
        System.out.println("Select two items for comparison: ");
        System.out.println("Item 1's ID: ");
        int item1ID = scan.nextInt();
        System.out.println("Item 2's ID: ");
        int item2ID = scan.nextInt();
        calculateCompare(item1ID,item2ID);
    }

    public double totalCostOfBooks() {
        double total = 0;
        for (Item inStockItem : inStockItems) {
            if (inStockItem.getClass().equals(Book.class) && !inStockItem.isStatus()) {
                total += inStockItem.getPrice();
            }
        }
        return total;
    }

    public double totalCostOfCDs() {
        double total = 0;
        for (Item inStockItem : inStockItems) {
            if (inStockItem.getClass().equals(CD.class) && !inStockItem.isStatus()) {
                total += inStockItem.getPrice();
            }
        }
        return total;
    }
    public double totalCostOfDVDs() {
        double total = 0;
        for (Item inStockItem : inStockItems) {
            if (inStockItem.getClass().equals(DVD.class) && !inStockItem.isStatus()) {
                total += inStockItem.getPrice();
            }
        }
        return total;
    }
    @Override
    public double inventoryValue() {
        return totalCostOfBooks() + totalCostOfDVDs() + totalCostOfCDs();
    }

    public void sellCD(int ID) {
        for (Item inStockItem : inStockItems) {
            if (inStockItem.getClass().equals(CD.class) && inStockItem.isStatus()) {
                if (ID == inStockItem.getID()) {
                    inStockItem.setStatus(true); // item is sold, sold = true
                }
            }
        }
    }

    public void sellBook(int ID) {
        for (Item inStockItem : inStockItems) {
            if (inStockItem.getClass().equals(Book.class) && inStockItem.isStatus()) {
                if (ID == inStockItem.getID()) {
                    inStockItem.setStatus(true); // item is sold, sold = true
                }
            }
        }
    }
    public void sellDVD(int ID) {
        for (Item inStockItem : inStockItems) {
            if (inStockItem.getClass().equals(DVD.class) && inStockItem.isStatus()) {
                if (ID == inStockItem.getID()) {
                    inStockItem.setStatus(true); // item is sold, sold = true
                }
            }
        }
    }
    public void addCD(String itemName, double itemPrice, double cdLength, int cdID) {
        inStockItems.add(new CD(itemName, itemPrice, cdLength, cdID));
    }

    public void addBook(String itemName, double itemPrice, int pages, int bookID) {
        inStockItems.add(new Book(itemName, itemPrice, pages, bookID));
    }

    public void addDVD(String itemName, double itemPrice, double dvdLength, int cdID) {
        inStockItems.add(new DVD(itemName, itemPrice, dvdLength, cdID));
    }
    public double getDVDPrice(int itemID) {
        for (Item inStockItem : inStockItems) {
            if (inStockItem.getClass().equals(DVD.class) && inStockItem.getID() == itemID) {
                return inStockItems.get(itemID).getPrice();
            }
        }
        return -1;
    }
    public double getCDPrice(int itemID) {
        for (Item inStockItem : inStockItems) {
            if (inStockItem.getClass().equals(CD.class) && inStockItem.getID() == itemID) {
                return inStockItems.get(itemID).getPrice();
            }
        }
        return -1;
    }
    public double getBookPrice(int itemID) {
        for (Item inStockItem : inStockItems) {
            if (inStockItem.getClass().equals(Book.class) && inStockItem.getID() == itemID) {
                return inStockItems.get(itemID).getPrice();
            }
        }
        return -1;
    }
    public void calculateCompare(int item1ID, int item2ID)
    {
        for(int i = 0; i < inStockItems.size(); i++)
        {
            if(inStockItems.get(i).getID() == item1ID)
            {
                Item compareItem = inStockItems.get(i);
                for (Item inStockItem : inStockItems) {
                    if (inStockItem.getID() == item2ID)
                    {
                        if(compareItem.compareTo(inStockItem))
                        {
                            System.out.println(inStockItems.get(i).getName() + " is more expensive than " + inStockItem.getName());
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        else
                        {
                            if(compareItem.compareTo(inStockItem))
                            {
                                System.out.println(inStockItems.get(i).getName() + " is NOT more expensive than " + inStockItem.getName());
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public Item returnItem(int previousProductID, int previousProductType)
    {
        if(previousProductType == 1)
        {
            for (Item inStockItem : inStockItems)
            {
                if (inStockItem != null && inStockItem.getID() == previousProductID) {
                    return inStockItem;
                }
            }
        }
        return null;
    }

    public void useItems(List<Item> itemsToUse)
    {

    }

    public void displayItems(ArrayList<Integer> dvdIDHistory, ArrayList<Integer> cdIDHistory, ArrayList<Integer> bookIDHistory) {
        System.out.println("Items in the cart:");
        for (Item inStockItem : inStockItems) {
            int compareID = inStockItem.getID();
            for (Integer item : dvdIDHistory) {
                if (compareID == item) {
                    System.out.println("Name: " + inStockItems.get(compareID).getName());
                    System.out.println("Price: " + inStockItems.get(compareID).getPrice());
                    System.out.println(inStockItems.get(compareID).useItem());
                    System.out.println();
                    break;
                }
            }
            for (Integer value : cdIDHistory) {
                if (compareID == value) {
                    System.out.println("Name: " + inStockItems.get(compareID).getName());
                    System.out.println("Price: " + inStockItems.get(compareID).getPrice());
                    System.out.println(inStockItems.get(compareID).useItem());
                    System.out.println();
                    break;
                }
            }
            for (Integer integer : bookIDHistory) {
                if (compareID == integer) {
                    System.out.println("Name: " + inStockItems.get(compareID).getName());
                    System.out.println("Price: " + inStockItems.get(compareID).getPrice());
                    System.out.println(inStockItems.get(compareID).useItem());
                    System.out.println();
                    break;
                }
            }
        }
    }
}