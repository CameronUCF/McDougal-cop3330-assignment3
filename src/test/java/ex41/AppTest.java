package ex41;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class AppTest
{
    @Test
    public void isListSorted()
    {
        // Unsorted list
        ArrayList<String> namesList = App.readNames("./src/main/java/ex41/exercise41_input.txt");
        // Manually Sorted list
        ArrayList<String> sortedList = new ArrayList<String>(Arrays.asList("Johnson, Jim", "Jones, Aaron", "Jones, Chris", "Ling, Mai", "Swift, Geoffrey", "Xiong, Fong", "Zarnecki, Sabrina"));

        assertEquals(sortedList, namesList);
    }
}
