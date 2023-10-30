package Commands.Items;
public interface BookStoreSpecification
{
    public void restockProduct(int productID, int amount, int itemType);
    public double inventoryValue();
}
