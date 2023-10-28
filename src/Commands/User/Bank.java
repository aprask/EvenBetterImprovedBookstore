/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands.User;
import Commands.EnterStore;
import Commands.Register;
import java.util.ArrayList;

/**
 *
 * @author skalg
 */

public class Bank
{
    public Register register = new Register();
    public Client userClient;
    public EnterStore enterStore;
    protected final ArrayList<Integer> banks = new ArrayList<>();
    /**
     *
     * @param enterStore calling an instance of EnterStore.java
     * @param userClient calling an instance of Client.java
     */
    public Bank(EnterStore enterStore, Client userClient)
    {
        while(banks.size() <= userClient.getID())
        {
            banks.add(0);
        }
        this.userClient = userClient;
        this.enterStore = enterStore;
        initializeAccounts();
    }
    public void initializeAccounts()
    {
        banks.add(userClient.getID(),1000);
    }
    public void deductFromBank(double payment)
    {
        int ID = this.userClient.getID();
        if(this.register.proceedWithOrder())
        {
            double newBankTotal = banks.get(ID) - payment;
            if(newBankTotal < 0)
            {
                System.out.println("Invalid Payment");
            }
            else if(newBankTotal > 0)
            {
                System.out.println("****************************************************************************");
                System.out.println("Your New Bank Balance: " + newBankTotal);
                System.out.println("****************************************************************************");
            }
            else {
                System.out.println("Something was incorrect with your input");
            }
        }

    }
}
