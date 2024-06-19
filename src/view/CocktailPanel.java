package view;

import controller.AddFavoriteController;
import controller.RemoveFavoriteController;
import model.Cocktail;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class CocktailPanel extends JPanel
{
    public CocktailPanel(Cocktail cocktail)
    {
        this.setPreferredSize(new Dimension(100,200));

        JPanel cocktailPanel = new JPanel(new BorderLayout());

        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        cocktailPanel.setBorder(border);

        // title of cocktail
        JLabel cocktailNameLabel = new JLabel(cocktail.getName());
        cocktailNameLabel.setHorizontalAlignment(JLabel.CENTER);
        cocktailNameLabel.setVerticalAlignment(JLabel.CENTER);
        cocktailPanel.add(cocktailNameLabel, BorderLayout.NORTH);

        // cocktail image
        try {
            URL url = new URL(cocktail.getImageUrl());

            ImageIcon imageIcon = new ImageIcon(url);
            Image image = imageIcon.getImage();

            Image scaleImage = image.getScaledInstance(100, 120, Image.SCALE_SMOOTH);

            ImageIcon scaledImageIcon = new ImageIcon(scaleImage);

            JLabel cocktailImage = new JLabel(scaledImageIcon);

            cocktailPanel.add(cocktailImage, BorderLayout.CENTER);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        // buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        // favorite button
        JButton favoriteButton = new JButton();
        favoriteButton.setPreferredSize(new Dimension(20,35));
        favoriteButton.addActionListener(new AddFavoriteController(cocktail));

        // set icon to the favorite button
        ImageIcon favoriteIcon = new ImageIcon("resources/icons8-favorite-32.png");
        favoriteButton.setIcon(favoriteIcon);


        // remove button
        JButton removeButton = new JButton();
        removeButton.setPreferredSize(new Dimension(20, 35));
        removeButton.addActionListener(new RemoveFavoriteController(cocktail));

        // set icon to remove button
        ImageIcon removeIcon = new ImageIcon("resources/icons8-remove-32.png");
        removeButton.setIcon(removeIcon);

        // button borders
        favoriteButton.setBorder(null);
        removeButton.setBorder(null);
        favoriteButton.setOpaque(false);
        favoriteButton.setContentAreaFilled(false);
        removeButton.setOpaque(false);
        removeButton.setContentAreaFilled(false);

        buttonPanel.add(favoriteButton);
        buttonPanel.add(removeButton);

        cocktailPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(cocktailPanel);
    }
}
