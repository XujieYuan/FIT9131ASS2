import java.util.Scanner;

/**
 * This is a class to accept user input.
 *
 * @author (Xujie Yuan)
 * @version (9 Oct 2019)
 */
public class Input
{
    /**
     * Method to accept user string input
     *
     * @param prompt
     * @return
     */
    public String acceptUserInput(String prompt)
    {
        System.out.println(prompt);
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        return input;
    }
}
