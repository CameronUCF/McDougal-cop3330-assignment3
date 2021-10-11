package ex45;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Cameron McDougal
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App
{
    public static void main( String[] args )
    {
        StringBuilder sb = new StringBuilder();
        File file = new File("./src/main/java/ex45/exercise45_input.txt");

        try
        {
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine())
                sb.append(scanner.nextLine() + ' ');
            scanner.close();

            String replaced = Pattern.compile("utilize").matcher(sb).replaceAll("use");
            System.out.println(replaced);

            WriteFile(replaced, "./src/main/java/ex45/exercise45_output.txt");
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    public static void WriteFile(String str, String fileName)
    {
        try
        {
            FileWriter writer = new FileWriter(fileName);
            writer.write(str);
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
