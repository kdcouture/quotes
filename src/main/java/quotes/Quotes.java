package quotes;

import java.io.*;
import java.util.Scanner;
import com.google.gson.Gson;

public class Quotes
{

    public String[] tags;
    public String author;
    public String likes;
    public String text;

    public Quotes(String[] tags, String author, String likes, String text)
    {
        this.tags = tags;
        this.author = author;
        this.likes = likes;
        this.text = text;
    }

    public static String readFromFile() throws Exception
    {
        Gson gson = new Gson();


        Scanner reader = new Scanner(new File("./src/main/resources/recentquotes.json"));
        String dataString = reader.nextLine();
        System.out.println(dataString);



        StringBuilder stringBuilder = new StringBuilder();

        reader.nextLine();

        Quotes randomQuoteFromFile = null;

        while (reader.hasNext())
        {
            String temporary = reader.nextLine();
            if (temporary.trim().equals(" },"))
            {
                stringBuilder.append("}");
                System.out.println(stringBuilder.toString());
                randomQuoteFromFile = gson.fromJson(stringBuilder.toString(), Quotes.class);
            }
            System.out.println(stringBuilder.toString());

        }

        System.out.println(randomQuoteFromFile);

        try
        {

        }
        catch (Exception error)
        {
            System.err.println(error);
        }



        return "";
    }



}
