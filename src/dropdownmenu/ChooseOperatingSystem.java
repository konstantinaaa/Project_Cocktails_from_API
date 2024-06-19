package dropdownmenu;


import controller.getOSController;
import factory.OSFactory;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * create a window with a drop-down list of 3 choices
 */

public class ChooseOperatingSystem extends JFrame
{
    JComboBox comboBox;
    OSFactory osFactory;

    public ChooseOperatingSystem() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        osFactory = new OSFactory();

        String[] os = {"Mac OS", "Windows OS", "Linux OS"};
        comboBox = new JComboBox(os);
        comboBox.addActionListener(new getOSController(comboBox, osFactory));

        Border br = BorderFactory.createLineBorder(Color.MAGENTA);
        comboBox.setBorder(br);

        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.add(comboBox);
        this.setSize(200, 200);
        this.setVisible(true);
    }
}
