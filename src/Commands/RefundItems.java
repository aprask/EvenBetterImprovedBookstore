/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands;
import Commands.Items.Inventory;

/**
 *
 * @author skalg
 */

public class RefundItems implements Command {
    public Register register;

    /**
     *
     * @param newOrder call an instance of the Register.java class
     */
    public RefundItems(Register newOrder)
    {
        this.register = newOrder;
    }
    @Override
    public void execute() {
        this.register.refundOrder();
    }
}
