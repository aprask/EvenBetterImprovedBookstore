/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands.User;
import Commands.Register;
import java.util.*;
/**
 *
 * @author skalg
 */
public class Client {
    private String name;
    private static int ID = 0;
    private boolean orderStatus;
    private boolean premiumMember;
    public static Scanner scan = new Scanner(System.in);
    private String paymentType;
    private static final Register register = new Register();
    public Client()
    {

    }

    /**
     *
     * @param name collect name
     */
    public Client(String name)
    {
        this.name = name;
    }

    /**
     *
     * @param name collect name
     * @param membershipType collect membership type (prem or not)
     */
    public Client(String name, boolean membershipType)
    {
        this.name = name;
        this.premiumMember = membershipType;
    }

    /**
     *
     * @param name collect name
     * @param membershipType collect membership type (prem or not)
     * @param paymentType collect the payment type (any type they input, no restrictions)
     */
    public Client(String name, boolean membershipType, String paymentType)
    {
        this.name = name;
        ID++;
        this.orderStatus = register.isOrderDone(true);
        this.premiumMember = membershipType;
        this.paymentType = paymentType;
    }

    /**
     *
     * @return return the client's ID
     */
    public int getID() {
        return ID;
    }

    /**
     *
     * @return return the client's name
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @param name set the client's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return the membership type
     */
    public String displayMembershipDetails()
    {
        if(premiumMember)
        {
            return "Member Type: Premium";
        }
        else
        {
            return "Member Type: Standard";
        }
    }

    /**
     *
     * @return return the payment type
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     *
     * @param premiumMember calls whether the client is premium or not
     */
    public void setPremiumMember(boolean premiumMember) {
        this.premiumMember = premiumMember;
    }

    /**
     *
     * @param orderStatus tells the program if the order is done
     */
    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }
    public void membershipDueDate()
    {
        System.out.println("What month did you purchase your membership? ");
        System.out.println("Type in a number 1-12 to represent the month: ");
        int membershipMonth = scan.nextInt();
        final float premiumPayment = 7.55f;
        switch (membershipMonth) {
            case 1 -> System.out.println("Your membership payment of $" + premiumPayment + " will be due in February");
            case 2 -> System.out.println("Your membership payment of $" + premiumPayment + " will be due in March");
            case 3 -> System.out.println("Your membership payment of $" + premiumPayment + " will be due in April");
            case 4 -> System.out.println("Your membership payment of $" + premiumPayment + " will be due in May");
            case 5 -> System.out.println("Your membership payment of $" + premiumPayment + " will be due in June");
            case 6 -> System.out.println("Your membership payment of $" + premiumPayment + " will be due in July");
            case 7 -> System.out.println("Your membership payment of $" + premiumPayment + " will be due in August");
            case 8 -> System.out.println("Your membership payment of $" + premiumPayment + " will be due in September");
            case 9 -> System.out.println("Your membership payment of $" + premiumPayment + " will be due in October");
            case 10 -> System.out.println("Your membership payment of $" + premiumPayment + " will be due in November");
            case 11 -> System.out.println("Your membership payment of $" + premiumPayment + " will be due in December");
            case 12 -> System.out.println("Your membership payment of $" + premiumPayment + " will be due in January");
            default -> System.out.println("Error");
        }
    }
}
