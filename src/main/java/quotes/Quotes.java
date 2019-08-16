package quotes;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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

    public Quotes(String quote, String author) {
        this.tags = null;
        this.author = author;
        this.likes = null;
        this.text = quote;
    }

    public static Quotes readFromFile(String path) throws Exception
    {
        Gson gson = new Gson();

        BufferedReader file = new BufferedReader(new FileReader(path));
        Quotes[] quotesFromFiles = gson.fromJson(file, Quotes[].class);

        int randomIndex = (int)(Math.random() * quotesFromFiles.length);
        Quotes randomQuote = quotesFromFiles[randomIndex];

        return randomQuote;
    }

    // Following along with https://www.baeldung.com/java-http-request
    public static Quotes readFromInternet(String inURL, String backup) {
        Gson gson = new Gson();
        Quotes quote = null;
        // https://www.baeldung.com/java-http-request
        try {
            URL url = new URL(inURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            System.out.println(con.getResponseCode());

            BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            String contentStr = content.toString().replaceAll("]$|^\\[","");
            quote = new Quotes(contentStr, "Ron Swanson");

            upDateFile(backup, quote);

            in.close();

            con.disconnect();
        }
        catch (Exception e) {
            try {
                quote = readFromFile(backup);
            }
            catch (Exception f) {
                System.err.println(f);
            }
        }
        return quote;
    }

    public static void upDateFile(String path, Quotes toAdd) throws Exception
    {
        Gson gson = new Gson();

        BufferedReader file = new BufferedReader(new FileReader(path));

        TypeToken<ArrayList<Quotes>> token = new TypeToken<ArrayList<Quotes>>(){};
        ArrayList<Quotes> quotesFromFiles = gson.fromJson(file, token.getType());

        quotesFromFiles.add(toAdd);

        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(gson.toJson(quotesFromFiles));

        writer.close();
        file.close();

    }

    @Override
    public String toString()
    {
        String outputMessage = this.text + " - " + this.author;

        return outputMessage;
    }

    public static int getRonQuoteStatus(String inURL) {
        int statusCode = -1;
        try {
            URL url = new URL(inURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            statusCode = con.getResponseCode();
        }
        catch (Exception e) {
            System.err.println(e);
        }
        return statusCode;
    }
}
