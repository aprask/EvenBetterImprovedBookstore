/**
 * @author skalg
 */
import Commands.Store;

public class Main
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
        Store store = new Store();
        store.prepareStore();
        store.openStore();
        store.handleRestockProcedure();
    }
}