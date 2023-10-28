/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Commands;
import Commands.User.Client;
/**
 *
 * @author skalg
 */

public interface Customer
{
    /**
     *
     * @param client takes in an instance of the Client.java class
     */
    public void enterStore(Client client);
    public void checkOut();
    public void refundOrder();

    /**
     *
     * @param status calls for an order status
     * @return return the order status (boolean) so the program can advance or not
     */
    public boolean isOrderDone(boolean status);

}

