/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

public class App {

    public static void main(String[] args)
    {
        String path = "./src/main/resources/recentquotes.json";

        try
        {
            System.out.println(Quotes.readFromFile(path));

        }
        catch (Exception error)
        {
            System.err.println(error);
        }

    }
}
