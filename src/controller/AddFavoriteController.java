package controller;

import model.Cocktail;
import model.FavoriteDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this controller adds a cocktail to favorites. it used from the cocktail panel.
 */

public class AddFavoriteController implements ActionListener
{
    private Cocktail cocktail;

    public AddFavoriteController(Cocktail cocktail) {
        this.cocktail = cocktail;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FavoriteDAO favoriteDAO = new FavoriteDAO();
        favoriteDAO.add(cocktail);
    }
}
