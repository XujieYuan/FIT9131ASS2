import java.util.ArrayList;

/**
 * A class to show those multiples which stored in buffers and played in the game.
 *
 * @author (Xujie Yuan)
 * @version (16 OCT 2019)
 */
public class Buffer
{
    private ArrayList<Multiple> list;
    private int maxElements;

    /**
     * default constructor
     */
    public Buffer()
    {
        list = new ArrayList<Multiple>();
        maxElements = 0;
    }

    /**
     * non-default constructor
     */
    public Buffer(int newMaxElements, ArrayList<Multiple> newList)
    {
        maxElements = newMaxElements;
        list = newList;
    }

    /**
     * Accessor Methods
     */
    public ArrayList<Multiple> getList()
    {
        return list;
    }

    public int getMaxElements()
    {
        return maxElements;
    }

    /**
     * Mutator Methods
     */
    public void setList(ArrayList<Multiple> list)
    {
        this.list = list;
    }

    public void setMaxElements(int maxElements)
    {
        this.maxElements = maxElements;
    }

    public void addToList(int value)
    {
        Multiple multiple = new Multiple();
        multiple.setValue(value);
        list.add(multiple);
    }

    /**
     * Method to display those two buffers in the game
     *
     * @param bufferName
     */
    public void displayBuffer(String bufferName)
    {

        System.out.println();
        System.out.print(bufferName + "  ");
        System.out.print("|");
        for (int i = 0; i < list.size(); i++)
        {
            System.out.print(list.get(i).getValue() + "|");
        }
        for (int i = 0; i < maxElements - list.size(); i++)
        {
            System.out.print(" |");
        }
        System.out.println();

        System.out.println();
    }
}
