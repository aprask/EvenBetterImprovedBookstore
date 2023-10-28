/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands;
import Commands.User.Client;
import java.util.ArrayList;


/**
 *
 * @author skalg
 */
public class EnterStore implements Command {
    private static Client client;
    public static ArrayList<Client> clients;
    public static ArrayList<String> customerNames = new ArrayList<>();
    public ArrayList<Double> customerPayments = new ArrayList<>();

    /**
     *
     * @param client takes in an instance of the Client.java class
     */
    public EnterStore(Client client)
    {
        EnterStore.client = client;
        clients = new ArrayList<>();
        clients.add(client);
    }
    @Override
    public void execute() {
        System.out.println("Party Total: " + clients.size());
    }
    public ArrayList<String> executeListBuilder() {
        for(int i = 0; i < clients.size(); i++)
        {
            customerNames.add(client.getName());
        }
        return customerNames;
    }

    /**
     *
     * @param ID calls in for an ID (for the client)
     * @return true if the customer has purchased the item based on their ID
     */
    public boolean purchaseItem(int ID)
    {
        for (Client value : clients) {
            if (value.getID() == ID) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return returns the client object
     */
    public Client getClient() {
        return client;
    }

    /**
     *
     * @param client sets the client object
     */
    public void setClient(Client client) {
        EnterStore.client = client;
    }

    /**
     *
     * @return the client(s) list
     */
    public ArrayList<Client> getClients() {
        return clients;
    }

    /**
     *
     * @param clients sets the client(s) list
     */
    public void setClients(ArrayList<Client> clients) {
        EnterStore.clients = clients;
    }

    /**
     *
     * @return returns the total amount spent by the customers via an ArrayList<Double> field
     */
    public ArrayList<Double> getCustomerPayments() {
        return customerPayments;
    }

    /**
     *
     * @param customerPayments sets the total amount spent by the customers via an ArrayList<Double> field
     */
    public void setCustomerPayments(ArrayList<Double> customerPayments) {
        this.customerPayments = customerPayments;
    }

    /**
     *
     * @return returns the customer's name from the list
     */
    public static ArrayList<String> getCustomerNames() {
        return customerNames;
    }

    /**
     *
     * @param customerNames sets the name of the customer within the list
     */
    public static void setCustomerNames(ArrayList<String> customerNames) {
        EnterStore.customerNames = customerNames;
    }
}