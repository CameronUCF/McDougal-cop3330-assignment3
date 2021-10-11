package ex46;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static org.junit.Assert.assertTrue;

public class AppTest
{
    @Test
    public void TestFreq()
    {
        // Test frequency map with a manually created map
        Map<String, Integer> manualFreq = new TreeMap<>();

        manualFreq.put("badger", 7);
        manualFreq.put("mushroom", 2);
        manualFreq.put("snake", 1);

        // Using app to generate map
        StringBuilder sb = new StringBuilder();
        File file = new File("./src/main/java/ex46/exercise46_input.txt");
        try
        {
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine())
                sb.append(scanner.nextLine() + ' ');
            scanner.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        Map<String, Integer> appFreq = App.FindFrequency(sb.toString());

        assertTrue(manualFreq.equals(appFreq));
    }
}
