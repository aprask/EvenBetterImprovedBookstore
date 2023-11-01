package Commands.Items;

import Commands.Items.Factory.Factory;

import java.util.*;
/**
 *
 * @author skalg
 */
    public class Inventory implements BookStoreSpecification
{
    private static final ArrayList<Book> inStockBooks = new ArrayList<>();
    private Factory factory = new Factory();
    private static final ArrayList<CD> inStockCDS = new ArrayList<>();
    private static final ArrayList<DVD> inStockDVDS = new ArrayList<>();
    private DVD dvd;
    private CD cd;
    private Book book;
    protected static int selectionID;
    private final Scanner scan = new Scanner(System.in);

    public Inventory() {

    }

    public void initializeItems() {
        System.out.println("\nHello manager!\n");
        System.out.println("Would you like to create custom items? ");
        System.out.println("\"Yes\" for custom items");
        System.out.println("\"No\" for default items");
        String stockOrCustom = scan.next();
        if (stockOrCustom.equalsIgnoreCase("yes")) {
            this.factory.constructItem();
            System.out.println("Total Cost of Inventory: " + this.inventoryValue());
        } else {
            Book narnia = new Book("Narnia", 15.99, 300, 0);
            inStockBooks.add(narnia);
            Book theLordOfTheRings = new Book("The Lord of the Rings", 5.00, 1000, 1);
            inStockBooks.add(theLordOfTheRings);
            Book animalFarm = new Book("Animal Farm", 5.00, 250, 2);
            inStockBooks.add(animalFarm);
            Book theIliad = new Book("The Iliad", 40.25, 8000, 3);
            inStockBooks.add(theIliad);
            Book nineteenEightyFour = new Book("1984", 10.50, 95, 4);
            inStockBooks.add(nineteenEightyFour);

            CD thriller = new CD("Thriller", 8.95, 250, 0);
            inStockCDS.add(thriller);
            CD hotelCalifornia = new CD("Hotel California", 6.95, 100, 1);
            inStockCDS.add(hotelCalifornia);
            CD backInBlack = new CD("Back in Black", 5.50, 150, 2);
            inStockCDS.add(backInBlack);
            CD thePlanets = new CD("The Planets", 150.75, 5000, 3);
            inStockCDS.add(thePlanets);
            CD rideOfTheValkyries = new CD("Ride of the Valkyries", 250.25, 250, 4);
            inStockCDS.add(rideOfTheValkyries);

            DVD starWars = new DVD("Star Wars", 9.15, 600, 0);
            inStockDVDS.add(starWars);
            DVD theTerminator = new DVD("The Terminator", 10.55, 550, 1);
            inStockDVDS.add(theTerminator);
            DVD starTrek = new DVD("Star Trek", 10.75, 1000, 2);
            inStockDVDS.add(starTrek);
            DVD theGodfather = new DVD("The Godfather", 25.25, 1025, 3);
            inStockDVDS.add(theGodfather);
            DVD theSopranos = new DVD("The Sopranos", 12.55, 1202, 4);
            inStockDVDS.add(theSopranos);
            System.out.println("Total Cost of Inventory: " + this.inventoryValue());
        }
    }

    public void availableBooks() {
        System.out.println("******************************************************************");
        System.out.println("Available Books: ");
        for (Book inStockBook : inStockBooks) {
            if (inStockBook.getName() != null && !inStockBook.isStatus()) {
                System.out.println();
                System.out.println("Name: " + inStockBook.getName());
                System.out.println("Price: $" + inStockBook.getPrice());
                System.out.println("ID: " + inStockBook.getID());
            }
        }
        System.out.println("******************************************************************");
        System.out.println();
    }

    public void availableCDs() {
        System.out.println("******************************************************************");
        System.out.println("Available CDs: ");
        for (CD inStockCD : inStockCDS) {
            if (inStockCD.getName() != null && !inStockCD.isStatus()) {
                System.out.println();
                System.out.println("Name: " + inStockCD.getName());
                System.out.println("Price: $" + inStockCD.getPrice());
                System.out.println("ID: " + inStockCD.getID());
            }
        }
        System.out.println("******************************************************************");
        System.out.println();
    }

    public void availableDVDs() {
        System.out.println("******************************************************************");
        System.out.println("Available DVDs: ");
        for (DVD inStockDVD : inStockDVDS) {
            if (inStockDVD.getName() != null && !inStockDVD.isStatus()) {
                System.out.println();
                System.out.println("Name: " + inStockDVD.getName());
                System.out.println("Price: $" + inStockDVD.getPrice());
                System.out.println("ID: " + inStockDVD.getID());
            }
        }
        System.out.println("******************************************************************");
        System.out.println();
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
     * @param itemID collect the dvd's ID
     * @return return dvd's price
     */
    public double getDVDPrice(int itemID) {
        return inStockDVDS.get(itemID).getPrice();
    }

    /**
     * @param itemID collect the cd's ID
     * @return return cd's price
     */
    public double getCDPrice(int itemID) {
        return inStockCDS.get(itemID).getPrice();
    }

    /**
     * @param itemID collect the book's ID
     * @return return book's price
     */
    public double getBookPrice(int itemID) {
        return inStockBooks.get(itemID).getPrice();
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
                inStockCDS.add(new CD(itemName,itemPrice,cdLength,itemID));
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
                inStockBooks.add(new Book(itemName,itemPrice,pages,itemID));
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
                inStockDVDS.add(new DVD(itemName,itemPrice,dvdLength,itemID));
                amount--;
            }
        }
        System.out.println("Current Inventory:");
        for (Book inStockBook : inStockBooks) {
            if (inStockBook.getName() != null && !inStockBook.isStatus()) {
                System.out.println("Name: " + inStockBook.getName());
            }
        }
        for (CD inStockCD : inStockCDS) {
            if (inStockCD.getName() != null && !inStockCD.isStatus()) {
                System.out.println("Name: " + inStockCD.getName());
            }
        }
        for (DVD inStockDVD : inStockDVDS) {
            if (inStockDVD.getName() != null && !inStockDVD.isStatus()) {
                System.out.println("Name: " + inStockDVD.getName());
            }
        }
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
        System.out.println("CDs: ");
        for (CD inStockCD : inStockCDS) {
            if (inStockCD.isStatus()) {
                System.out.println("\tName: " + inStockCD.getName());
                System.out.println("\tID: " + inStockCD.getID());
            }
        }
        System.out.println("Books: ");
        for (Book inStockBook : inStockBooks) {
            if (inStockBook.isStatus()) {
                System.out.println("Name: " + inStockBook.getName());
                System.out.println("ID: " + inStockBook.getID());
            }
        }
        System.out.println("DVDS: ");
        for (DVD inStockDVD : inStockDVDS) {
            if (inStockDVD.isStatus()) {
                System.out.println("Name: " + inStockDVD.getName());
                System.out.println("ID: " + inStockDVD.getID());
            }
        }
    }

    public double totalCostOfBooks() {
        double total = 0;
        for (Book inStockBook : inStockBooks) {
            total += inStockBook.getPrice();
        }
        return total;
    }

    public double totalCostOfCDs() {
        double total = 0;
        for (CD inStockCD : inStockCDS) {
            total += inStockCD.getPrice();
        }
        return total;
    }

    public double totalCostOfDVDs() {
        double total = 0;
        for (DVD inStockDVD : inStockDVDS) {
            total += inStockDVD.getPrice();
        }
        return total;
    }

    @Override
    public double inventoryValue() {
        return totalCostOfBooks() + totalCostOfDVDs() + totalCostOfCDs();
    }

    public void sellCD(int ID) {
        for (int i = 0; i < inStockCDS.size(); i++) {
            if (i == ID) {
                inStockCDS.get(i).setStatus(true);
            }
        }
    }

    public void sellBook(int ID) {
        for (int i = 0; i < inStockBooks.size(); i++) {
            if (i == ID) {
                inStockBooks.get(i).setStatus(true);
            }
        }
    }

    public void sellDVD(int ID) {
        for (int i = 0; i < inStockDVDS.size(); i++) {
            if (i == ID) {
                inStockDVDS.get(i).setStatus(true);
            }
        }
    }

    public void addCD(String itemName, double itemPrice, double cdLength, int cdID) {
        cd = new CD(itemName, itemPrice, cdLength, cdID);
        inStockCDS.add(cd);
    }

    public void addBook(String itemName, double itemPrice, int pages, int bookID) {
        book = new Book(itemName, itemPrice, pages, bookID);
        inStockBooks.add(book);
    }

    public void addDVD(String itemName, double itemPrice, double dvdLength, int cdID) {
        dvd = new DVD(itemName, itemPrice, dvdLength, cdID);
        inStockDVDS.add(dvd);
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }
}