package ex45;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Cameron McDougal
 */

import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;

public class AppTest
{
    @Test
    public void isFileCorrect()
    {
        // load up file and compare the string with a manually correct one
        StringBuilder sb = new StringBuilder();
        String answer = "One should never use the word \"use\" in writing. Use \"use\" instead.For example, \"She uses an IDE to write her Java programs\" instead of \"She uses an IDE to write her Java programs\".";

        File outputFile = new File("./src/main/java/ex45/exercise45_output.txt");
        try
        {
            Scanner scanner = new Scanner(outputFile);

            while(scanner.hasNextLine())
                sb.append(scanner.nextLine() + ' ');
            scanner.close();
            // Removing the extra space when reading file
            sb.deleteCharAt(sb.length() - 1);

            System.out.printf("%s\n%s", sb.toString(), answer);
            assertEquals(true, answer.equals(sb.toString()));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
