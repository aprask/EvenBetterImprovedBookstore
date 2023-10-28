/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands;

/**
 *
 * @author skalg
 */
public class CheckOutItems implements Command
{
    public Register register;

    /**
     *
     * @param newOrder takes in an instance of Register.java
     */
    public CheckOutItems(Register newOrder)
    {
        this.register = newOrder;
    }
    @Override
    public void execute() {
        this.register.checkOut();
    }
}
