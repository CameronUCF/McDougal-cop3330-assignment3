package ex44;

import com.google.gson.Gson;

import javax.tools.Diagnostic;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        int index = -1;
        boolean found = false;
        Scanner scanner = new Scanner(System.in);
        ProductList products = LoadJSON("./src/main/java/ex44/exercise44_input.json");


        while (index == -1)
        {
            System.out.println("What is the product name?");
            index = IsFound(products, scanner.nextLine());
            if(index == -1)
                System.out.println("Sorry, that product was not found in our inventory.");
        }

        System.out.printf("Name: %s\nPrice: %.2f\nQuantity: %d", products.products[index].name, products.products[index].price, products.products[index].quantity);
    }

    public static ProductList LoadJSON(String filePath)
    {
        Gson gson = new Gson();
        ProductList products;

        try(Reader reader = new FileReader(filePath))
        {
            products = gson.fromJson(reader, ProductList.class);
            return products;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public static int IsFound(ProductList proList, String query)
    {
        for(int i = 0; i < proList.products.length; i++)
            if(proList.products[i].name.equalsIgnoreCase(query))
                return i;
        return -1;
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