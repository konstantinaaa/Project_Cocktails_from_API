package repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Cocktail;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * write and read from the file
 */


public class FavoriteRepository
{
    private static ArrayList<Cocktail> theList;

    // write a file with favorites
    public void writeJson(List<Cocktail> favorite)
    {
        Gson gson = new Gson();
        String json = gson.toJson(favorite);
        try
        {
            FileWriter myWriter = new FileWriter("file.json");
            myWriter.write(json);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred. Cannot write to the file.");
            e.printStackTrace();
        }
    }



    // read from the file the favorites
    public List<Cocktail> readJson() {
        File file = new File("file.json");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("An error occurred. Cannot read the file.");
                e.printStackTrace();
            }
        }
        try {
            FileReader fileReader = new FileReader(file);

            Type type = new TypeToken<ArrayList<Cocktail>>(){}.getType();
            Gson gson = new Gson();
            theList = gson.fromJson(fileReader, type);
            fileReader.close();

        } catch (FileNotFoundException e) {
            System.err.println("Error in fileReader object");
        } catch (IOException e) {
            System.err.println("Error in closing the file.");
        }

    return theList;
    }

}
