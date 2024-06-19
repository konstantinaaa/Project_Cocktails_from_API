package controller;

import model.Cocktail;
import model.FavoriteDAO;
import observerpattern.ICocktailObserver;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * this controller removes a favorite cocktail from the favorite window.
 * it used from the FavoriteCocktailsWindow
 */

public class RemoveFromFavoriteWindowController implements ActionListener, ICocktailObserver {

    private Cocktail cocktail;
    private JPanel favoritePanel;
    private FavoriteDAO favoriteDAO;
    private JPanel mainPanel;

    public RemoveFromFavoriteWindowController(Cocktail cocktail, JPanel favoritePanel, FavoriteDAO favoriteDAO, JPanel mainPanel) {
        this.cocktail = cocktail;
        this.favoritePanel = favoritePanel;
        this.favoriteDAO = favoriteDAO;
        this.mainPanel = mainPanel;
        this.favoriteDAO.addObserver(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        favoriteDAO.delete(cocktail);
        favoriteDAO.notifyAllObservers();
        mainPanel.remove(favoritePanel);
    }

    @Override
    public void update() {

        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
