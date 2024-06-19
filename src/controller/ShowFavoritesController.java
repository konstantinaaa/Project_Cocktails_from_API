package controller;

import view.FavoriteCocktailsWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this controller shows the favorite cocktails in a new window. It used from the cocktail frame.
 */

public class ShowFavoritesController implements ActionListener
{
    public ShowFavoritesController() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FavoriteCocktailsWindow favoriteCocktailsWindow = new FavoriteCocktailsWindow();
        favoriteCocktailsWindow.setVisible(true);
    }
}
