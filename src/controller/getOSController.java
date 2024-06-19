package controller;

import factory.IOperatingSystem;
import factory.OSFactory;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this controller is for choosing an operating system
 */

public class getOSController implements ActionListener {

    private JComboBox comboBox;
    private OSFactory osFactory;

    public getOSController(JComboBox comboBox, OSFactory osFactory) {
        this.comboBox = comboBox;
        this.osFactory = osFactory;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBox) {
            String selectedOS = (String) comboBox.getSelectedItem();
            IOperatingSystem os = osFactory.getOS(selectedOS);

            if (os != null) {
                os.loadOperatingSystem();
            }
        }

    }
}