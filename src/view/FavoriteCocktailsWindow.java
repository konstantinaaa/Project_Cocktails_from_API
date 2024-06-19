package view;

import controller.RemoveFromFavoriteWindowController;
import model.Cocktail;
import model.FavoriteDAO;
import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
/**
 *  create the window with favorite cocktails
 */

public class FavoriteCocktailsWindow extends JFrame {

    private JPanel mainPanel;
    private FavoriteDAO favoriteDAO;

    public FavoriteCocktailsWindow() {
        favoriteDAO = new FavoriteDAO();
        this.setTitle("Favorite Cocktails");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        mainPanel = new JPanel(new GridLayout(0, 4, 10, 10));

        JScrollPane scrollPane = new JScrollPane(mainPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollPane);

        this.setSize(800,800);
        //this.pack();
        setLocationRelativeTo(null);


        // mainPanel.remove; αυτό θα μπει σε controller?
        List<Cocktail> favoriteCocktails = favoriteDAO.getAllFavorites();

        for (Cocktail cocktail : favoriteCocktails) {
            JPanel favoriteCocktailPanel = new JPanel(new BorderLayout());

            JLabel nameLabel = new JLabel(cocktail.getName());
            favoriteCocktailPanel.add(nameLabel, BorderLayout.NORTH);

            // cocktail image
            try {

                URL url = new URL(cocktail.getImageUrl());

                ImageIcon imageIcon = new ImageIcon(url);
                Image image = imageIcon.getImage();
                Image scaleImage = image.getScaledInstance(100, 120, Image.SCALE_SMOOTH);
                ImageIcon scaledImageIcon = new ImageIcon(scaleImage);

                JLabel cocktailImage = new JLabel(scaledImageIcon);
                favoriteCocktailPanel.add(cocktailImage, BorderLayout.CENTER);

                mainPanel.add(favoriteCocktailPanel);

                JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));

                // remove button
                JButton removeButton = new JButton();
                removeButton.setPreferredSize(new Dimension(20, 35));
                removeButton.addActionListener(new RemoveFromFavoriteWindowController(cocktail, favoriteCocktailPanel, favoriteDAO, mainPanel));


                // set icon to remove button
                ImageIcon removeIcon = new ImageIcon("resources/icons8-remove-32.png");
                removeButton.setIcon(removeIcon);

                removeButton.setBorder(null);
                removeButton.setOpaque(false);
                removeButton.setContentAreaFilled(false);

                buttonPanel.add(removeButton);

                favoriteCocktailPanel.add(buttonPanel, BorderLayout.SOUTH);
                mainPanel.add(favoriteCocktailPanel);


            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
