package Commands;
import Commands.Items.*;
import Commands.User.Admin.Admin;

import java.io.IOException;
import java.util.*;
/**
 *
 * @author skalg
 */
public class Store {
    protected final Inventory inventory = new Inventory();
    public static int trackOrderAmount = 1;
    private final Register register = new Register();
    private static final Scanner scan = new Scanner(System.in);
    private static int itemIDTracker;
    protected static ArrayList<Integer> dvdIDHistory = new ArrayList<>();
    protected static ArrayList<Integer> cdIDHistory = new ArrayList<>();
    protected static ArrayList<Integer> bookIDHistory = new ArrayList<>();
    private static int numberOfCustomers;
    private final Admin admin = new Admin();
    public void prepareStore()
    {
        System.out.println("Hint: password is \"project2\"\n");
        if(this.admin.didPass())
        {
            this.inventory.initializeItems();
        }
    }
    public void openStore() throws IOException {
        System.out.println("Are you ready to open the store? (Yes or No?) ");
        String openTheStore = scan.next();
        if(openTheStore.equalsIgnoreCase("Yes"))
        {
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
                    numberOfCustomers = partyTotal-1;
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
        else
        {
            System.exit(0);
        }

    }

    public void menu() {
        switch (this.inventory.getSelectionID()) {
            case 1 -> {
                System.out.println("Which Book? Select by ID ");
                inventory.availableItems(2);
                int selectedBookID = scan.nextInt();
                if(!bookIDHistory.contains(selectedBookID))
                {
                    bookIDHistory.add(selectedBookID);
                }
                else break;
                bookIDHistory.add(selectedBookID);
                if (selectedBookID < this.inventory.inStockItems.size() && selectedBookID > 0) {
                    this.register.proceedWithOrder();
                    double amountSpent = this.inventory.getBookPrice(selectedBookID);
                    this.register.handleBankInteraction(amountSpent, this.register.enter.getClient());
                    this.inventory.sellBook(selectedBookID);
                }
            }
            case 2 -> {
                System.out.println("Which CD? Select by ID ");
                inventory.availableItems(1);
                int selectedCDID = scan.nextInt();
                if(!cdIDHistory.contains(selectedCDID))
                {
                    cdIDHistory.add(selectedCDID);
                }
                else break;
                cdIDHistory.add(selectedCDID);
                if (selectedCDID < this.inventory.inStockItems.size() && selectedCDID > 0) {
                    this.register.proceedWithOrder();
                    double amountSpent = this.inventory.getCDPrice(selectedCDID);
                    this.register.handleBankInteraction(amountSpent, this.register.enter.getClient());
                    this.inventory.sellCD(selectedCDID);
                }
            }
            case 3 -> {
                System.out.println("Which DVD? Select by ID ");
                inventory.availableItems();
                int selectedDVDID = scan.nextInt();
                if(!dvdIDHistory.contains(selectedDVDID))
                {
                    dvdIDHistory.add(selectedDVDID);
                }
                else break;
                if (selectedDVDID < this.inventory.inStockItems.size() && selectedDVDID > 0) {
                    this.register.proceedWithOrder();
                    double amountSpent = this.inventory.getDVDPrice(selectedDVDID);
                    this.register.handleBankInteraction(amountSpent, this.register.enter.getClient());
                    this.inventory.sellDVD(selectedDVDID);
                }
            }
            default -> System.out.println("Error");
        }
    }

    public void handleUser() throws IOException {
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
    public void userBank(int ID) throws IOException {
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
                    if(itemIDTracker == 5)
                    {
                        this.inventory.compareItems();
                        continue;
                    }
                    this.inventory.setSelectionID(itemIDTracker);
                    menu();
                    System.out.println("\nWould you like to add another item to your cart? Type \"1\": ");
                    System.out.println("\nWould you like to compare two items by price? Type \"5\": ");
                    if (this.register.getPartyTotal() > 1 && numberOfCustomers > 0)
                    {
                        System.out.println("Or would you like to move on to the next customer in your party? or \"2\"");
                    }
                    if (trackOrderAmount == this.register.getPartyTotal()) {
                        System.out.println("Or would you like to checkout? Type \"-1\"");
                    }
                    String cartChoice = scan.next();

                    if (cartChoice.equalsIgnoreCase("-1")) {
                        displayCart();
                        System.out.println("\nWould you like a refund? Type \"yes\" or \"no\"");
                        String refundOption = scan.next();
                        if (refundOption.equalsIgnoreCase("yes")) {
                            RefundItems refundItems = new RefundItems(register);
                            refundItems.execute();
                            this.inventory.refundAllItems();
                        } else
                        {
                            CheckOutItems checkOut = new CheckOutItems(register);
                            checkOut.execute();
                        }
                        handleRestockProcedure();
                        break;
                    }
                    else if (cartChoice.equalsIgnoreCase("2")) {
                        displayCart();
                        this.getBookIDHistory().clear();
                        this.getCdIDHistory().clear();
                        this.getDvdIDHistory().clear();
                        trackOrderAmount++;
                        numberOfCustomers--;
                        break;
                    }
                    else if(cartChoice.equalsIgnoreCase("5"))
                    {
                        this.inventory.compareItems();
                    }
                    else if (!cartChoice.equalsIgnoreCase("1")) {
                        break;
                    }
                }
            }
        }
        public void handleRestockProcedure() throws IOException {
            System.out.println("\nHello manager");
            System.out.println("Since all the customers have received their items, it is now time to restock the store");
            System.out.println("Complete the following procedure to properly close the store until the next set of customers arrive\n");
            this.inventory.handleRestock();
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
        Store.dvdIDHistory = dvdIDHistory;
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
        Store.cdIDHistory = cdIDHistory;
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
        Store.bookIDHistory = bookIDHistory;
    }
    public void displayCart()
    {
        displayItems();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void displayItems()
    {
        this.inventory.displayItems(this.getDvdIDHistory(),this.getCdIDHistory(),this.getBookIDHistory());
    }

}
