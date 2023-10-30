package Commands.Items.Factory;

public enum ItemType
{
    CD(1),
    BOOK(2),
    DVD(3);
    final int ID;
    ItemType(int ID){
        this.ID = ID;
    }
}