package ex42;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        ArrayList<String> lineList = readLines("./src/main/java/ex42/exercise42_input.txt");
        printFormatted(lineList);
    }

    public static ArrayList<String> readLines(String fileName)
    {
        ArrayList<String> namesList = new ArrayList<String>();

        try
        {
            File readFile = new File(fileName);
            Scanner scanner = new Scanner(readFile);

            while(scanner.hasNextLine())
            {
                namesList.add(scanner.nextLine());
            }
            scanner.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return namesList;
    }

    public static void printFormatted(ArrayList<String> namesList)
    {
        String[] separated = new String[3];

        System.out.printf("Last\tFirst\t\tSalary\n--------------------------\n", namesList.size());
        for(int i = 0; i < namesList.size(); i++)
        {
            separated = namesList.get(i).split(",");

            if(separated[0].length() > 7)
                System.out.printf("%s\t", separated[0]);
            else
                System.out.printf("%s\t\t", separated[0]);

            if(separated[1].length() > 7)
                System.out.printf("%s\t",separated[1]);
            else if(separated[1].length() > 3)
                System.out.printf("%s\t\t",separated[1]);
            else
                System.out.printf("%s\t\t\t", separated[1]);

            System.out.printf("%s\n", separated[2]);
        }
    }
}
