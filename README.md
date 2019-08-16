# Lab 09 
- Start by refactoring anything that you don’t like about your solution from yesterday.
- When running the application, don’t read in the quotes file. Instead, make a request to an API to get a random quote.
please do not delete your existing code, look at the very next feature task, you will still need that code
Some examples of APIs you could choose to use:
FavQs: sign up for a free API key (takes 2 minutes) to get random quotes
Formismatic: no API key required, visit http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en to get random quotes
Star Wars Quotes API
Ron Swanson Quotes
- Rather than a Quote of the Day, please use an API that allows you to show a random quote.
- We do still have this quotes file, though, and it might still be useful! Ensure that if your app has errors in connecting to the Internet, you instead display a random quote from your file.
- When we grab a random quote from the Internet, we could add it to our file of quotes, for use if the app goes offline in the future. Add that functionality: when a quote comes back from a request, it’s also cached in the json file.

## Quotes.java
* ```
    readFromInternet() // Makes an HTTP request to the RonSwanson quote api or if no connection, gets a quote from the file.
    Will add the new quote from online to the local list.
    upDateFile() // This helper method will add the new quote to the local file of quotes.

    Quotes() // Constructor
    readFromFile() // Reads from file and uses GSON to convert into a Java object
    toString() // Prints desired values from object
* Collaborators: Brandon Hurrington, Kevin Couture
* Instructions: Open main and press run, in the CLI type ./gradlew test, or open test file and press run.
# Lab 08 
* Use the file recentquotes.json to show random popular book quotes. Your program should use GSON to parse the .json file. The app needs no functionality other than showing the quote and the author when it is run. The app should choose one quote each time it is run.

## Quotes.java
* ```
    Quotes() // Constructor
    readFromFile() // Reads from file and uses GSON to convert into a Java object
    toString() // Prints desired values from object
* Collaborators: Brandon Hurrington, Kevin Couture
* Instructions: Open main and press run, in the CLI type ./gradlew test, or open test file and press run.
