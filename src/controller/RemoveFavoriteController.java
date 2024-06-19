package controller;

import model.Cocktail;
import model.FavoriteDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this controller removes a cocktail from favorites. It used from the cocktail Panel
 */

public class RemoveFavoriteController implements ActionListener
{
    private Cocktail cocktail;

    public RemoveFavoriteController(Cocktail cocktail) {
        this.cocktail = cocktail;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FavoriteDAO favoriteDAO = new FavoriteDAO();
        favoriteDAO.delete(cocktail);}
}
