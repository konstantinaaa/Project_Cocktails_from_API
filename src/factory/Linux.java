package factory;

import view.CocktailFrame;

import javax.swing.*;

public class Linux implements IOperatingSystem
{
    @Override
    public void loadOperatingSystem() {

        ImageIcon linuxIcon = new ImageIcon("resources/icons8-linux-50.png");

        new CocktailFrame("Linux Operating System", linuxIcon);
    }
}
