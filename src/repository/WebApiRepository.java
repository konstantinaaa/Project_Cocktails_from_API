package repository;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import model.Cocktail;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * get cocktails from the API
 */

public class WebApiRepository
{

    private static final String API_URL = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=Cocktail";
    private final Gson gson = new Gson();

    public String fetchJsonResponse() throws IOException
    {
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try(Scanner scanner = new Scanner(connection.getInputStream()))
        {
            scanner.useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        }
        finally
        {
            connection.disconnect();
        }
    }

    public List<Cocktail> getAllCocktails()
    {
        try
        {

            String jsonResponse = fetchJsonResponse();
            System.out.println("Json Response: " + jsonResponse);

            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            JsonArray drinksArray = jsonObject.getAsJsonArray("drinks");

            Type cocktailListType = new TypeToken<List<Cocktail>>(){}.getType();
            List<Cocktail> cocktails = gson.fromJson(drinksArray, cocktailListType);

            return cocktails;

        }catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public List<Cocktail> parseCocktailsFromJson(String jsonResponse)
    {
        return Collections.singletonList(gson.fromJson(jsonResponse, Cocktail.class));
    }
}
