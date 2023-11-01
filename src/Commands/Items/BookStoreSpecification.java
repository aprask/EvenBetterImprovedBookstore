package Commands.Items;
public interface BookStoreSpecification
{
    public void restockProduct(int itemType, int amount);
    public double inventoryValue();
}
