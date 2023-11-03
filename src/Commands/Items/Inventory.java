package Commands.Items;
import misc.Exit;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author skalg
 */
    public class Inventory implements BookStoreSpecification
{
    public ArrayList<Item> inStockItems = new ArrayList<>();
    public ArrayList<Item> soldItems = new ArrayList<>();
    protected static int selectionID;
    private final Scanner scan = new Scanner(System.in);
    public Inventory() {

    }
    public void initializeItems() {
        // create a default set of items (dynamic implementation will be implemented for project 3)
        // I plan on using the Factory design pattern in the next project
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
        System.out.print("Total Cost of Inventory: ");
        System.out.printf("$%.2f%n", inventoryValue());
        System.out.println();
    }
    public void availableItems()
    {
        for (Item inStockItem : inStockItems) {
            if (inStockItem.getClass().equals(CD.class) && !inStockItem.isStatus()) {
                System.out.println("\nCD: ");
                System.out.println("Name: " + inStockItem.getName());
                System.out.println("Price: $" + inStockItem.getPrice());
                System.out.println("ID: " + inStockItem.getID());
            } else if (inStockItem.getClass().equals(Book.class) && !inStockItem.isStatus()) {
                System.out.println("\nBook: ");
                System.out.println("Name: " + inStockItem.getName());
                System.out.println("Price: $" + inStockItem.getPrice());
                System.out.println("ID: " + inStockItem.getID());
            } else if (inStockItem.getClass().equals(DVD.class) && !inStockItem.isStatus()) {
                System.out.println("\nDVD: ");
                System.out.println("Name: " + inStockItem.getName());
                System.out.println("Price: $" + inStockItem.getPrice());
                System.out.println("ID: " + inStockItem.getID());
            }
        }
    }

    /**
     *
     * @param itemType receive an itemType (1=CD,2=Book,3=DVD)
     */
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

    /**
     *
     * @param itemType receive an itemType (1=CD,2=Book,3=DVD)
     * @param amount receive the quantity
     */
    public void restockProduct(int itemType, int amount) {
        if (itemType == 1) {
            while (amount > 0) {
                System.out.println("Enter item price: ");
                double itemPrice = Double.parseDouble(scan.next());
                scan.nextLine();
                System.out.println("Enter item ID: ");
                int itemID = Integer.parseInt(scan.next());
                scan.nextLine();
                System.out.println("Enter DVD Length");
                double cdLength = Double.parseDouble(scan.next());
                scan.nextLine();
                System.out.println("Enter item name: ");
                String itemName = scan.nextLine();
                inStockItems.add(new CD(itemName, itemPrice, cdLength, itemID));
                amount--;
            }
        } else if (itemType == 2) {
            while (amount > 0) {
                System.out.println("Enter item price: ");
                double itemPrice = Double.parseDouble(scan.next());
                scan.nextLine();
                System.out.println("Enter item ID: ");
                int itemID = Integer.parseInt(scan.next());
                scan.nextLine();
                System.out.println("Enter DVD Length");
                int pages = Integer.parseInt(scan.next());
                scan.nextLine();
                System.out.println("Enter item name: ");
                String itemName = scan.nextLine();
                inStockItems.add(new Book(itemName, itemPrice, pages, itemID));
                amount--;
            }
        } else if (itemType == 3) {
            while (amount > 0) {
                System.out.println("Enter item price: ");
                double itemPrice = Double.parseDouble(scan.next());
                scan.nextLine();
                System.out.println("Enter item ID: ");
                int itemID = Integer.parseInt(scan.next());
                scan.nextLine();
                System.out.println("Enter DVD Length");
                double dvdLength = Double.parseDouble(scan.next());
                scan.nextLine();
                System.out.println("Enter item name: ");
                String itemName = scan.nextLine();
                inStockItems.add(new DVD(itemName, itemPrice, dvdLength, itemID));
                amount--;
            }
        }
        System.out.println("Current Inventory:");
        availableItems();
    }
    public void handleRestock() throws IOException {
        System.out.println("SOLD PRODUCTS: ");
        soldProduct();
        System.out.println("\nSelect product type to restock: ");
        System.out.println("1=CD\n2=Book\n3=DVD");
        System.out.println("4=Exit");
        int productType = scan.nextInt();
        if(productType == 4)
        {
            Exit exit = new Exit();
            System.out.print("Total Cost of Inventory: ");
            System.out.printf("$%.2f%n", inventoryValue());
            System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logItemsSold();
            exit.thankYou();
            System.out.println("Goodbye");
            System.exit(0);
        }
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

    /**
     *
     * @return total cost of books (must not be out of stock)
     */
    public double totalCostOfBooks() {
        double total = 0;
        for (Item inStockItem : inStockItems) {
            if (inStockItem.getClass().equals(Book.class) && !inStockItem.isStatus()) {
                total += inStockItem.getPrice();
            }
        }
        return total;
    }
    /**
     *
     * @return total cost of cds (must not be out of stock)
     */
    public double totalCostOfCDs() {
        double total = 0;
        for (Item inStockItem : inStockItems) {
            if (inStockItem.getClass().equals(CD.class) && !inStockItem.isStatus()) {
                total += inStockItem.getPrice();
            }
        }
        return total;
    }
    /**
     *
     * @return total cost of dvds (must not be out of stock)
     */
    public double totalCostOfDVDs() {
        double total = 0;
        for (Item inStockItem : inStockItems) {
            if (inStockItem.getClass().equals(DVD.class) && !inStockItem.isStatus()) {
                total += inStockItem.getPrice();
            }
        }
        return total;
    }

    /**
     *
     * @return total cost of inventory
     */
    @Override
    public double inventoryValue() {
        return totalCostOfBooks() + totalCostOfDVDs() + totalCostOfCDs();
    }

    /**
     *
     * @param ID given ID sell item
     */
    public void sellCD(int ID) {
        for (Item inStockItem : inStockItems) {
            if (inStockItem.getClass().equals(CD.class) && !inStockItem.isStatus()) {
                if (ID == inStockItem.getID()) {
                    inStockItem.setStatus(true); // item is sold, sold = true
                    soldItems.add(inStockItem);
                }
            }
        }
    }
    /**
     *
     * @param ID given ID sell item
     */
    public void sellBook(int ID) {
        for (Item inStockItem : inStockItems) {
            if (inStockItem.getClass().equals(Book.class) && !inStockItem.isStatus()) {
                if (ID == inStockItem.getID()) {
                    inStockItem.setStatus(true);
                    soldItems.add(inStockItem);
                }
            }
        }
    }
    /**
     *
     * @param ID given ID sell item
     */
    public void sellDVD(int ID) {
        for (Item inStockItem : inStockItems) {
            if (inStockItem.getClass().equals(DVD.class) && !inStockItem.isStatus()) {
                if (ID == inStockItem.getID()) {
                    inStockItem.setStatus(true);
                    soldItems.add(inStockItem);
                }
            }
        }
    }

    /**
     *
     * @param itemID by ID find price
     * @return price
     */
    public double getDVDPrice(int itemID) {
        for (Item inStockItem : inStockItems) {
            if (inStockItem.getClass().equals(DVD.class) && inStockItem.getID() == itemID) {
                return inStockItems.get(itemID).getPrice();
            }
        }
        return -1;
    }
    /**
     *
     * @param itemID by ID find price
     * @return price
     */
    public double getCDPrice(int itemID) {
        for (Item inStockItem : inStockItems) {
            if (inStockItem.getClass().equals(CD.class) && inStockItem.getID() == itemID) {
                return inStockItems.get(itemID).getPrice();
            }
        }
        return -1;
    }
    /**
     *
     * @param itemID by ID find price
     * @return price
     */
    public double getBookPrice(int itemID) {
        for (Item inStockItem : inStockItems) {
            if (inStockItem.getClass().equals(Book.class) && inStockItem.getID() == itemID) {
                return inStockItems.get(itemID).getPrice();
            }
        }
        return -1;
    }

    /**
     *
     * @param item1ID given ID of item
     * @param item2ID given ID of item
     */
    public void calculateCompare(int item1ID, int item2ID)
    {
        // use one item as a compare item (item1)
        for(int i = 0; i < inStockItems.size(); i++)
        {
            if(inStockItems.get(i).getID() == item1ID)
            {
                Item compareItem = inStockItems.get(i); // compare
                for (Item inStockItem : inStockItems) { // inner loop
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

    /**
     *
     * @param dvdIDHistory give the ID collection of sold dvds
     * @param cdIDHistory give the ID collection of sold cds
     * @param bookIDHistory give the ID collection of sold books
     */
    public void displayItems(ArrayList<Integer> dvdIDHistory, ArrayList<Integer> cdIDHistory, ArrayList<Integer> bookIDHistory) {
        System.out.println("Items in the cart:\n");
        for (Item inStockItem : inStockItems) {
            int compareID = inStockItem.getID();
            for (Integer itemLocation : dvdIDHistory) {
                if (compareID == itemLocation) {
                    System.out.println("Name: " + inStockItems.get(compareID).getName());
                    System.out.println("Price: " + inStockItems.get(compareID).getPrice());
                    System.out.println(inStockItems.get(compareID).useItem());
                    System.out.println();
                    break;
                }
            }
            for (Integer itemLocation : cdIDHistory) {
                if (compareID == itemLocation) {
                    System.out.println("Name: " + inStockItems.get(compareID).getName());
                    System.out.println("Price: " + inStockItems.get(compareID).getPrice());
                    System.out.println(inStockItems.get(compareID).useItem());
                    System.out.println();
                    break;
                }
            }
            for (Integer itemLocation : bookIDHistory) {
                if (compareID == itemLocation) {
                    System.out.println("Name: " + inStockItems.get(compareID).getName());
                    System.out.println("Price: " + inStockItems.get(compareID).getPrice());
                    System.out.println(inStockItems.get(compareID).useItem());
                    System.out.println();
                    break;
                }
            }
        }
    }
    public void refundAllItems()
    {
        for (Item inStockItem : inStockItems) {
            if (inStockItem.isStatus()) {
                inStockItem.setStatus(false);
            }
        }
    }
    public void logItemsSold() {
        try {
            FileWriter writer = new FileWriter("src/misc/sales_report.html", true);

            for (Item soldItem : soldItems) {
                if (soldItem.isStatus()) {
                    String itemType = "";
                    if (soldItem.getClass().equals(CD.class)) {
                        itemType = "CD";
                    } else if (soldItem.getClass().equals(Book.class)) {
                        itemType = "Book";
                    } else if (soldItem.getClass().equals(DVD.class)) {
                        itemType = "DVD";
                    }

                    writer.write("<p>" + itemType + ": </p>\n");
                    writer.write("<p>Name: " + soldItem.getName() + "</p>\n");
                    writer.write("<p>Price: $" + soldItem.getPrice() + "</p>\n");
                    writer.write("<p>ID: " + soldItem.getID() + "</p>\n");
                    writer.write("<hr />\n");
                }
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}