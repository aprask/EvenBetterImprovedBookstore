package Commands;

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
