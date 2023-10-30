package Commands.Items.Factory;

import Commands.Command;
import Commands.Items.Inventory;
import Commands.Items.Item;

public class StoreItems implements Command {
    private final Factory factory = new Factory();
    public StoreItems()
    {
    }

    @Override
    public void execute() {
        System.out.println("Total Number of Created: " + factory.getItemHistorySize());
    }

    public void storeItem(Item item)
    {
        factory.addItemToLog(item);
    }
}