package Commands.User.Admin;

import Commands.Items.Inventory;

public class Action implements ActionCommand
{

    public Action()
    {

    }

    @Override
    public void handleCustomer(int customerID) {

    }

    @Override
    public void checkInventory(Inventory inventory) {

    }

    @Override
    public void kickOutCustomer(int customerID) {

    }

    @Override
    public boolean offerPremium() {
        return false;
    }

    @Override
    public void restockProduct(int productID) {

    }

    @Override
    public String refundCustomer(int customerID) {
        return null;
    }

    @Override
    public void finalizeOrder() {

    }
}
