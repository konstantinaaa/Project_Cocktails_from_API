package model;

import observerpattern.Subject;
import repository.SingletonClass;
import java.util.ArrayList;
import java.util.List;

public class FavoriteDAO extends Subject implements IfavoriteDAO
{
    private List<Cocktail> favorites = SingletonClass.getInstance().getFavoriteRepository().readJson();

    public FavoriteDAO()
    {
        if(favorites == null)
            favorites = new ArrayList<>();
    }

    @Override
    public void add(Cocktail favorite) {
        boolean exists = false;
        for (Cocktail fav : favorites) {
            if (fav.getCocktailID() == favorite.getCocktailID()) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            favorites.add(favorite);
            System.out.println("Added: " + favorite.getName());
            SingletonClass.getInstance().getFavoriteRepository().writeJson(favorites);
            notifyAllObservers();
        }
        else
        {
            System.out.println("Already exists: " + favorite.getName());
        }

    }

    @Override
    public void delete(Cocktail favorite)
    {
        for (int i = 0; i < favorites.size(); i++)
        {
            Cocktail fav = favorites.get(i);
            if(fav.getName().equals(favorite.getName()))
            {
                favorites.remove(i);
                SingletonClass.getInstance().getFavoriteRepository().writeJson(favorites);
                System.out.print("Deleted successfully.");
                notifyAllObservers();
                return;
            }
        }
        System.out.println("Couldn't delete " + favorite.getName());

    }

    @Override
    public void update(Cocktail favorite)
    {
        for (Cocktail fav : favorites)
        {
            if(fav.getCocktailID() == favorite.getCocktailID())
            {
                favorites.remove(fav);
                favorites.add(favorite);
                notifyAllObservers();
                break;
            }
        }

    }

    @Override
    public List<Cocktail> getAllFavorites()
    {
        return favorites;
    }
}

