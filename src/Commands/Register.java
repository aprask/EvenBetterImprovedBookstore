package Commands;
import Commands.Items.*;
import Commands.User.*;
import java.util.*;
/**
 *
 * @author skalg
 */
public class Register implements Customer {
    private static double orderTotal;
    public EnterStore enter;
    private static final Queue<String> orderOfCustomers = new LinkedList<>();
    private static int partyTotal;
    public Scanner scan = new Scanner(System.in);

    /**
     *
     * @param client takes in an instance of the Client.java class
     */
    @Override
    public void enterStore(Client client) {
        this.enter = new EnterStore(client);
    }
    @Override
    public void checkOut() {
        isOrderDone(true);
        System.out.println("\tReceipt: \n");
        for(int i = 0; i < partyTotal; i++)
        {
            System.out.println
                    ("$" + enter.getCustomerPayments().get(i)+ " for: " + EnterStore.customerNames.get(i));
        }
        if(partyTotal > 1)
        {
            System.out.println("Party Order Total: " + "$" + Register.orderTotal);
        }
    }

    @Override
    public void refundOrder() {
        System.out.println("Your order has been refunded");
        System.out.println("\tReceipt: \n");
        for(int i = 0; i < partyTotal; i++)
        {
            System.out.println
                    ("$" + enter.getCustomerPayments().get(i)+ " for: " + EnterStore.customerNames.get(i));
        }
        if(partyTotal > 1)
        {
            System.out.println("Your party's $" + Register.orderTotal + " has been returned to each of your payment methods");
        }
    }

    /**
     *
     * @param status calls for an order status
     * @return return the order status
     */
    @Override
    public boolean isOrderDone(boolean status) {
        return status;
    }

    /**
     *
     * @param val adds a val (value) to the overall total amount spent by the party
     */
    public static void addToTotal(double val)
    {
        Register.orderTotal += val;
    }

    /**
     *
     * @return returns true to notify the code to advance
     */
    public boolean proceedWithOrder()
    {
        return true;
    }

    /**
     *
     * @param payment retrieve the payment amount
     * @param client call and instance of the Client.java class
     */
    public void handleBankInteraction(double payment,Client client)
    {
        Bank bank = new Bank(enter,client);
        bank.deductFromBank(payment);
        enter.getCustomerPayments().add(payment);
        addToTotal(payment);
        System.out.println("Party Order Total: $" + Register.orderTotal);
        System.out.println("****************************************************************************");
    }

    /**
     *
     * @param inventory call an instance of the Inventory.java class
     * @return return the selected item based on (1,2,3)
     */
    public int createItems(Inventory inventory) {
            System.out.println();
            inventory.availableItems();
            System.out.println("\nType \"1\" to purchase a Book");
            System.out.println("Type \"2\" to purchase a CD");
            System.out.println("Type \"3\" to purchase a DVD");
            System.out.println("Type \"5\" to compare two items: ");
            return scan.nextInt();
    }

    /**
     *
     * @param partyTotal take in the amount the user enters as their party "amount"
     */
    public void partyTotal(int partyTotal) {
        Register.partyTotal = partyTotal;
        int i = 0;
        while (i < partyTotal) {
            int customerNumber = i + 1;
            System.out.println("Customer " + customerNumber + "'s name? (only first name will be recorded)");
            String customerName = scan.next();
            scan.nextLine();
            System.out.println("Does this customer want a premium membership? \"Yes\" or \"No\"?");
            boolean premium = false;
            String premiumOrNot = scan.next();
            if(premiumOrNot.equalsIgnoreCase("yes"))
            {
                premium = true;
            }
            Client customerClient = new Client(customerName, premium);
            orderOfCustomers.offer(customerClient.getName());
            Upgrade upgrade = new Upgrade(customerClient, customerName);
            if (premiumOrNot.equalsIgnoreCase("yes")) {
                upgrade.execute();
            } else {
                upgrade.doNotExecute();
            }
            this.enterStore(customerClient);
            upgrade.displayCustomers();
            i++;
            }
        }

    /**
     *
     * @return return via Queue FIFO data structure the name of the customer and then remove with .poll to advance the line
     */
    public String handleCustomer()
    {
        if (!orderOfCustomers.isEmpty()) {
            EnterStore.customerNames.add(orderOfCustomers.peek());
            return orderOfCustomers.poll();
        } else
        {
            return "";
        }
    }

    /**
     *
     * @return get the party total (how many customers are there in the party)
     */
    public int getPartyTotal() {
        return partyTotal;
    }
    public String compareValues(Item item1, double price)
    {
        return null;
    }

}





