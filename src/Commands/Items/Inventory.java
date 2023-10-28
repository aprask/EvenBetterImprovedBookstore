/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands.Items;
/**
 *
 * @author skalg
 */
    public class Inventory {
        private static final int MAX_ITEMS = 5;
        private static final Book[] books = new Book[MAX_ITEMS];
        private static final CD[] cds = new CD[MAX_ITEMS];
        private static final DVD[] dvds = new DVD[MAX_ITEMS];
        protected static int selectionID;
        public Inventory()
        {
            initializeItems();
        }

        public void initializeItems()
        {
            Book narnia = new Book("Narnia", 15.99, 300, 0,true);
            books[0] = narnia;
            Book theLordOfTheRings = new Book("The Lord of the Rings", 5.00,1000,1,true);
            books[1] = theLordOfTheRings;
            Book animalFarm = new Book("Animal Farm", 5.00,250,2,true);
            books[2] = animalFarm;
            Book theIliad = new Book("The Iliad", 40.25, 8000,3,true);
            books[3] = theIliad;
            Book nineteenEightyFour = new Book("1984",10.50,95,4,true);
            books[4] = nineteenEightyFour;

            CD thriller = new CD("Thriller", 8.95, 250,0,true);
            cds[0] = thriller;
            CD hotelCalifornia = new CD("Hotel California",6.95, 100,1,true);
            cds[1] = hotelCalifornia;
            CD backInBlack = new CD("Back in Black", 5.50,150,2,true);
            cds[2] = backInBlack;
            CD thePlanets = new CD("The Planets", 150.75, 5000,3,true);
            cds[3] = thePlanets;
            CD rideOfTheValkyries = new CD("Ride of the Valkyries", 250.25, 250,4,true);
            cds[4] = rideOfTheValkyries;

            DVD starWars = new DVD("Star Wars", 9.15,600,0,true);
            dvds[0] = starWars;
            DVD theTerminator = new DVD("The Terminator", 10.55, 550,1,true);
            dvds[1] = theTerminator;
            DVD starTrek = new DVD("Star Trek", 10.75, 1000,2,true);
            dvds[2] = starTrek;
            DVD theGodfather = new DVD("The Godfather", 25.25, 1025,3,true);
            dvds[3] = theGodfather;
            DVD theSopranos = new DVD("The Sopranos", 12.55, 1202,4,true);
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
            DVD oldDVD = new DVD("SOLD OUT",false);
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
            Book oldBook = new Book("SOLD OUT",false);
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


    }