package factory;

import view.CocktailFrame;

import javax.swing.*;

public class Mac implements IOperatingSystem
{
    @Override
    public void loadOperatingSystem() {

        ImageIcon macIcon = new ImageIcon("resources/icons8-mac-os-40.png");

        new CocktailFrame("Mac Operating System", macIcon);
    }
}
