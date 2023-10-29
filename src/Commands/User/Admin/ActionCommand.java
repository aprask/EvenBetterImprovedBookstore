package Commands.User.Admin;

import Commands.Items.Inventory;

public interface ActionCommand {
        /*
    TODO: purpose of this class => make a set of commands for the manager to use to handle each customer
        1) make a handleCustomer method
        2) make a checkInventory method
        3) make a kickOutCustomer method
        4) make a offerPremium method
        5) make a restockProduct method
        6) make a refundCustomer method
        7) make a finalizeOrder method
     */
    public void handleCustomer(int customerID);
    public void checkInventory(Inventory inventory);
    public void kickOutCustomer(int customerID);
    public boolean offerPremium();
    public void restockProduct(int productID);
    public String refundCustomer(int customerID);
    public void finalizeOrder();
}
