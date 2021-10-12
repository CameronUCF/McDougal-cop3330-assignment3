package ex43;
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
    public void fileCheck()
    {
        String siteName = "Test Name";
        String author = "Test Author";
        StringBuilder sb = new StringBuilder();
        String indexTest = "<title>" + siteName + "</title>" + "<meta name=\"author\" content=\"" + author + "\">";

        // Generating file and folders
        App.generateWebsite(siteName, author, true, true);

        // Checking folders
        File websiteDir = new File("./src/main/java/ex43/website/" + siteName);
        assertEquals(true, websiteDir.exists());

        File jsDir = new File("./src/main/java/ex43/website/" + siteName + "/js");
        assertEquals(true, jsDir.exists());

        File cssDir = new File("./src/main/java/ex43/website/" + siteName + "/css");
        assertEquals(true, cssDir.exists());

        // Checking index.html
        try
        {
            Scanner scanner = new Scanner(new File("./src/main/java/ex43/website/" + siteName + "/index.html"));

            while(scanner.hasNextLine())
                sb.append(scanner.nextLine());
            scanner.close();

            assertEquals(true, indexTest.equalsIgnoreCase(sb.toString()));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
