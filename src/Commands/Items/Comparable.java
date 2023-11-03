package Commands.Items;
public interface Comparable
{
    /**
     *
     * @param item retrieve an Item object to compare via price
     * @return whether the compared item is greater than or less than the parent
     */
    public boolean compareTo(Item item);
}