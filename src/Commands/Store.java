package Commands;
import Commands.Items.*;
import Commands.User.Cart;

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
    private ArrayList<Integer> dvdIDHistory = new ArrayList<>();
    private ArrayList<Integer> cdIDHistory = new ArrayList<>();
    private ArrayList<Integer> bookIDHistory = new ArrayList<>();
    private static int previousPurchasedProduct;
    private static int previousProductType;
    private final Cart cart = new Cart(this.inventory);
    private CD cd;
    private DVD dvd;
    private Book book;
    public static int getPreviousPurchasedProduct() {
        return previousPurchasedProduct;
    }
    public void prepareStore()
    {
        this.inventory.initializeItems();
    }
    public void openStore()
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
                inventory.availableItems(2);
                int selectedBookID = scan.nextInt();
                previousPurchasedProduct = (selectedBookID);
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
                    this.inventory.sellBook(selectedBookID);
                }
            }
            case 2 -> {
                System.out.println("Which CD? Select by ID ");
                inventory.availableItems(1);
                int selectedCDID = scan.nextInt();
                previousPurchasedProduct = (selectedCDID);
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
                    this.inventory.sellCD(selectedCDID);
                }
            }
            case 3 -> {
                System.out.println("Which DVD? Select by ID ");
                inventory.availableItems();
                int selectedDVDID = scan.nextInt(3);
                previousPurchasedProduct = (selectedDVDID);
                if(!this.dvdIDHistory.contains(selectedDVDID))
                {
                    this.dvdIDHistory.add(selectedDVDID);
                }
                else break;
                if (selectedDVDID < 5 && selectedDVDID > 0) {
                    this.register.proceedWithOrder();
                    double amountSpent = this.inventory.getDVDPrice(selectedDVDID);
                    this.register.handleBankInteraction(amountSpent, this.register.enter.getClient());
                    this.inventory.sellDVD(selectedDVDID);
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
                this.cart.clearCart(true);
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
                    previousProductType = itemIDTracker;
                    this.inventory.setSelectionID(itemIDTracker);
                    menu();
                    // TODO-- this.cart.addToCart(inventory.findSpecifiedItem(previousProductType,previousPurchasedProduct));
                    System.out.println("\nWould you like to add another item to your cart? Type \"1\": ");
                    System.out.println("\nWould you like to compare two items by price? Type \"5\": ");
                    if (this.register.getPartyTotal() > 1) {
                        System.out.println("Or would you like to move on to the next customer in your party? or \"2\"");
                    }
                    if (trackOrderAmount == this.register.getPartyTotal()) {
                        System.out.println("Or would you like to checkout? Type \"-1\"");
                    }
                    String cartChoice = scan.next();

                    if (cartChoice.equalsIgnoreCase("-1")) {
                        displayItemActions();
                        System.out.println("\nWould you like a refund? Type \"yes\" or \"no\"");
                        String refundOption = scan.next();
                        if (refundOption.equalsIgnoreCase("yes")) {
                            RefundItems refundItems = new RefundItems(register);
                            refundItems.execute();
                            handleRestockProcedure();
                        }
                        else
                        {
                            CheckOutItems checkOut = new CheckOutItems(register);
                            checkOut.execute();
                            handleRestockProcedure();
                        }
                        break;
                    }
                    else if (cartChoice.equalsIgnoreCase("2")) {
                        displayItemActions();
                        trackOrderAmount++;
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
        public void handleRestockProcedure()
        {
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
    public void displayItemActions()
    {
        System.out.println("Before we move on, we wanted to tell you something");
        System.out.println("You can now do this: ");
        cart.displayItems();
    }
}
