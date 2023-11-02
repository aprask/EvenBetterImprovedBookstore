package Commands.User;

import Commands.Items.*;
import Commands.Items.Inventory;
import Commands.Items.Item;
import java.util.*;

import static Commands.Items.Inventory.*;

public class Cart
{
    Inventory inventory = new Inventory();
    ArrayList<Item> cartHistory;
    Item item;
    public Cart(Inventory inventory)
    {
        cartHistory = new ArrayList<>();
    }
    public void addToCart(Item item)
    {
        this.cartHistory.add(item);
    }
    public void displayItems()
    {
        resolveItems(inventory);
        for (Item value : cartHistory) {
            value.useItem();
        }
    }
    public void clearCart(boolean clear)
    {
        if(clear) cartHistory.clear();
    }

    public void resolveItems(Inventory inventory) {
        System.out.println();
    }

    /*
    for (int i = 0; i < cartHistory.size(); i++) {
            for (int j = 0; j < inventory.getNumberOfCDs() + inventory.getNumberOfDVDs() + inventory.getNumberOfBooks(); j++) {
                if (cartHistory.get(i).equals(inventory.inStockCDS.get(j))) {
                    cartHistory.set(i, new CD(inventory.inStockCDS.get(j).getName()));
                } else if (cartHistory.get(i).equals(inventory.inStockDVDS.get(j))) {
                    cartHistory.set(i, new DVD(inventory.inStockDVDS.get(j).getName()));
                } else if (cartHistory.get(i).equals(inventory.inStockBooks.get(j))) {
                    cartHistory.set(i, new Book(inventory.inStockBooks.get(j).getName()));
                }
            }
        }
     */

}
