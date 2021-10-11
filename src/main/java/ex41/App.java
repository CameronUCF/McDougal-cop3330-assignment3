package ex41;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Cameron McDougal
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        ArrayList<String> namesList = readNames("./src/main/java/ex41/exercise41_input.txt");
        Collections.sort(namesList);
        printNames(namesList);
    }

    public static ArrayList<String> readNames(String fileName)
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

    public static void printNames(ArrayList<String> namesList)
    {
        System.out.printf("Total of %d names\n-----------------\n", namesList.size());

        for(int i = 0; i < namesList.size(); i++)
        {
            System.out.printf("%s\n", namesList.get(i));
        }
    }
}
