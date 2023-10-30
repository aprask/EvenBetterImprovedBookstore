package Commands.Items.Factory;

import Commands.Item.*;
import Commands.Items.Inventory;
import Commands.User.Admin.Admin;

import java.util.ArrayList;
import java.util.Scanner;
import Commands.Items.*;


public class Factory
{
    private final Scanner scan = new Scanner(System.in);
    private static final Inventory inventory = new Inventory();
    private static final StoreItems storeItems = new StoreItems();
    private ItemType CD = ItemType.CD;
    private ItemType Book = ItemType.BOOK;
    private ItemType DVD = ItemType.DVD;
    private static final ArrayList<Item> itemHistory = new ArrayList<>();
    private final Admin admin = new Admin();
    public Factory()
    {

    }
    public void constructItem()
    {
        if(admin.didPass())
        {
            System.out.println("Select an item type: ");
            System.out.println("1 = CD\n2 = Book\n3 = DVD");
            int newItemType = scan.nextInt();
            while(itemDetails(newItemType))
            {
                System.out.println("Would you like another item? ");
                System.out.println("1 = CD\n2 = Book\n3 = DVD");
                System.out.println("Type -1 to exit");
                newItemType = scan.nextInt();
                if(newItemType == -1)
                {
                    storeItems.execute();
                    break;
                }
            }
        }

    }
    public boolean itemDetails(int itemType)
    {
        if(itemType == 1 || itemType == 2 || itemType == 3)
        {
            System.out.println("Enter item name: ");
            String itemName = scan.next();
            System.out.println("Enter item price: ");
            double itemPrice = scan.nextDouble();
            System.out.println("Enter item ID: ");
            int itemID = scan.nextInt();
            if(itemType == getCD().ID)
            {
                System.out.println("Enter the CD's length in seconds: ");
                double cdLength = scan.nextDouble();
                inventory.addCD();
                return true;
            }
            else if(itemType == getBook().ID)
            {
                System.out.println("Enter the page count: ");
                int pageCount = scan.nextInt();
                inventory.addItem(new Book(itemName,itemPrice,itemID,pageCount, Book.ID)); // TODO Transfer to inventory
                return true;
            }
            else if(itemType == getDVD().ID)
            {
                System.out.println("Enter the DVD's length in seconds: ");
                double dvdLength = scan.nextDouble();
                inventory.addItem(new CD(itemName,itemPrice,itemID,dvdLength, DVD.ID));
                return true;
            }
        }
        else
        {
            System.out.println("Invalid Item Type");
            return false;
        }
        return false;
    }
    public ItemType getCD() {
        return CD;
    }

    public void setCD(ItemType CD) {
        this.CD = CD;
    }

    public ItemType getBook() {
        return Book;
    }

    public void setBook(ItemType book) {
        Book = book;
    }

    public ItemType getDVD() {
        return DVD;
    }

    public void setDVD(ItemType DVD) {
        this.DVD = DVD;
    }
    public void addItemToLog(Item item)
    {
        itemHistory.add(item);
    }
    public int getItemHistorySize()
    {
        return itemHistory.size();
    }
}