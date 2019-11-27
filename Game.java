import java.util.ArrayList;

/**
 * The main game class.
 *
 * @author (Xujie Yuan)
 * @version (16 OCT 2019)
 */
public class Game
{
    private String playerName;
    private int gameTotal;
    private ArrayList<Buffer> multipleList;

    /**
     * default constructor
     */
    public Game()
    {
        playerName = "";
        gameTotal = 0;
        multipleList = new ArrayList<Buffer>();
    }

    /**
     * non-default constructor
     */
    public Game(String newName, int newGameTotal, ArrayList<Buffer> newMultipleList)
    {
        playerName = newName;
        gameTotal = newGameTotal;
        multipleList = newMultipleList;
    }

    /**
     * Accessor Methods
     */
    public ArrayList<Buffer> getMultipleList()
    {
        return multipleList;
    }

    public int getGameTotal()
    {
        return gameTotal;
    }

    public String getName()
    {
        return playerName;
    }

    /**
     * Mutator Methods
     */
    public void setMultipleList(ArrayList<Buffer> multipleList)
    {
        this.multipleList = multipleList;
    }

    public void setGameTotal(int gameTotal)
    {
        this.gameTotal = gameTotal;
    }

    public void setName(String name)
    {
        this.playerName = name;
    }

    /**
     * Method to check whether the buffer is full
     *
     * @return
     */
    public boolean checkFull(Buffer b1, Buffer b2)
    {
        boolean full = false;
        if (b1.getList().size() == b1.getMaxElements() && b2.getList().size() == b2.getMaxElements())
        {
            boolean b1Mergable = true;
            boolean b2Mergable = true;
            if (checkMerge(b1))
            {
                System.out.println("*****Still can Merge Left*****");
                System.out.println();
            }
            else
            {
                b1Mergable = false;
            }
            if (checkMerge(b2))
            {
                System.out.println("*****Still can Merge Right*****");
                System.out.println();
            }
            else
            {
                b2Mergable = false;
            }
            if (b1Mergable == false && b2Mergable == false)
            {
                full = true;
            }
        }
        return full;
    }

    /**
     * Method to check whether the two numbers can be merged
     *
     * @param buffer
     * @return
     */
    public boolean checkMerge(Buffer buffer)
    {
        boolean canMerge = false;
        for (int i = 0; i < buffer.getList().size(); i++)
        {
            if (gameTotal == buffer.getList().get(i).getValue())
            {
                canMerge = true;
            }
        }
        return canMerge;
    }

    /**
     * Method to check whether player had already achieved the request score
     *
     * @param maxGameTotal
     * @return
     */
    public boolean checkOver(int maxGameTotal)
    {
        boolean over = false;
        if (gameTotal >= maxGameTotal)
        {
            over = true;
        }
        return over;
    }

    /**
     * Method to display the result after an action
     */
    public void display(Buffer b1, Buffer b2)
    {
        System.out.print("Left buffer");
        b1.displayBuffer("b1");
        System.out.println("Game Total");
        System.out.println("|" + gameTotal + "|");
        System.out.println();
        System.out.print("Right buffer");
        b2.displayBuffer("b2");
    }

    /**
     * Method to display the help menu
     */
    public void displayHelpMenu()
    {
        System.out.println("**********Help Menu**********");
        System.out.println();
        System.out.println("The game begins with the program reading the allowed multiples from a file called “multiples.txt”.");
        System.out.println("The file will only contain MANY sets of mutliples.The user can choose which multiple they would like to use when playing the game.");
        System.out.println("These are the three numbers which will be randomly provided to the user during the game.");
        System.out.println("The game will operate using TWO arraylist as buffers instead of a grid.");
        System.out.println("The maximum number of elements which can be stored in the first arraylist is 5.");
        System.out.println("The maximum number of elements which can be stored in the second arraylist is 3.");
        System.out.println("The game also allows the user to set the game total up to which the game will be played.");
    }

    /**
     * Method to display the main menu
     */
    public void displayMainMenu()
    {
        System.out.println();
        System.out.println("******************************");
        System.out.println("Press 1 to register the player");
        System.out.println("Press 2 to start the game");
        System.out.println("Press 3 to view the help menu");
        System.out.println("Press 4 to exit");
        System.out.println("******************************");
        System.out.println();
    }

    /**
     * Method to get the highest score player had achieved
     *
     * @param maxGameTotal
     * @return
     */
    public int getHighestScore(int maxGameTotal, Buffer b1, Buffer b2)
    {
        int highestScore = 0;
        int h1 = 0;
        int h2 = 0;
        boolean full = checkFull(b1, b2);
        boolean over = checkOver(maxGameTotal);
        if (full)
        {
            for (int i = 0; i < b1.getList().size(); i++)
            {
                if (h1 < b1.getList().get(i).getValue())
                    h1 = b1.getList().get(i).getValue();
            }
            for (int i = 0; i < b2.getList().size(); i++)
            {
                if (h2 < b2.getList().get(i).getValue())
                    h2 = b2.getList().get(i).getValue();
            }
            if (h1 > h2)
                highestScore = h1;
            else
                highestScore = h2;
        }
        if (over)
        {
            highestScore = gameTotal;
        }
        return highestScore;
    }

    /**
     * Method to initialize the multiple list
     */
    public void initMultipleList(Buffer b1, Buffer b2)
    {
        b1.setMaxElements(5);
        b2.setMaxElements(3);
    }

    /**
     * Method to do the merge action
     *
     * @param buffer
     */
    public void merge(Buffer buffer)
    {
        for (int i = 0; i < buffer.getList().size(); i++)
        {
            if (gameTotal == buffer.getList().get(i).getValue())
            {
                gameTotal += gameTotal;
                buffer.getList().remove(i);
                break;
            }
        }
    }

    /**
     * Method to merge the matching number from the left buffer
     */
    public void mergeLeft(Buffer b1)
    {
        boolean mergable = checkMerge(b1);
        if (mergable == true)
        {
            merge(b1);
        }
        else
        {
            System.out.println("*****Not Matching, Cannot Merge*****");
        }
    }

    /**
     * Method to merge the matching number from the right buffer
     */
    public void mergeRight(Buffer b2)
    {
        boolean mergable = checkMerge(b2);
        if (mergable == true)
        {
            merge(b2);
        }
        else
        {
            System.out.println("*****Not Matching, Cannot Merge*****");
        }
    }


    /**
     * Method to register a new player
     */
    public void register()
    {
        String prompt = "Please enter player name!";
        Input input = new Input();
        playerName = input.acceptUserInput(prompt);
        Validation validation = new Validation(10, 3);
        while (validation.stringWithinRange(playerName) == false)
        {
            prompt = "Your name should between 3-10, please enter again!";
            playerName = input.acceptUserInput(prompt);
        }
    }

    /**
     * Method for user to choose actions split, merge or go back to main menu
     *
     * @return
     */
    public String requestAction()
    {
        Input input = new Input();
        String prompt = "Please select an action";
        System.out.println("Press 1 to Split Right -->");
        System.out.println("Press 2 to Merge Right <--<--");
        System.out.println("Press 3 to Split Left <--");
        System.out.println("Press 4 to Merge Left -->-->");
        System.out.println("Press 5 to go back to the main menu");
        String action = input.acceptUserInput(prompt);
        return action;
    }

    /**
     * Method to accept user input for game total
     *
     * @return
     */
    public int requestMaxGameTotal()
    {
        String prompt = "Please enter the total of the game!";
        Input input = new Input();
        boolean isNumber = false;
        int maxGameTotal = 0;
        while (isNumber == false)
        {
            try
            {
                maxGameTotal = Integer.parseInt(input.acceptUserInput(prompt));
                while (maxGameTotal < 33 || maxGameTotal % 8 != 0)
                {
                    prompt = "Game total must larger than 32 and should be the multiple of 8";
                    maxGameTotal = Integer.parseInt(input.acceptUserInput(prompt));
                }
                isNumber = true;
            }
            catch (Exception e)
            {
                prompt = "Game total must be number";
            }
        }
        return maxGameTotal;
    }

    /**
     * Method to do selection in main menu
     */
    public void selectMenu(Buffer b1, Buffer b2)
    {
        String prompt = "Please select from these options";
        displayMainMenu();
        Input input = new Input();
        String option = input.acceptUserInput(prompt);
        switch (option)
        {
            case "1":
                register();
                selectMenu(b1, b2);
                break;
            case "2":
                while (!playerName.equals(""))
                {
                    int maxGameTotal = requestMaxGameTotal();
                    int multiple = selectMultiples();
                    startGame(multiple, maxGameTotal, b1, b2);
                    playerName = "";
                    b1.getList().clear();
                    b2.getList().clear();
                    selectMenu(b1, b2);
                }
                System.out.println("Please register before start game!");
                System.out.println();
                selectMenu(b1, b2);
                break;
            case "3":
                displayHelpMenu();
                selectMenu(b1, b2);
                break;
            case "4":
                System.out.println("*****Exit*****");
                System.exit(0);
                break;
            case "5":
                saveMultiples();
                break;
            default:
                System.out.println("Invalid option, please choose again!");
                selectMenu(b1, b2);
                break;
        }
    }

    /**
     * Method to choose which multiples will be used in the game
     *
     * @return
     */
    public int selectMultiples()
    {
        int multiple = 0;
        String prompt = "Please select multiples!";
        FileIO fileIO = new FileIO("./src/multiples.txt");
        ArrayList<String> fileContent = fileIO.readFileByLines();
        int linesNumber = fileIO.countLines();
        for (int i = 0; i < fileContent.size(); i++)
        {
            System.out.println("Press " + (i + 1) + " to select the multiples " + fileContent.get(i));
        }
        Input input = new Input();
        int choice = 0;
        boolean isNumber = false;
        while (isNumber == false)
        {
            try
            {
                choice = Integer.parseInt(input.acceptUserInput(prompt));
                while (choice < 1 || choice > linesNumber)
                {
                    prompt = "Your choice must between 1-" + linesNumber + ", please select again!";
                    choice = Integer.parseInt(input.acceptUserInput(prompt));
                }
                isNumber = true;
            }
            catch (Exception e)
            {
                prompt = "You must select multiples before start game";
            }
        }
        String multiples = fileContent.get(choice - 1);
        System.out.println("You choose " + multiples);
        try
        {
            multiple = Integer.parseInt(multiples.split(",")[0]);
        }
        catch (Exception e)
        {
            System.out.println("First element in the file is not a number");
        }
        return multiple;
    }

    /**
     * Method to start the program
     */
    public void start()
    {
        Buffer b1 = new Buffer();
        Buffer b2 = new Buffer();
        selectMenu(b1, b2);
    }

    /**
     * Method to start the game
     *
     * @param multiple
     * @param maxGameTotal
     */
    public void startGame(int multiple, int maxGameTotal, Buffer b1, Buffer b2)
    {
        RNG rng = new RNG(3, 1);
        int randomPower = rng.getRandomNumber();
        gameTotal = (int) Math.pow(multiple, randomPower);
        initMultipleList(b1, b2);
        display(b1, b2);
        boolean full = false;
        boolean over = false;
        String action = "";
        while (!full && !over)
        {
            action = requestAction();
            switch (action)
            {
                case "1":
                    splitRight(multiple, b2);
                    display(b1, b2);
                    break;
                case "2":
                    mergeRight(b2);
                    display(b1, b2);
                    break;
                case "3":
                    splitLeft(multiple, b1);
                    display(b1, b2);
                    break;
                case "4":
                    mergeLeft(b1);
                    display(b1, b2);
                    break;
                case "5":
                    b1.getList().clear();
                    b2.getList().clear();
                    selectMenu(b1, b2);
                    break;
                default:
                    System.out.println("You must select from 1 - 5");
                    display(b1, b2);
            }
            full = checkFull(b1, b2);
            over = checkOver(maxGameTotal);
        }
        if (full)
        {
            System.out.println("******************************");
            System.out.println("b1 and b2 are full and cannot be merged! GAME OVER!");
        }
        if (over)
        {
            System.out.println("******************************");
            System.out.println("Congratulations! You already achieved " + maxGameTotal);
        }
        int highestScore = getHighestScore(maxGameTotal, b1, b2);
        FileIO fileIO = new FileIO("outcome.txt");
        fileIO.writeToFile(playerName, highestScore, maxGameTotal);
    }

    /**
     * Method to split the game total to the left buffer
     *
     * @param multiple
     */
    public void splitLeft(int multiple, Buffer b1)
    {
        if (b1.getList().size() <= 4)
        {
            b1.addToList(gameTotal);
            RNG rng = new RNG(3, 1);
            int randomPower = rng.getRandomNumber();
            gameTotal = (int) Math.pow(multiple, randomPower);
        }
        else
        {
            System.out.println("*****Cannot Split Left*****");
        }
    }

    /**
     * Method to split the game total to the right buffer
     *
     * @param multiple
     */
    public void splitRight(int multiple, Buffer b2)
    {
        if (b2.getList().size() < 3)
        {
            b2.addToList(gameTotal);
            RNG rng = new RNG(3, 1);
            int randomPower = rng.getRandomNumber();
            gameTotal = (int) Math.pow(multiple, randomPower);
        }
        else
        {
            System.out.println("*****Cannot Split Right*****");
        }
    }

    /**
     * Method to save choosed multiples into ArrayList multiple list
     */
    public void saveMultiples()
    {
        System.out.println();
        System.out.println("This is only a test!");
        Buffer buffer = new Buffer();
        FileIO fileIO = new FileIO();
        ArrayList<String> multiple = fileIO.readFileByLines();
        System.out.println(multiple);
        int value = 0;
        for (int i = 0; i < multiple.size(); i++)
        {
            String[] multiples = multiple.get(i).split(",");
            for (int j = 0; j < multiples.length; j++)
            {
                value = Integer.parseInt(multiples[j]);
                //Multiple m = new Multiple();
                //m.setValue(value);
                //buffer.getList().add(m);
                buffer.addToList(value);
                multipleList.add(buffer);
            }
        }
        for (int n = 0; n < multipleList.size(); n++)
        {
            System.out.print(multipleList.get(n).getList().get(n).getValue());
        }
        System.out.println();
    }
}
