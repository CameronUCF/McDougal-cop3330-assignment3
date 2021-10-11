package ex43;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Cameron McDougal
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        String siteName;
        String author;
        boolean jsFolder = false;
        boolean cssFolder = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Site Name:");
        siteName = scanner.nextLine();

        System.out.println("Author:");
        author = scanner.nextLine();

        System.out.println("Do you want a folder for JavaScript?");
        if(scanner.nextLine().toLowerCase().charAt(0) == 'y')
            jsFolder = true;

        System.out.println("Do you want a folder for CSS?");
        if(scanner.nextLine().toLowerCase().charAt(0) == 'y')
            cssFolder = true;

        generateWebsite(siteName, author, jsFolder, cssFolder);
    }

    public static void generateWebsite(String siteName, String author, boolean jsFolder, boolean cssFolder)
    {
        File websiteDir = new File("./src/main/java/ex43/website/" + siteName);
        if(!websiteDir.exists())
            websiteDir.mkdirs();

        System.out.printf("Created ./website/%s\n", siteName);

        // Index.html
        try
        {
            FileWriter index = new FileWriter("./src/main/java/ex43/website/" + siteName + "/index.html");
            index.write("<title>" + siteName + "</title>\n" + "<meta name=\"author\" content=\"" + author + "\">");
            index.close();
            System.out.printf("Created ./website/%s/index.html\n", siteName);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        if(jsFolder)
        {
            File jsDir = new File("./src/main/java/ex43/website/" + siteName + "/js");
            if(!jsDir.exists())
                jsDir.mkdirs();

            System.out.printf("Created ./website/%s/js\n", siteName);
        }

        if(cssFolder)
        {
            File cssDir = new File("./src/main/java/ex43/website/" + siteName + "/css");
            if(!cssDir.exists())
                cssDir.mkdirs();

            System.out.printf("Created ./website/%s/css\n", siteName);
        }
    }
}
