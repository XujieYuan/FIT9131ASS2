
/**
 * A class to save multiples which can be used in the game.
 *
 * @author (Xujie Yuan)
 * @version (26 SEP 2019)
 */
public class Multiple
{
    private int value;

    public Multiple()
    {
        value = 0;
    }

    public Multiple(int newValue)
    {
        value = newValue;
    }

    /**
     * Accessor Method
     *
     * @return
     */
    public int getValue()
    {
        return value;
    }

    /**
     * Mutator Method
     *
     * @param value
     */
    public void setValue(int value)
    {
        this.value = value;
    }
}
