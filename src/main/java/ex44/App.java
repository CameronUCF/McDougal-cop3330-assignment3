package ex44;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class App
{
    public static void main( String[] args )
    {
        Gson gson = new Gson();
        try(Reader reader = new FileReader("./src/main/java/ex44/exercise44_input.json"))
        {
            ProductList products = gson.fromJson(reader, ProductList.class);
            System.out.println(products.products[0].name);
        }
        catch (IOException e)
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
    String name;
    float price;
    int quantity;
}

class ProductList
{
    Product[] products;
}