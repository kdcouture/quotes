/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

public class App {

    public static void main(String[] args)
    {
        String path = "./src/main/resources/recentquotes.json";
        String url = "https://ron-swanson-quotes.herokuapp.com/v2/quotes";
        try
        {
//            System.out.println(Quotes.readFromFile(path));
            System.out.println(Quotes.readFromInternet(url, path));

        }
        catch (Exception error)
        {
            System.err.println(error);
        }

    }
}
