package ex46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class App
{
    public static void main( String[] args )
    {
        StringBuilder sb = new StringBuilder();
        File file = new File("./src/main/java/ex46/exercise46_input.txt");

        try
        {
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine())
                sb.append(scanner.nextLine() + ' ');
            scanner.close();

            System.out.println(sb);

            Map<String, Integer> freq = FindFrequency(sb.toString());

            PrintMap(freq);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static Map<String, Integer> FindFrequency(String str)
    {
        Map<String, Integer> freq = new TreeMap<>();
        String[] words = str.split(" ");

        for(int i = 0; i < words.length; i++)
        {
            if(freq.containsKey(words[i]))
                freq.put(words[i], freq.get(words[i])+1);
            else
                freq.put(words[i], 1);
        }

        return freq;
    }

    public static void PrintMap(Map<String, Integer> freq)
    {
        for(Map.Entry<String, Integer> entry : freq.entrySet())
        {
            System.out.printf("%s:\t", entry.getKey());
            for(int i = 0; i < entry.getValue(); i++)
                System.out.print("*");
            System.out.print("\n");
        }
    }
}
