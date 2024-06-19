package model;

import java.util.List;

public interface IfavoriteDAO
{
    void add(Cocktail favorite);

    void delete(Cocktail favorite);

    void update(Cocktail favorite);

    List<Cocktail> getAllFavorites();

}
