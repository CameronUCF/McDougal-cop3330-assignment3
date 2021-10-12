package ex44;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Cameron McDougal
 */

import org.junit.Test;
import static ex44.App.LoadJSON;
import static org.junit.Assert.assertTrue;

public class AppTest
{
    @Test
    public void isFound()
    {
        ProductList products = LoadJSON("./src/main/java/ex44/exercise44_input.json");
        if(App.IsFound(products, "widget") > -1)
            assertTrue(true);
        else if(App.IsFound(products, "tHiNg") > -1)
            assertTrue(true);
        else if(App.IsFound(products, "Doodad") > -1)
            assertTrue(true);
        else
        {
            assertTrue(false);
        }
    }

    @Test
    public void isNotFound()
    {
        ProductList products = LoadJSON("./src/main/java/ex44/exercise44_input.json");
        if(App.IsFound(products, "Not found") == -1)
            assertTrue(true);
        else if(App.IsFound(products, "Nothing") == -1)
            assertTrue(true);
        else if(App.IsFound(products, "Doodad1") == -1)
            assertTrue(true);
        else
            assertTrue(false);
    }
}
