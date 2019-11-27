
/**
 * A class to check the input range.
 *
 * @author (Xujie Yuan)
 * @version (9 Oct 2019)
 */
public class Validation
{
    private int max;
    private int min;

    /**
     * default constructor
     */
    public Validation()
    {
        max = 0;
        min = 0;
    }

    /**
     * non-default constructor
     */
    public Validation(int newMax, int newMin)
    {
        max = newMax;
        min = newMin;
    }

    /**
     * Accessor Methods
     */
    public int getMax()
    {
        return max;
    }

    public int getMin()
    {
        return min;
    }

    /**
     * Mutator Methods
     */
    public void setMax(int max)
    {
        this.max = max;
    }

    public void setMin(int min)
    {
        this.min = min;
    }

    /**
     * Method to validate the input range
     *
     * @param str
     * @return true or false
     */
    public boolean stringWithinRange(String str)
    {
        if (str.trim().length() >= min && str.trim().length() <= max)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
