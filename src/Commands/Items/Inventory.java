/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands.Items;

import java.util.*;
/**
 *
 * @author skalg
 */
    public class Inventory implements BookStoreSpecification {
    private static final ArrayList<Book> inStockBooks = new ArrayList<>();
    private static final ArrayList<CD> inStockCDS = new ArrayList<>();
    private static final ArrayList<DVD> inStockDVDS = new ArrayList<>();
    private static final ArrayList<Book> soldBooks = new ArrayList<>();
    private static final ArrayList<CD> soldCDs = new ArrayList<>();
    private static final ArrayList<DVD> soldDvds = new ArrayList<>();

    /*
            private static final Book[] soldBooks = new Book[MAX_ITEMS];
            private static final CD[] soldCds = new CD[MAX_ITEMS];
            private static final DVD[] soldDvds = new DVD[MAX_ITEMS];
     */
    protected static int selectionID;
    private static final int cdReference = 1;
    private static final int bookReference = 2;
    private static final int dvdReference = 3;
    private static int cds_Sold;
    private static int books_Sold;
    private static int dvds_Sold;
    private final Scanner scan = new Scanner(System.in);

    public Inventory() {
        initializeItems();
    }

    public void initializeItems() {
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
    }

    /**
     * @param remove remove CD via item ID (index)
     */
    public void removeCD(int remove) {
        CD oldCD = new CD("SOLD", 0);
        oldCD.setStatus(true);
        for (int i = 0; i < inStockCDS.size(); i++) {
            if (inStockCDS.get(i).getCdID() == remove) {
                inStockCDS.set(i, oldCD);
            }
        }
    }

    /**
     * @param remove remove DVD via item ID (index)
     */
    public void removeDVD(int remove) {
        DVD oldDVD = new DVD("SOLD", 0);
        oldDVD.setStatus(true);
        for (int i = 0; i < inStockDVDS.size(); i++) {
            if (inStockDVDS.get(i).getDvdID() == remove) {
                inStockDVDS.set(i, oldDVD);
            }
        }
    }

    /**
     * @param remove remove Book via item ID (index)
     */
    public void removeBook(int remove) {
        Book oldBook = new Book("SOLD", 0);
        oldBook.setStatus(true);
        for (int i = 0; i < inStockBooks.size(); i++) {
            if (inStockBooks.get(i).getBookID() == remove) {
                inStockBooks.set(i, oldBook);
            }
        }
    }

    public void availableBooks() {
        System.out.println("******************************************************************");
        System.out.println("Available Books: ");
        for (int i = 0; i < inStockBooks.size(); i++) {
            if (inStockBooks.get(i) != null) {
                System.out.println();
                System.out.println("Name: " + inStockBooks.get(i).getItemName());
                System.out.println("Price: $" + inStockBooks.get(i).getItemPrice());
                System.out.println("Pages: " + inStockBooks.get(i).getPages());
            }
        }
        System.out.println("******************************************************************");
        System.out.println();
    }

    public void availableCDs() {
        System.out.println("******************************************************************");
        System.out.println("Available CDs: ");
        for (int i = 0; i < inStockCDS.size(); i++) {
            if (inStockCDS.get(i) != null) {
                System.out.println();
                System.out.println("Name: " + inStockCDS.get(i).getItemName());
                System.out.println("Price: $" + inStockCDS.get(i).getItemPrice());
                System.out.println("Length in seconds: " + inStockCDS.get(i).getCdLength());
            }
        }
        System.out.println("******************************************************************");
        System.out.println();
    }

    public void availableDVDs() {
        System.out.println("******************************************************************");
        System.out.println("Available DVDs: ");
        for (int i = 0; i < inStockDVDS.size(); i++) {
            if (inStockDVDS.get(i) != null) {
                System.out.println();
                System.out.println("Name: " + inStockDVDS.get(i).getItemName());
                System.out.println("Price: $" + inStockDVDS.get(i).getItemPrice());
                System.out.println("Length in seconds: " + inStockDVDS.get(i).getDvdLength());
            }
        }
        System.out.println("******************************************************************");
        System.out.println();
    }

    /**
     *
     * @return menu of items used in Store.java
     */

        /*
                @Override
        public String toString() {
            int var = getSelectionID();
            if(var == 1)
            {
                return
                        books[0].getItemName() + ": " + books[0].getBookID() +
                                "\n" +
                        books[1].getItemName() + ": " + books[1].getBookID() +
                                "\n" +
                        books[2].getItemName() + ": " + books[2].getBookID() +
                                "\n" +
                        books[3].getItemName() + ": " + books[3].getBookID() +
                                "\n" +
                        books[4].getItemName() + ": " + books[4].getBookID();
            }
            else if(var == 2)
            {
               return
                       cds[0].getItemName() + ": " + cds[0].getCdID() +
                               "\n" +
                       cds[1].getItemName() + ": " + cds[1].getCdID() +
                               "\n" +
                       cds[2].getItemName() + ": " + cds[2].getCdID() +
                               "\n" +
                       cds[3].getItemName() + ": " + cds[3].getCdID() +
                               "\n" +
                       cds[4].getItemName() + ": " + cds[4].getCdID();
            }
            else if(var == 3)
            {
                return
                        dvds[0].getItemName() + ": " + dvds[0].getDvdID() +
                                "\n" +
                        dvds[1].getItemName() + ": " + dvds[1].getDvdID() +
                                "\n" +
                        dvds[2].getItemName() + ": " + dvds[2].getDvdID() +
                                "\n" +
                        dvds[3].getItemName() + ": " + dvds[3].getDvdID() +
                                "\n" +
                        dvds[4].getItemName() + ": " + dvds[4].getDvdID();
            }
            else return null;
        }
         */

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
        return inStockDVDS.get(itemID).getItemPrice();
    }

    /**
     * @param itemID collect the cd's ID
     * @return return cd's price
     */
    public double getCDPrice(int itemID) {
        return inStockCDS.get(itemID).getItemPrice();
    }

    /**
     * @param itemID collect the book's ID
     * @return return book's price
     */
    public double getBookPrice(int itemID) {
        return inStockBooks.get(itemID).getItemPrice();
    }


    @Override
    public void restockProduct(int productID, int amount, int itemType) {
        if (itemType == 1) {
            while (amount > 0) {
                for (int i = 0; i < inStockCDS.size(); i++) {
                    if (inStockCDS.get(i).getCdID() == productID) {
                        System.out.println("What is the name of the new CD? ");
                        String nameOfProduct = scan.next();
                        System.out.println("How much does " + nameOfProduct + " cost? ");
                        double costOfProduct = scan.nextDouble();
                        System.out.println("Length of CD? (in seconds)? ");
                        double lengthOfCD = scan.nextDouble();
                        inStockCDS.set(i, new CD(nameOfProduct, costOfProduct, lengthOfCD, productID));
                        System.out.println("Restocked!");
                        break;
                    }
                }
                amount--;
            }
        } else if (itemType == 2) {
            while (amount > 0) {
                for (int i = 0; i < inStockBooks.size(); i++) {
                    if (inStockBooks.get(i).getBookID() == productID) {
                        System.out.println("What is the name of the new Book? ");
                        String nameOfProduct = scan.next();
                        System.out.println("How much does " + nameOfProduct + " cost? ");
                        double costOfProduct = scan.nextDouble();
                        System.out.println("Page count? ");
                        int lengthOfBook = scan.nextInt();
                        inStockBooks.set(i, new Book(nameOfProduct, costOfProduct, lengthOfBook, productID));
                        System.out.println("Restocked!");
                        break;
                    }
                }
                amount--;
            }
        } else if (itemType == 3) {
            while (amount > 0) {
                for (int i = 0; i < inStockDVDS.size(); i++) {
                    if (inStockDVDS.get(i).getDvdID() == productID) {
                        System.out.println("What is the name of the new DVD? ");
                        String nameOfProduct = scan.next();
                        System.out.println("How much does " + nameOfProduct + " cost? ");
                        double costOfProduct = scan.nextDouble();
                        System.out.println("Length of DVD? (in seconds)? ");
                        double lengthOfDVD = scan.nextDouble();
                        inStockDVDS.set(i, new DVD(nameOfProduct, costOfProduct, lengthOfDVD, productID));
                        System.out.println("Restocked!");
                        break;
                    }
                }
                amount--;
            }
        }
    }

    public void handleRestock() {
        do {
            System.out.println("Which type of item would you like to restock? ");
            System.out.println("1 = CD, 2 = Book, 3 = DVD");
            int productType = scan.nextInt();
            if (productType == 1) {
                System.out.println("Here is the list of sold CDs");
                for (CD soldCD : soldCDs) {
                    if (soldCD.isStatus()) {
                        System.out.println("Name: " + soldCD.getName() + "\nID: " + soldCD.getCdID());
                        cds_Sold++;
                    }
                }
                System.out.println("Select by ID: ");
                int selectByID = scan.nextInt();
                System.out.println("Given that there are " + cds_Sold + " CD slots available");
                while (true) {
                    System.out.println("How many versions of this CD product would you like to add? ");
                    int amountOfCDS = scan.nextInt();
                    if (amountOfCDS > cds_Sold) {
                        System.out.println("Try again\n");
                    } else {
                        restockProduct(selectByID, amountOfCDS, cdReference);
                        break;
                    }
                }
            } else if (productType == 2) {
                System.out.println("Here is the list of sold Books");
                for (Book soldBook : soldBooks) {
                    if (soldBook.isStatus()) {
                        System.out.println("Name: " + soldBook.getName() + "\nID: " + soldBook.getBookID());
                        books_Sold++;
                    }
                }
                System.out.println("Select by ID: ");
                int selectByID = scan.nextInt();
                System.out.println("Given that there are " + books_Sold + " book slots available");
                while (true) {
                    System.out.println("How many versions of this book product would you like to add? ");
                    int amountOfBooks = scan.nextInt();
                    if (amountOfBooks > books_Sold) {
                        System.out.println("Try again\n");
                    } else {
                        restockProduct(selectByID, amountOfBooks, bookReference);
                        break;
                    }
                }
            } else if (productType == 3) {
                System.out.println("Here is the list of sold DVDs");
                for (DVD soldDvd : soldDvds) {
                    if (soldDvd.isStatus()) {
                        System.out.println("Name: " + soldDvd.getName() + "\nID: " + soldDvd.getDvdID());
                        dvds_Sold++;
                    }
                }
                System.out.println("Select by ID: ");
                int selectByID = scan.nextInt();
                System.out.println("Given that there are " + dvds_Sold + " DVD slots available");
                while (true) {
                    System.out.println("How many versions of this DVD product would you like to add? ");
                    int amountOfDVDS = scan.nextInt();
                    if (amountOfDVDS > dvds_Sold) {
                        System.out.println("Try again\n");
                    } else {
                        restockProduct(selectByID, amountOfDVDS, dvdReference);
                        break;
                    }
                }
            } else {
                System.out.println("Invalid ID");
                continue;
            }
        } while (true);
    }
    public double totalCostOfBooks()
    {
        double total = 0;
        for (Book inStockBook : inStockBooks) {
            total += inStockBook.getPrice();
        }
        return total;
    }
    public double totalCostOfCDs()
    {
        double total = 0;
        for (CD inStockCD : inStockCDS) {
            total += inStockCD.getPrice();
        }
        return total;
    }
    public double totalCostOfDVDs()
    {
        double total = 0;
        for (DVD inStockDVD : inStockDVDS) {
            total += inStockDVD.getPrice();
        }
        return total;
    }
    @Override
    public double inventoryValue() {
        return totalCostOfBooks()+totalCostOfDVDs()+totalCostOfCDs();
    }
    public void sellCD(int ID) {
        for (int i = 0; i < inStockDVDS.size(); i++)
        {
            if(inStockCDS.get(i).getCdID() == ID)
            {
                soldCDs.add(i,inStockCDS.get(i));
                soldCDs.get(i).setStatus(true);
                removeCD(ID);
                break;
            }
        }
    }
    public void sellBook(int ID) {
        for (int i = 0; i < inStockBooks.size(); i++)
        {
            if(inStockBooks.get(i).getBookID() == ID)
            {
                soldBooks.add(i,inStockBooks.get(i));
                soldBooks.get(i).setStatus(true);
                removeBook(ID);
                break;
            }
        }
    }
    public void sellDVD(int ID) {
        for (int i = 0; i < inStockDVDS.size(); i++)
        {
            if(inStockDVDS.get(i).getDvdID() == ID)
            {
                soldDvds.add(i,inStockDVDS.get(i));
                soldDvds.get(i).setStatus(true);
                removeDVD(ID);
                break;
            }
        }
    }

    public void addCD(String name, ) {

    }
}