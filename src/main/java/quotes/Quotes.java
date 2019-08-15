package quotes;

import java.io.*;
import java.util.Arrays;
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

    public static String readFromFile(String path) throws Exception
    {
        Gson gson = new Gson();

        BufferedReader file = new BufferedReader(new FileReader(path));
        Quotes[] quotesFromFiles = gson.fromJson(file, Quotes[].class);

        int randomIndex = (int)(Math.random() * quotesFromFiles.length);
        String randomQuote = quotesFromFiles[randomIndex].toString();

        return randomQuote;
    }

    @Override
    public String toString()
    {
        String outputMessage = this.text + this.author;

        return outputMessage;
    }


}
