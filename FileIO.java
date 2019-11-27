import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class to read file content and write content into a file.
 *
 * @author (Xujie Yuan)
 * @version (9 Oct 2019)
 */
public class FileIO
{
    private String fileName;

    /**
     * default constructor
     */
    public FileIO()
    {
        fileName = "./src/multiples.txt";
    }

    /**
     * non-default constructor
     */
    public FileIO(String newFileName)
    {
        fileName = newFileName;
    }

    /**
     * Accessor Method
     */
    public String getFileName()
    {
        return fileName;
    }

    /**
     * Mutator Method
     */
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    /**
     * Method to calculate how many lines are in the file
     *
     * @return
     */
    public int countLines()
    {
        int linesNumber = 0;
        try
        {
            FileReader fileReader = new FileReader(fileName);
            try
            {
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while ((bufferedReader.readLine()) != null)
                {
                    linesNumber++;
                }
            }
            finally
            {
                fileReader.close();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(fileName + " not found when counting lines");
        }
        catch (IOException e)
        {
            System.out.println("Unexpected I/O error occured");
        }
        return linesNumber;
    }

    /**
     * Method to read file content
     *
     * @return
     */
    public ArrayList<String> readFileByLines()
    {
        ArrayList<String> multiples = new ArrayList<String>();
        try
        {
            FileReader fileReader = new FileReader(fileName);
            try
            {
                Scanner parser = new Scanner(fileReader);
                while (parser.hasNextLine())
                {
                    multiples.add(parser.nextLine());
                }
            }
            finally
            {
                fileReader.close();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(fileName + " not found when reading file");
            System.exit(0);
        }
        catch (IOException e)
        {
            System.out.println("Unexpected I/O error occured");
        }
        return multiples;
    }

    /**
     * Method to write the result into a file
     *
     * @param playerName
     * @param highestScore
     * @param maxGameTotal
     */
    public void writeToFile(String playerName, int highestScore, int maxGameTotal)
    {
        String content = "";
        try
        {
            if (highestScore >= maxGameTotal)
            {
                content = playerName + " has won the game, with the highest achieved score of " + highestScore;
            }
            else
            {
                content = playerName + " has not achieved the requested score of " + maxGameTotal + ". The highest achieved score is " + highestScore;
            }
            File file = new File(fileName);
            if (!file.exists())
            {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(fileName);
            pw.println(content);
            pw.close();
        }
        catch (IOException e)
        {
            System.out.println("Unable to save to " + fileName);
        }
    }
}
