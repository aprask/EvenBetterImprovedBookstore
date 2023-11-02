package Commands.Items;
public interface Comparable
{
    public boolean compareTo(Item item);
}


/*
TODO
   DESIGN:
        2) Save the previous purchase into a variable called possibleCompare
        3) If the user wants to compare, ask for the type and ID, and find the object based on that
 */