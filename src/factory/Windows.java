package factory;

import view.CocktailFrame;

import javax.swing.*;


public class Windows implements IOperatingSystem
{

    @Override
    public void loadOperatingSystem()
    {
        ImageIcon windowsIcon = new ImageIcon("resources/icons8-windows-48.png");

        new CocktailFrame("Windows Operating System", windowsIcon);

    }
}
