package view;
import controller.ShowFavoritesController;
import model.Cocktail;
import repository.SingletonClass;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CocktailFrame extends JFrame
{
    /**
     * the main frame for Cocktail
     * @param title
     * @param iconUrl
     */

    public CocktailFrame(String title, ImageIcon iconUrl)
    {
        this.setTitle(title);
        Image iconImage = iconUrl.getImage();
        this.setIconImage(iconImage);

        JPanel mainPanel = new JPanel(new GridLayout(0,4,10,10));

        List<Cocktail> cocktails = SingletonClass.getInstance().getWebApiRepository().getAllCocktails();

        for (int i = 0; i < 20/*cocktails.size()*/; i++)
        {
            CocktailPanel cocktailPanel = new CocktailPanel(cocktails.get(i));
            mainPanel.add(cocktailPanel);
        }

        JScrollPane scrollPane = new JScrollPane(mainPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Favorite cocktails menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem favorite = new JMenuItem("Favorite Cocktails");
        menu.add(favorite);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        favorite.addActionListener(new ShowFavoritesController());


        this.add(scrollPane);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.repaint();
    }
}
