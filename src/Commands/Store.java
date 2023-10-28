package Commands;
import Commands.Items.Inventory;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author skalg
 */
public class Store {
    private final Inventory inventory = new Inventory();
    public static int trackOrderAmount = 1;
    private final Register register = new Register();
    private static final Scanner scan = new Scanner(System.in);
    private static int itemIDTracker;
    private ArrayList<Integer> dvdIDHistory = new ArrayList<>();
    private ArrayList<Integer> cdIDHistory = new ArrayList<>();
    private ArrayList<Integer> bookIDHistory = new ArrayList<>();
    public void openStore() {
        bookLogo();
        System.out.println("Welcome to the book store!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean registration = true;
        while (registration)
        {
            System.out.println("How many members are in your party? ");
            int partyTotal;
            try
            {
                partyTotal = scan.nextInt();
                this.register.partyTotal(partyTotal);
                registration = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("ERROR, enter a number");
                scan.next();
            }
        }
        handleUser();
    }

    public void menu() {
        switch (this.inventory.getSelectionID()) {
            case 1 -> {
                System.out.println("Which Book? Select by ID ");
                System.out.println(inventory);
                int selectedBookID = scan.nextInt();
                if(!this.bookIDHistory.contains(selectedBookID))
                {
                    this.bookIDHistory.add(selectedBookID);
                }
                else break;
                this.bookIDHistory.add(selectedBookID);
                if (selectedBookID < 5 && selectedBookID > 0) {
                    this.register.proceedWithOrder();
                    double amountSpent = this.inventory.getBookPrice(selectedBookID);
                    this.register.handleBankInteraction(amountSpent, this.register.enter.getClient());
                    this.inventory.removeBook(selectedBookID);
                }
            }
            case 2 -> {
                System.out.println("Which CD? Select by ID ");
                System.out.println(inventory);
                int selectedCDID = scan.nextInt();
                if(!this.cdIDHistory.contains(selectedCDID))
                {
                    this.cdIDHistory.add(selectedCDID);
                }
                else break;
                this.cdIDHistory.add(selectedCDID);
                if (selectedCDID < 5 && selectedCDID > 0) {
                    this.register.proceedWithOrder();
                    double amountSpent = this.inventory.getCDPrice(selectedCDID);
                    this.register.handleBankInteraction(amountSpent, this.register.enter.getClient());
                    this.inventory.removeCD(selectedCDID);
                }
            }
            case 3 -> {
                System.out.println("Which DVD? Select by ID ");
                System.out.println(inventory);
                int selectedDVDID = scan.nextInt();
                if(!this.dvdIDHistory.contains(selectedDVDID))
                {
                    this.dvdIDHistory.add(selectedDVDID);
                }
                else break;
                if (selectedDVDID < 5 && selectedDVDID > 0) {
                    this.register.proceedWithOrder();
                    double amountSpent = this.inventory.getDVDPrice(selectedDVDID);
                    this.register.handleBankInteraction(amountSpent, this.register.enter.getClient());
                    this.inventory.removeDVD(selectedDVDID);
                }
            }
            default -> System.out.println("Error");
        }
    }

    public void handleUser() {
        for (int i = 0; i < this.register.getPartyTotal(); i++) {
            if (this.register.enter.getClient() == null)
            {
                break;
            }
            userBank(this.register.enter.getClient().getID());
        }
    }

    /**
     *
     * @param ID take in an ID to check if the user has purchased an item
     */
    public void userBank(int ID) {
            if (this.register.enter.purchaseItem(ID)) {
                String customerName = this.register.handleCustomer();
                if (customerName.isEmpty()) {
                    return;
                }
                System.out.println(customerName + "'s order:");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                while (true) {
                    System.out.println("Would you like a CD, DVD, or a Book? ");
                    itemIDTracker = this.register.createItems(this.inventory);
                    this.inventory.setSelectionID(itemIDTracker);
                    menu();

                    System.out.println("\nWould you like to add another item to your cart? Type \"1\": ");
                    if (this.register.getPartyTotal() > 1) {
                        System.out.println("Or would you like to move on to the next customer in your party? or \"2\"");
                    }
                    if (trackOrderAmount == this.register.getPartyTotal()) {
                        System.out.println("Or would you like to checkout? Type \"-1\"");
                    }
                    String cartChoice = scan.next();

                    if (cartChoice.equalsIgnoreCase("-1")) {
                        System.out.println("Would you like a refund? Type \"yes\" or \"no\"");
                        String refundOption = scan.next();
                        if (refundOption.equalsIgnoreCase("yes")) {
                            RefundItems refundItems = new RefundItems(register);
                            refundItems.execute();
                        } else {
                            CheckOutItems checkOut = new CheckOutItems(register);
                            checkOut.execute();
                        }
                        break;
                    } else if (cartChoice.equalsIgnoreCase("2")) {
                        trackOrderAmount++;
                        break;
                    } else if (!cartChoice.equalsIgnoreCase("1")) {
                        break;
                    }
                }
            }
        }

    /**
     *
     * @return ID tracker
     */
    public static int getItemIDTracker() {
        return itemIDTracker;
    }

    /**
     *
     * @param changedVal change the value of the ID tracker
     */
    public static void setItemIDTracker(int changedVal) {
        Store.itemIDTracker = changedVal;
    }
    public void bookLogo()
    {
        System.out.println("         ,..........   ..........,");
        System.out.println("     ,..,'          '.'          ',..,");
        System.out.println("    ,' ,'            :            ', ',");
        System.out.println("   ,' ,'             :             ', ',");
        System.out.println("  ,' ,'              :              ', ',");
        System.out.println("  ,' ,'              :              ', ',");
        System.out.println(" ,' ,'............., : ,.............', ',");
        System.out.println(",'  '............   '.'   ............'  ',");
        System.out.println(" '''''''''''''''''';''';''''''''''''''''''");
        System.out.println("                    '''");
        // source: https://www.asciiart.eu/books/books
    }

    /**
     *
     * @return return the DVD's existing purchased ID
     */
    public ArrayList<Integer> getDvdIDHistory() {
        return dvdIDHistory;
    }

    /**
     *
     * @param dvdIDHistory sets the list to hold the previously purchased DVD ID
     */
    public void setDvdIDHistory(ArrayList<Integer> dvdIDHistory) {
        this.dvdIDHistory = dvdIDHistory;
    }
    /**
     *
     * @return return the CD's existing purchased ID
     */
    public ArrayList<Integer> getCdIDHistory() {
        return cdIDHistory;
    }

    /**
     *
     * @param cdIDHistory sets the list to hold the previously purchased CD ID
     */
    public void setCdIDHistory(ArrayList<Integer> cdIDHistory) {
        this.cdIDHistory = cdIDHistory;
    }
    /**
     *
     * @return return the Book's existing purchased ID
     */
    public ArrayList<Integer> getBookIDHistory() {
        return bookIDHistory;
    }

    /**
     *
     * @param bookIDHistory sets the list to hold the previously purchased book ID
     */
    public void setBookIDHistory(ArrayList<Integer> bookIDHistory) {
        this.bookIDHistory = bookIDHistory;
    }
}
