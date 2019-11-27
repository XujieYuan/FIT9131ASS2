
/**
 * A class to create a random number.
 *
 * @author (Xujie Yuan)
 * @version (26 SEP 2019)
 */
public class RNG
{
    private int maximumValue;
    private int minimumValue;

    /**
     * Constructor for objects of class RNG
     */
    public RNG()
    {
        maximumValue = 0;
        minimumValue = 0;
    }

    /**
     * non-default constructor
     */
    public RNG(int newMaximumValue, int newMinimumValue)
    {
        maximumValue = newMaximumValue;
        minimumValue = newMinimumValue;
    }

    /**
     * Accessor Methods
     */
    public int getMaximumValue()
    {
        return maximumValue;
    }

    public int getMinimumValue()
    {
        return minimumValue;
    }

    /**
     * Mutator Methods
     */
    public void setMaximumValue(int newMaximumValue)
    {
        maximumValue = newMaximumValue;
    }

    public void setMinimumValue(int newMinimumValue)
    {
        minimumValue = newMinimumValue;
    }

    /**
     * Method to get a random number
     *
     * @return
     */
    public int getRandomNumber()
    {
        return minimumValue + (int) (Math.random() * (maximumValue - minimumValue + 1));
    }

    public void checkRandomNumber()//check whether the method getRandomNumber work well
    {
        for (int i = 0; i < 20; i++)
        {
            int turn = getRandomNumber();
            System.out.println(turn);

        }
    }
}
