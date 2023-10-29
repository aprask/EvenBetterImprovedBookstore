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
        private static final int MAX_ITEMS = 5;
        private static final Book[] books = new Book[MAX_ITEMS];
        private static final CD[] cds = new CD[MAX_ITEMS];
        private static final DVD[] dvds = new DVD[MAX_ITEMS];
        private static final Book[] soldBooks = new Book[MAX_ITEMS];
        private static final CD[] soldCds = new CD[MAX_ITEMS];
        private static final DVD[] soldDvds = new DVD[MAX_ITEMS];
        protected static int selectionID;
        private final Scanner scan = new Scanner(System.in);
        public Inventory()
        {
            initializeItems();
        }

        public void initializeItems()
        {
            Book narnia = new Book("Narnia", 15.99, 300, 0);
            books[0] = narnia;
            Book theLordOfTheRings = new Book("The Lord of the Rings", 5.00,1000,1);
            books[1] = theLordOfTheRings;
            Book animalFarm = new Book("Animal Farm", 5.00,250,2);
            books[2] = animalFarm;
            Book theIliad = new Book("The Iliad", 40.25, 8000,3);
            books[3] = theIliad;
            Book nineteenEightyFour = new Book("1984",10.50,95,4);
            books[4] = nineteenEightyFour;

            CD thriller = new CD("Thriller", 8.95, 250,0);
            cds[0] = thriller;
            CD hotelCalifornia = new CD("Hotel California",6.95, 100,1);
            cds[1] = hotelCalifornia;
            CD backInBlack = new CD("Back in Black", 5.50,150,2);
            cds[2] = backInBlack;
            CD thePlanets = new CD("The Planets", 150.75, 5000,3);
            cds[3] = thePlanets;
            CD rideOfTheValkyries = new CD("Ride of the Valkyries", 250.25, 250,4);
            cds[4] = rideOfTheValkyries;

            DVD starWars = new DVD("Star Wars", 9.15,600,0);
            dvds[0] = starWars;
            DVD theTerminator = new DVD("The Terminator", 10.55, 550,1);
            dvds[1] = theTerminator;
            DVD starTrek = new DVD("Star Trek", 10.75, 1000,2);
            dvds[2] = starTrek;
            DVD theGodfather = new DVD("The Godfather", 25.25, 1025,3);
            dvds[3] = theGodfather;
            DVD theSopranos = new DVD("The Sopranos", 12.55, 1202,4);
            dvds[4] = theSopranos;
        }

        /**
         *
         * @param remove remove CD via item ID (index)
         */
        public void removeCD(int remove)
        {
            CD oldCD = new CD("SOLD OUT",false);
            for(int i = 0; i < cds.length; i++)
            {
                if(cds[i] == cds[remove])
                {
                    cds[i] = oldCD;
                }
            }
        }

        /**
         *
         * @param remove remove DVD via item ID (index)
         */
        public void removeDVD(int remove)
        {
            DVD oldDVD = new DVD("SOLD OUT");
            oldDVD.setStatus(true);
            for(int i = 0; i < dvds.length; i++)
            {
                if(dvds[i] == dvds[remove])
                {
                    dvds[i] = oldDVD;
                }
            }
        }
        /**
         *
         * @param remove remove Book via item ID (index)
         */
        public void removeBook(int remove)
        {
            Book oldBook = new Book("SOLD OUT");
            oldBook.setStatus(true);
            for(int i = 0; i < books.length; i++)
            {
                if(books[i] == books[remove])
                {
                    books[i] = oldBook;
                }
            }
        }

        public void availableBooks()
        {
            System.out.println("******************************************************************");
            System.out.println("Available Books: ");
            for (Book book : books) {
                if (book != null) {
                    System.out.println();
                    System.out.println("Name: " + book.getItemName());
                    System.out.println("Price: $" + book.getItemPrice());
                    System.out.println("Pages: " + book.getPages());
                }
            }
            System.out.println("******************************************************************");
            System.out.println();
        }
        public void availableCDs()
        {
            System.out.println("******************************************************************");
            System.out.println("Available CDs: ");
            for (CD cd : cds) {
                if (cd != null) {
                    System.out.println();
                    System.out.println("Name: " + cd.getItemName());
                    System.out.println("Price: $" + cd.getItemPrice());
                    System.out.println("Length in seconds: " + cd.getCdLength());
                }
            }
            System.out.println("******************************************************************");
            System.out.println();
        }
        public void availableDVDs()
        {
            System.out.println("******************************************************************");
            System.out.println("Available DVDs: ");
            for (DVD dvd : dvds) {
                if (dvd != null) {
                    System.out.println();
                    System.out.println("Name: " + dvd.getItemName());
                    System.out.println("Price: $" + dvd.getItemPrice());
                    System.out.println("Length in seconds: " + dvd.getDvdLength());
                }
            }
            System.out.println("******************************************************************");
            System.out.println();
        }

        /**
         *
         * @return menu of items used in Store.java
         */
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

        /**
         *
         * @return return the ID selected
         */
        public int getSelectionID() {
            return selectionID;
        }

        /**
         *
         * @param selectionID set the selection ID
         */
        public void setSelectionID(int selectionID) {
            Inventory.selectionID = selectionID;
        }

        /**
         *
         * @param itemID collect the dvd's ID
         * @return return dvd's price
         */
        public double getDVDPrice(int itemID)
        {
            return dvds[itemID].getItemPrice();
        }
        /**
         *
         * @param itemID collect the cd's ID
         * @return return cd's price
         */
        public double getCDPrice(int itemID)
        {
            return cds[itemID].getItemPrice();
        }
        /**
         *
         * @param itemID collect the book's ID
         * @return return book's price
         */
        public double getBookPrice(int itemID)
        {
            return books[itemID].getItemPrice();
        }


        @Override
        public void restockProduct() {
            do {
                System.out.println("Which type of item would you like to restock? ");
                System.out.println("1 = CD, 2 = Book, 3 = DVD");
                int productType = scan.nextInt();
                if(productType == 1)
                {
                    System.out.println("Here is the list of sold CDs");
                    for (CD soldCd : soldCds) {
                        if (soldCd.isSold())
                        {
                            System.out.println("Name: " + soldCd.getName() + "\nID: " + soldCd.getCdID());
                        }
                    }
                    System.out.println("Select by ID: ");
                    int selectByID = scan.nextInt();
                    soldCds[selectByID] = new CD("empty", 0, 0, -99);
                    for(int i = 0; i < cds.length; i++)
                    {
                        if(cds[i].getCdID() == selectByID)
                        {
                            System.out.println("What is the name of the new CD? ");
                            String nameOfProduct = scan.next();
                            System.out.println("How much does " + nameOfProduct + " cost? ");
                            double costOfProduct = scan.nextDouble();
                            System.out.println("Length of CD? (in seconds)? ");
                            double lengthOfCD = scan.nextDouble();
                            cds[i] = new CD(nameOfProduct,costOfProduct,lengthOfCD,selectByID);
                            System.out.println("Restocked!");
                            break;
                        }
                    }
                }
                else if(productType == 2)
                {
                    System.out.println("Here is the list of sold Books");
                    for (Book soldBook : soldBooks) {
                        if (soldBook.isSold())
                        {
                            System.out.println("Name: " + soldBook.getName() + "\nID: " + soldBook.getBookID());
                        }
                    }
                    System.out.println("Select by ID: ");
                    int selectByID = scan.nextInt();
                    soldBooks[selectByID] = new Book("empty", 0, 0, -99);
                    for(int i = 0; i < books.length; i++)
                    {
                        if(books[i].getBookID() == selectByID)
                        {
                            System.out.println("What is the name of the new book? ");
                            String nameOfProduct = scan.next();
                            System.out.println("How much does " + nameOfProduct + " cost? ");
                            double costOfProduct = scan.nextDouble();
                            System.out.println("How many pages? ");
                            int pageCount = scan.nextInt();
                            books[i] = new Book(nameOfProduct, costOfProduct, pageCount, selectByID);
                            System.out.println("Restocked!");
                            break;
                        }
                    }
                }
                else if(productType == 3)
                {
                    System.out.println("Here is the list of sold DVDs");
                    for (DVD soldDVD : soldDvds) {
                        if (soldDVD.isSold())
                        {
                            System.out.println("Name: " + soldDVD.getName() + "\nID: " + soldDVD.getDvdID());
                        }
                    }
                    System.out.println("Select by ID: ");
                    int selectByID = scan.nextInt();
                    soldDvds[selectByID] = new DVD("empty", 0, 0, -99);
                    for(int i = 0; i < dvds.length; i++)
                    {
                        if(dvds[i].getDvdID() == selectByID)
                        {
                            System.out.println("What is the name of the new DVD? ");
                            String nameOfProduct = scan.next();
                            System.out.println("How much does " + nameOfProduct + " cost? ");
                            double costOfProduct = scan.nextDouble();
                            System.out.println("Length of CD? (in seconds)? ");
                            double lengthOfDVD = scan.nextDouble();
                            dvds[i] = new DVD(nameOfProduct,costOfProduct,lengthOfDVD,selectByID);
                            System.out.println("Restocked!");
                            break;
                        }
                    }
                }
                else
                {
                    System.out.println("Invalid ID");
                    continue;
                }
            } while (true);

        }
        public double totalCostOfBooks()
        {
            double total = 0;
            for (Book book : books) {
                total += book.getPrice();
            }
            return total;
        }
        public double totalCostOfCDs()
        {
            double total = 0;
            for (CD cd : cds) {
                total += cd.getPrice();
            }
            return total;
        }
        public double totalCostOfDVDs()
        {
            double total = 0;
            for (DVD dvd : dvds) {
                total += dvd.getPrice();
            }
            return total;
        }
        @Override
        public double inventoryValue() {
            return totalCostOfBooks()+totalCostOfDVDs()+totalCostOfCDs();
        }
        public void sellCD(int ID) {
            for (int i = 0; i < cds.length; i++)
            {
                if(cds[i].getCdID() == ID)
                {
                    soldCds[i] = cds[i];
                    soldCds[i].setStatus(true);
                    removeCD(ID);
                    break;
                }
            }
        }
        public void sellDVD(int ID)
        {
            for (int i = 0; i < dvds.length; i++)
            {
                if(dvds[i].getDvdID() == ID)
                {
                    soldDvds[i] = dvds[i];
                    soldDvds[i].setStatus(true);
                    removeDVD(ID);
                    break;
                }
            }
        }
        public void sellBook(int ID)
        {
            for (int i = 0; i < books.length; i++)
            {
                if(books[i].getBookID() == ID)
                {
                    soldBooks[i] = books[i];
                    soldBooks[i].setStatus(true);
                    removeBook(ID);
                    break;
                }
            }
        }
}