/**
 * @author skalg
 */
import Commands.Store;
public class Main
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Store store = new Store();
        store.prepareStore();
        store.openStore();
        store.handleRestockProcedure();
    }
}
/*
TODO
    1) Fix restock function
    2) Clean Code
    3) Write UML
    4) Write Documentation
    5) Write Java Doc
 */