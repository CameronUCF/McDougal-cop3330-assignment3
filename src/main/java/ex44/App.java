package ex44;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class App
{
    public static void main( String[] args )
    {
        Gson gson = new Gson();
        try
        {
            JsonReader reader = new JsonReader(new FileReader("./src/main/java/ex44/exercise44_input.json"));
            JsonElement jsonElement = new Gson().fromJson(reader, JsonElement.class);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        /*try
        {
            Product product = gson.fromJson(new FileReader("./src/main/java/ex44/exercise44_input.json"), Product.class);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }*/
    }
}

class Product
{
    private String name;
    private float price;
    private int quantity;

    public Product(String name, float price, int quantity)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}